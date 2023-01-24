package com.example.demospringboot.controller;

import com.example.demospringboot.model.GameCreated;
import com.example.demospringboot.model.GameCreationParams;
import com.example.demospringboot.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
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
    public GameDTO createGame(@RequestBody GameCreationParams params){

        GameCreated gameCreated = gameService.createGameService(params);
        return new GameDTO(gameCreated.getGame().getFactoryId(), gameCreated.getId(), gameCreated.getGame().getBoardSize(), gameCreated.getGame().getStatus(), gameCreated.getGame().getRemainingTokens());
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable(name = "gameId") UUID id) {

        game = gameService.getGame().get(id);

        return new GameDTO(game.getFactoryId(), id, game.getBoardSize(), game.getStatus(), game.getRemainingTokens());
    }

    @GetMapping("/games/show")
    public void showMap(){
        games = gameService.getGame();
        for(Map.Entry m : games.entrySet()){
            System.out.println(m);
        }
    }
}
