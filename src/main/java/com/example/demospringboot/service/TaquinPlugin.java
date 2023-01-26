package com.example.demospringboot.service;

import com.example.demospringboot.interfaces.GamePlugin;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TaquinPlugin implements GamePlugin {

    @Value("${taquin.playerCount}")
    private int playerCount;

    @Value("${taquin.boardSize}")
    private int boardSize;

    private GameFactory gameFactory = new TaquinGameFactory();


    @Override
    public GameFactory getGameFactory() {
        return gameFactory;
    }

    @Override
    public void setGameFactory(GameFactory gameFactory) {
        this.gameFactory = gameFactory;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public int getBoardSize() {
        return boardSize;
    }

    @Override
    public String getName() {
        return null;
    }
}
