package com.example.demospringboot.DAO;

import com.example.demospringboot.interfaces.GameDAO;
import com.example.demospringboot.service.JDBCConnection;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.UUID;

@Component
public class MySQLGameDAOBis implements GameDAO {
    @Autowired
    private JDBCConnection con;

    @Override
    public String save(Game game){
        String saveAGameQuery = "INSERT INTO games (gameId, gameType, gameStatus, currentPlayerId) VALUES (gameId,?,?,?)";

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
        return null;
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void delete(UUID id) {

    }
}
