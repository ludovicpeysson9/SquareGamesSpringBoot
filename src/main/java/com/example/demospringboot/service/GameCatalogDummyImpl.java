package com.example.demospringboot.service;

import com.example.demospringboot.GameCatalog;
import fr.le_campus_numerique.square_games.engine.connectfour.ConnectFourGameFactory;
import fr.le_campus_numerique.square_games.engine.taquin.TaquinGameFactory;
import fr.le_campus_numerique.square_games.engine.tictactoe.TicTacToeGameFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Service
public class GameCatalogDummyImpl implements GameCatalog {

    private TicTacToeGameFactory ticTacToeGameFactory = new TicTacToeGameFactory();
    private TaquinGameFactory taquinGameFactory = new TaquinGameFactory();
    private ConnectFourGameFactory connectFourGameFactory = new ConnectFourGameFactory();

    public ArrayList<String> getGameId(){
        ArrayList <String> gameId = new ArrayList<>();
        gameId.add(ticTacToeGameFactory.getId());
        gameId.add(taquinGameFactory.getId());
        gameId.add(connectFourGameFactory.getId());
        return gameId;
    }

}
