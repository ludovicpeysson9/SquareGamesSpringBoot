package com.example.demospringboot.controller;

import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;

import java.util.Collection;
import java.util.UUID;

public class GameDTO {

    public String factoryId;

    public UUID id;
//    public Game game;

    public int boardSize;
    public GameStatus gameStatus;

    public Collection<Token> remainingTokens;

    public GameDTO(String factoryId, UUID id, int boardSize, GameStatus gameStatus, Collection<Token> remainingTokens){
        this.factoryId = factoryId;
        this.id = id;
        this.boardSize = boardSize;
        this.gameStatus = gameStatus;
        this.remainingTokens = remainingTokens;
    }
}
