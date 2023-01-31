package com.example.demospringboot.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "games")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gameId;
    private String gameType;
    private String gameStatus;

    private Integer currentPlayerId;

//    @OneToMany
//    private List<TokenEntity> tokens;

    public GameEntity(String gameType, String gameStatus, Integer currentPlayerId) {
        this.gameType = gameType;
        this.gameStatus = gameStatus;
        this.currentPlayerId = currentPlayerId;

    }

    public GameEntity() {

    }

    public Integer getGameId() {
        return gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public String getGameType(String gameType) {
        return this.gameType;
    }

    public void setGameType(String gameType) {
        this.gameType = gameType;
    }

    public String getGameStatus(String gameStatus) {
        return this.gameStatus;
    }

    public void setGameStatus(String gameStatus) {
        this.gameStatus = gameStatus;
    }
}
