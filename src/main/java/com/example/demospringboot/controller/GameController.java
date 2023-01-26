package com.example.demospringboot.controller;

import com.example.demospringboot.DAO.MemoryGameDao;
import com.example.demospringboot.models.GameCreated;
import com.example.demospringboot.models.GameCreationParams;
import com.example.demospringboot.interfaces.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class GameController {

    private Game game;
    private GameFactory gameFactory;

    @Autowired
    private GameService gameService;

    @Autowired
    private MemoryGameDao memoryGameDao;

    private UUID id;

    private Map <UUID, Game> games = new HashMap<>();

    @PostMapping("/games")
    public GameDTO createGame(@RequestBody GameCreationParams params){

        GameCreated gameCreated = gameService.createGameService(params);
        return new GameDTO(gameCreated.getGame().getFactoryId(), gameCreated.getId(), gameCreated.getGame().getBoardSize(), gameCreated.getGame().getStatus(), gameCreated.getGame().getRemainingTokens());
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable(name = "gameId") UUID id) {

        game = gameService.getGameService(id);
        return new GameDTO(game.getFactoryId(), id, game.getBoardSize(), game.getStatus(), game.getRemainingTokens());
    }

    @DeleteMapping("/games/{gameId}")
    public void deleteGame(@PathVariable(name = "gameId") UUID id) throws Exception {

        gameService.deleteGameService(id);
    }

    @GetMapping("/games")
    public void showMap(){

        games = memoryGameDao.getGamesId();
        for(Map.Entry m : games.entrySet()){
            System.out.println(m);
        }
    }
}
