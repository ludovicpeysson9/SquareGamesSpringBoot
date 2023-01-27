package com.example.demospringboot.service;

import com.example.demospringboot.DAO.MemoryGameDao;
import com.example.demospringboot.DAO.MySQLGameDAO;
import com.example.demospringboot.interfaces.GamePlugin;
import com.example.demospringboot.interfaces.GameService;
import com.example.demospringboot.models.GameCreated;
import com.example.demospringboot.models.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

//    private GameFactory gameFactory;
    @Autowired
    private List<GamePlugin> gamePlugins; // Ajoute à la liste toutes les classes qui implementent GamePlugin
    @Autowired
    private MemoryGameDao memoryGameDao;
    @Autowired
    private JDBCConnection con;
    @Autowired
    MySQLGameDAO mySQLGameDAO;
    private Game game;


    public GameCreated createGameService(GameCreationParams params) throws SQLException {

        GamePlugin gamePlugin = null;

        for(GamePlugin plugin : gamePlugins){
            if(params.getGameType().equals(plugin.getGameFactory().getGameId())){
                gamePlugin = plugin;
            }
        }
        if(gamePlugin == null){
            throw new RuntimeException();
        }

        int playerCount = gamePlugin.getPlayerCount();
        int boardSize = gamePlugin.getBoardSize();

        game = gamePlugin.getGameFactory().createGame(playerCount, boardSize);

        mySQLGameDAO.saveAGame(con, game);

        UUID id = UUID.fromString(memoryGameDao.save(game));

        return new GameCreated(id, game);
    }
//    public void testInsertJDBC() throws SQLException {
//        mySQLGameDAO.saveAGame(con);
//    }

    public Game getGameService(UUID id){
        game = memoryGameDao.getGame(id);
        return game;
    }
    public void deleteGameService(UUID id) throws Exception {

        if(memoryGameDao.getGamesId().containsKey(id)){
            memoryGameDao.delete(id);
            System.out.println("Deleted");
        } else {
            throw new Exception("Il n'y a aucun jeu avec cette id");
        }
    }

}
