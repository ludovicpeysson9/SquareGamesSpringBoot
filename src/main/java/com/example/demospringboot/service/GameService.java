package com.example.demospringboot.service;

import com.example.demospringboot.models.GameCreated;
import com.example.demospringboot.models.GameCreationParams;
import com.example.demospringboot.models.entity.GameEntity;
import fr.le_campus_numerique.square_games.engine.Game;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface GameService {
    Optional<GameCreated> createGame(GameCreationParams params) throws SQLException;
    Game getGame(UUID id);
    void deleteGame(UUID id);
    List<GameEntity> getAll();
}
