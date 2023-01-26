package com.example.demospringboot.models;

public class GameCreationParams {

    private String gameType;
    private int playerCount;
    private int boardSize;

    private String langage;

    public String getGameType(){
        return gameType;
    }
    public int getPlayerCount(){
        return playerCount;
    }
    public int getBoardSize(){
        return boardSize;
    }
    public String getLangage(){ return langage; }

}
