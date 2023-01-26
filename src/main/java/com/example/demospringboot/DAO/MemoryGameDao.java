package com.example.demospringboot.DAO;

import com.example.demospringboot.interfaces.GameDAO;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class MemoryGameDao implements GameDAO {

    private Map<UUID, Game> games = new HashMap<>();

    public String save(Game game){
        UUID id = UUID.randomUUID();
        games.put(id, game);
        return id.toString();
    }
    public Game getGame(UUID id){
//        Game game = games.get(id);
        return games.get(id);
    }
    public Map getGamesId(){
        return games;
    }
    public void update(Game game){

    }
    public void delete(UUID id){
        games.remove(id);
    }
}
