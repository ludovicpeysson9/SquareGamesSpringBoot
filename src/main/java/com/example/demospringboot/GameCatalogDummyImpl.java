package com.example.demospringboot;

import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Service
public class GameCatalogDummyImpl implements GameCatalog{

    private TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();

    public ArrayList<String> getGameId(){
        ArrayList <String> gameId = new ArrayList<>();
        gameId.add(ticTacToeGameFactory.getId());
        return gameId;
    }

}
