package com.example.demospringboot.service;

import com.example.demospringboot.GamePlugin;
import com.example.demospringboot.GameService;
import com.example.demospringboot.TicTacToePlugin;
import com.example.demospringboot.controller.GameDTO;
import com.example.demospringboot.model.GameCreated;
import com.example.demospringboot.model.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

//    private GameFactory gameFactory;
    @Autowired
    private List<GamePlugin> gamePlugins;
    private Game game;
    private UUID id;
    private Map<UUID, Game> games = new HashMap<>();
//    public GameCreated createGameService(GameCreationParams params) {
    public GameCreated createGameService(GameCreationParams params) {

        GamePlugin gamePlugin = null;

        for(GamePlugin plugin : gamePlugins){
            if(params.getGameType().equals(plugin.getGameFactory().getId())){
                gamePlugin = plugin;
            }
        }
        if(gamePlugin == null){
            throw new RuntimeException();
        }

        int playerCount = gamePlugin.getPlayerCount();
        int boardSize = gamePlugin.getBoardSize();

//        game = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
        game = gamePlugin.getGameFactory().createGame(playerCount, boardSize);
        id = UUID.randomUUID();

        games.put(id, game);

        return new GameCreated(id , game);
    }

    @Override
    public Map<UUID, Game> getGame() {
        return games;
    }
}
