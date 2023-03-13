package com.example.demospringboot.controller;

import com.example.demospringboot.models.dto.GameDTO;
import com.example.demospringboot.models.GameCreated;
import com.example.demospringboot.models.GameCreationParams;
import com.example.demospringboot.models.entity.GameEntity;
import com.example.demospringboot.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@RestController
@RequiredArgsConstructor
@AllArgsConstructor
public class GameController {
    private static Logger LOGGER = LoggerFactory.getLogger(GameController.class);
    private Game game;
    private GameService gameService;
    private MessageSource messageSource;
    private Map<UUID, Game> games = new HashMap<>();

    @PostMapping("/games")
    public GameDTO createGame(
            @RequestBody GameCreationParams params) throws SQLException {
        System.out.println(messageSource.getMessage("lancement_partie", null, LocaleContextHolder.getLocale()));
        GameCreated gameCreated = gameService.createGame(params);
        return new GameDTO(gameCreated.getGame().getFactoryId(), gameCreated.getId(), gameCreated.getGame().getBoardSize(), gameCreated.getGame().getStatus(), gameCreated.getGame().getRemainingTokens());
    }

    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable(name = "gameId") UUID id) {
        game = gameService.getGame(id);
        return new GameDTO(game.getFactoryId(), id, game.getBoardSize(), game.getStatus(), game.getRemainingTokens());
    }

    @PutMapping("/games/{gameId}")
    public void updateGame(@PathVariable(name = "gameId") UUID id) {

    }

    @DeleteMapping("/games/{gameId}")
    public void deleteGame(@PathVariable(name = "gameId") UUID id) throws Exception {
        gameService.deleteGame(id);
    }

    @GetMapping("/api/public/games")
    public List<GameEntity> getAll() {
        System.out.println("ALO");
        LOGGER.info("SALUT JE PASSE LA");
        return gameService.getAll();
    }
}
