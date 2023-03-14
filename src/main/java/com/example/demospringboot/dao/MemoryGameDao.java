package com.example.demospringboot.dao;

import com.example.demospringboot.interfaces.GameDAO;
import fr.le_campus_numerique.square_games.engine.Game;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class MemoryGameDao implements GameDAO {

    private static final Map<UUID, Game> GAME_HASH_MAP = new HashMap<>();

    public String save(Game game){
        UUID id = UUID.randomUUID();
        GAME_HASH_MAP.put(id, game);
        return id.toString();
    }
    public Game getGame(UUID id){
        return GAME_HASH_MAP.get(id);
    }
    public Map<UUID,Game> getGamesId(){
        return GAME_HASH_MAP;
    }
    public void update(Game game){
        // Not implemented
    }
    public void delete(UUID id){
        GAME_HASH_MAP.remove(id);
    }
}
