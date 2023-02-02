package com.example.demospringboot.service;

import com.example.demospringboot.DAO.GameRepository;
import com.example.demospringboot.DAO.MemoryGameDao;
import com.example.demospringboot.DAO.MySQLGameDAO;
import com.example.demospringboot.DAO.MySQLGameDAOBis;
import com.example.demospringboot.interfaces.GameDAO;
import com.example.demospringboot.interfaces.GamePlugin;
import com.example.demospringboot.interfaces.GameService;
import com.example.demospringboot.models.GameCreated;
import com.example.demospringboot.models.GameCreationParams;
import com.example.demospringboot.models.GameEntity;
import com.example.demospringboot.models.UserEntity;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
    private GameRepository gameRepository;
    @Autowired
    private JDBCConnection con;
    @Autowired
    MySQLGameDAO mySQLGameDAO;


//    @Qualifier("MySQLGameDAOBis")
    @Autowired
    MySQLGameDAOBis gameDAO;
    private Game game;


    public GameCreated createGameService(GameCreationParams params) throws SQLException {

        GamePlugin gamePlugin = null;

        for (GamePlugin plugin : gamePlugins) {
            if (params.getGameType().equals(plugin.getGameFactory().getGameId())) {
                gamePlugin = plugin;
            }
        }
        if (gamePlugin == null) {
            throw new RuntimeException();
        }

        int playerCount = gamePlugin.getPlayerCount();
        int boardSize = gamePlugin.getBoardSize();

        game = gamePlugin.getGameFactory().createGame(playerCount, boardSize);

//        mySQLGameDAO.saveAGame(con, game);
        // gameDao.save(game);
        UUID id = UUID.fromString(memoryGameDao.save(game));

        GameEntity gameEntity = new GameEntity(game.getFactoryId(), game.getStatus().toString(), 1);
        gameRepository.save(gameEntity);

        return new GameCreated(id, game);
    }
//    public void testInsertJDBC() throws SQLException {
//        mySQLGameDAO.saveAGame(con);
//    }

    public Game getGameService(UUID id) {
        game = memoryGameDao.getGame(id);
        return game;
    }

    public void deleteGameService(UUID id) throws Exception {

        if (memoryGameDao.getGamesId().containsKey(id)) {
            memoryGameDao.delete(id);
            System.out.println("Deleted");
        } else {
            throw new Exception("Il n'y a aucun jeu avec cette id");
        }
    }

}
