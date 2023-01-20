package com.example.demospringboot;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class GameCreationParams {

    private String gameType;
    private int playerCount;
    private int boardSize;

    public String getGameType(){
        return gameType;
    }
    public int getPlayerCount(){
        return playerCount;
    }
    public int getBoardSize(){
        return boardSize;
    }

}
