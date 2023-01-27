package com.example.demospringboot.service;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class JDBCConnection {

    private static volatile JDBCConnection instance = null;
    private String url = "jdbc:mysql://localhost:6603/squareGames";
    String userName ="root";
    String pw ="helloworld";
    private Connection connection;

    private JDBCConnection(){

    }

    public final static JDBCConnection getInstance(){
        if (JDBCConnection.instance ==null){
            synchronized (JDBCConnection.class){
                if(JDBCConnection.instance==null){
                    JDBCConnection.instance = new JDBCConnection();
                    try{
                        Class.forName("com.mysql.cj.jdbc.Driver");
                    } catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return instance;
    }

    public Connection getConnection() throws SQLException{
        if(connection == null || connection.isClosed()){
            connection = DriverManager.getConnection(url, userName, pw);
        }
        return connection;
    }

}
