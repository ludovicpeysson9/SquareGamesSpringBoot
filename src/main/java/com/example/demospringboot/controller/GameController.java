package com.example.demospringboot.controller;

import com.example.demospringboot.model.GameCreated;
import com.example.demospringboot.model.GameCreationParams;
import com.example.demospringboot.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class GameController {

//    @Autowired
//    private GameCreationParams gameCreationParams;
    private Game game;
    private GameFactory gameFactory;

    @Autowired
    private GameService gameService;
    private UUID id;

    private Map <UUID, Game> games = new HashMap<>();

    @PostMapping("/games")
    public GameCreated createGame(@RequestBody GameCreationParams params){

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
        return new GameCreated(id, game.getBoardSize(), game.getStatus(), game.getRemainingTokens());
    }

    @GetMapping("/games/{gameId}")
    public GameCreated getGame(@PathVariable(name = "gameId") UUID id) {
// TODO - actually get and return game with id 'gameId'
        game = games.get(id);

        return new GameCreated(id, game.getBoardSize(), game.getStatus(), game.getRemainingTokens());
    }

    @GetMapping("/games/show")
    public void showMap(){
        for(Map.Entry m : games.entrySet()){
            System.out.println(m);
        }
    }

}
