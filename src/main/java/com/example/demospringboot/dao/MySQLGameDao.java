package com.example.demospringboot.dao;

import com.example.demospringboot.interfaces.GameDAO;
import com.example.demospringboot.service.JDBCConnection;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Collection;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
@Component
public class MySQLGameDao implements GameDAO {
    private static final Logger LOGGER = LoggerFactory.getLogger(MySQLGameDao.class);
    private final JDBCConnection connection;
    private String gameType;
    private GameStatus gameStatus;
    private UUID currentPlayerId;
    private Collection<Token> remainingTokens;
    public String save(Game game){
        return UUID.randomUUID().toString();
    }
    public void saveAGame(JDBCConnection con , Game game) throws SQLException{
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
    }

    public void update(Game game){
        // Not implemented
    }
    public void delete(UUID id){
        // Not implemented
    }
}
