package com.example.demospringboot.dao;

import com.example.demospringboot.interfaces.GameDAO;
import com.example.demospringboot.service.JDBCConnection;
import fr.le_campus_numerique.square_games.engine.Game;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class MySQLGameDAOBis implements GameDAO {
    private final JDBCConnection con;
    private static final Logger LOGGER = LoggerFactory.getLogger(MySQLGameDAOBis.class);
    @Override
    public String save(Game game){
        String saveAGameQuery = "INSERT INTO games (gameId, gameType, gameStatus, currentPlayerId) VALUES (gameId,?,?,?)";

        try (PreparedStatement stmt = con.getConnection().prepareStatement(saveAGameQuery)){
            stmt.setString(1, game.getFactoryId());
            stmt.setString(2, String.valueOf(game.getStatus()));
            stmt.setInt(3, 1); // int dans la base de données
            int i = stmt.executeUpdate();
            LOGGER.info("Record ok {}", i);
            con.getConnection().close();
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(Game game) {
        // Not implemented
    }

    @Override
    public void delete(UUID id) {
        // Not implemented
    }
}
