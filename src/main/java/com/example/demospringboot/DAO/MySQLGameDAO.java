package com.example.demospringboot.DAO;

import com.example.demospringboot.interfaces.GameDAO;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;


import java.util.Collection;
import java.util.UUID;


public class MySQLGameDAO implements GameDAO {

    private String gameType;
    private int gameId;
    private GameStatus gameStatus;
    private Collection<Token> remainingTokens;

    public MySQLGameDAO(String gameType, int gameId, GameStatus gameStatus, Collection<Token> remainingTokens) {
        this.gameType = gameType;
        this.gameId = gameId;
        this.gameStatus = gameStatus;
        this.remainingTokens = remainingTokens;
    }

    public String getGameType() {
        return gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

//    public UUID getGameId(Game game) {
//        return gameId;
//    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Collection<Token> getRemainingTokens() {
        return remainingTokens;
    }

    public void setRemainingTokens(Collection<Token> remainingTokens) {
        this.remainingTokens = remainingTokens;
    }

    public String save(Game game){
        UUID id = UUID.randomUUID();
        return id.toString();
    }
    public void update(Game game){}
    public void delete(UUID id){}
}
