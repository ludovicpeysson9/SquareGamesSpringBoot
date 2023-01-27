package com.example.demospringboot.DAO;

import com.example.demospringboot.interfaces.GameDAO;
import com.example.demospringboot.service.JDBCConnection;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;
import org.springframework.stereotype.Component;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

@Component
public class MySQLGameDAO implements GameDAO {


    private String gameType;

    private int gameId;
    private GameStatus gameStatus;
    private UUID currentPlayerId;
    private Collection<Token> remainingTokens;
    String saveAGameQuery = "INSERT INTO games (gameId, gameType, gameStatus, currentPlayerId) VALUES (gameId,?,?,?)";


//    public MySQLGameDAO(String gameType, int gameId, GameStatus gameStatus, Collection<Token> remainingTokens) {
//        this.gameType = gameType;
//        this.gameId = gameId;
//        this.gameStatus = gameStatus;
//        this.remainingTokens = remainingTokens;
//    }

    public String getGameType(Game game) {
        return gameType;
    }


    public void setGameType(String gameType) {
        this.gameType = gameType;
    }


    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public GameStatus getGameStatus(Game game) {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public UUID getCurrentPlayerId(Game game){ return currentPlayerId;}
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
    public void saveAGame(JDBCConnection con, Game game) throws SQLException{

        try (PreparedStatement stmt = con.getConnection().prepareStatement(saveAGameQuery)){
            stmt.setString(1, game.getFactoryId());
            stmt.setString(2, String.valueOf(game.getStatus()));
//            stmt.setString(3, game.getCurrentPlayerId().toString());
            stmt.setInt(3, 1); // int dans la base de données
            int i = stmt.executeUpdate();
            System.out.println(i+"record ok");
            con.getConnection().close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void update(Game game){}
    public void delete(UUID id){}
}
