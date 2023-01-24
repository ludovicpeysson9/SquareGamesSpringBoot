package com.example.demospringboot.service;

import com.example.demospringboot.GameService;
import com.example.demospringboot.controller.GameDTO;
import com.example.demospringboot.model.GameCreated;
import com.example.demospringboot.model.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class GameServiceImpl implements GameService {

    private GameFactory gameFactory;
    private Game game;
    private UUID id;
    private Map<UUID, Game> games = new HashMap<>();
    public GameCreated createGameService(GameCreationParams params) {
        switch (params.getGameType()){

            case "tictactoe" : gameFactory = new TicTacToeGameFactory();
                break;

            case "taquin" : gameFactory = new TaquinGameFactory();
                break;

            case "connectfour" : gameFactory = new ConnectFourGameFactory();
                break;
        }

        game = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());
        id = UUID.randomUUID();

        games.put(id, game);

        return new GameCreated(id , game);
    }

    @Override
    public Map<UUID, Game> getGame() {
        return games;
    }
}
