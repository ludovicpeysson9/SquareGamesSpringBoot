package com.example.demospringboot;

import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class GameCreated {

    public UUID id;
//    public Game game;

    public int boardsize;
    public GameStatus gameStatus;

    public Collection<Token> remainingTokens;

    public GameCreated(UUID id, int boardsize, GameStatus gameStatus, Collection<Token> remainingTokens){
        this.id = id;
        this.boardsize = boardsize;
        this.gameStatus = gameStatus;
        this.remainingTokens = remainingTokens;
    }
}
