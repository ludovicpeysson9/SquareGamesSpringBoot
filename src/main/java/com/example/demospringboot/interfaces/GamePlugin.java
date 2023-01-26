package com.example.demospringboot.interfaces;

import fr.le_campus_numerique.square_games.engine.GameFactory;

public interface GamePlugin {

    GameFactory getGameFactory();

    void setGameFactory(GameFactory gameFactory);

    int getPlayerCount();

    int getBoardSize();

    String getName();
}
