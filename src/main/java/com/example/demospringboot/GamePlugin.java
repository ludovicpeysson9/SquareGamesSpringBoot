package com.example.demospringboot;

import com.example.demospringboot.model.GameCreated;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;

import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;

public interface GamePlugin {

    GameFactory getGameFactory();

    void setGameFactory(GameFactory gameFactory);

    int getPlayerCount();

    int getBoardSize();

    String getName();
}
