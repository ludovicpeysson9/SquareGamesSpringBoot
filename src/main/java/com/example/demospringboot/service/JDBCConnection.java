package com.example.demospringboot.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class JDBCConnection {
    private final JDBCConnection INSTANCE;
    private String url = "jdbc:mysql://localhost:6603/squareGames";
    String userName = "root";
    String pw = "helloworld";
    private Connection connection;

    public  JDBCConnection getINSTANCE() {
        return INSTANCE;
    }

    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(url, userName, pw);
        }
        return connection;
    }

}
