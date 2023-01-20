package com.example.demospringboot;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class GameController {

//    @Autowired
//    private GameCreationParams gameCreationParams;
    private Game game;
    private GameFactory gameFactory;

    @PostMapping("/games")
    public Game createGame(@RequestBody GameCreationParams params){

        switch (params.getGameType()){

            case "tictactoe" : gameFactory = new TicTacToeGameFactory();
                break;

            case "taquin" : gameFactory = new TaquinGameFactory();
                break;

            case "connectfour" : gameFactory = new ConnectFourGameFactory();
                break;
        }

        game = gameFactory.createGame(params.getPlayerCount(), params.getBoardSize());

        return game;
    }

    @GetMapping("/games/{gameId}")
    public Object getGame(@PathVariable String gameId){
        return null;
    }

}
