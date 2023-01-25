package com.example.demospringboot;

import com.example.demospringboot.model.GameCreated;
import fr.le_campus_numerique.square_games.engine.*;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Collection;
import java.util.Map;
import java.util.UUID;

@PropertySource("application.properties")
@Component
public class TicTacToePlugin implements GamePlugin{

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
}
