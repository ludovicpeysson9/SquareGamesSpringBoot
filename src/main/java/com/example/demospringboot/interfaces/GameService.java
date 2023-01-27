package com.example.demospringboot.interfaces;

import com.example.demospringboot.models.GameCreated;
import com.example.demospringboot.models.GameCreationParams;
import fr.le_campus_numerique.square_games.engine.Game;

import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public interface GameService {
    public GameCreated createGameService(GameCreationParams params) throws SQLException;

    public Game getGameService(UUID id);
    public void deleteGameService(UUID id) throws Exception;

//    public void testInsertJDBC() throws SQLException;
}
