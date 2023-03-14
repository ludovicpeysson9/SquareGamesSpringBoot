package com.example.demospringboot.interfaces;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.UUID;

public interface GameDAO {
    public String save(Game game);
    public void update(Game game);
    public void delete(UUID id);
}
