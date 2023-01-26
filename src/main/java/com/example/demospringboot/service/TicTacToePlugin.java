package com.example.demospringboot.service;

import com.example.demospringboot.interfaces.GamePlugin;
import fr.le_campus_numerique.square_games.engine.*;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class TicTacToePlugin implements GamePlugin {

    @Value("${tictactoe.playerCount}")
    private int playerCount;

    @Value("${tictactoe.boardSize}")
    private int boardSize;

    private GameFactory gameFactory = new TicTacToeGameFactory();


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
