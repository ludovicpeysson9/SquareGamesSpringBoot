package com.example.demospringboot.model;

import fr.le_campus_numerique.square_games.engine.Game;

import java.util.UUID;

public class GameCreated {
    private UUID id;
    private Game game;

    public GameCreated(UUID id, Game game) {
        this.id = id;
        this.game = game;
    }

    public UUID getId() {
        return id;
    }

    public Game getGame() {
        return game;
    }
}
