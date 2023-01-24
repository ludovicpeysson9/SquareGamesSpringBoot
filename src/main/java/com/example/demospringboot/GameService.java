package com.example.demospringboot;

import com.example.demospringboot.controller.GameDTO;
import com.example.demospringboot.model.GameCreated;
import com.example.demospringboot.model.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;

import java.util.Map;
import java.util.UUID;

public interface GameService {
    public GameCreated createGameService(GameCreationParams params);

    public Map<UUID, Game> getGame();
}
