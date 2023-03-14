package com.example.demospringboot.service.impl;

import com.example.demospringboot.dao.GameRepository;
import com.example.demospringboot.dao.MemoryGameDao;
import com.example.demospringboot.interfaces.GamePlugin;
import com.example.demospringboot.models.GameCreated;
import com.example.demospringboot.models.GameCreationParams;
import com.example.demospringboot.models.entity.GameEntity;
import com.example.demospringboot.service.GameService;
import fr.le_campus_numerique.square_games.engine.Game;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@AllArgsConstructor
public class GameServiceImpl implements GameService {

    private static final Logger LOGGER = LoggerFactory.getLogger(GameServiceImpl.class);
    private List<GamePlugin> gamePlugins; // Ajoute à la liste toutes les classes qui implementent GamePlugin
    private MemoryGameDao memoryGameDao;
    private GameRepository gameRepository;
    private Game game;
    public Optional<GameCreated> createGame(GameCreationParams params) {

        GamePlugin gamePlugin = null;

        for (GamePlugin plugin : gamePlugins) {
            if (params.getGameType().equals(plugin.getGameFactory().getGameId())) {
                gamePlugin = plugin;
            }
        }
        if (gamePlugin == null) {
            LOGGER.error("Plugin is null");
            return Optional.empty();
        }

        int playerCount = gamePlugin.getPlayerCount();
        int boardSize = gamePlugin.getBoardSize();
        game = gamePlugin.getGameFactory().createGame(playerCount, boardSize);
        UUID id = UUID.fromString(memoryGameDao.save(game));

        GameEntity gameEntity = GameEntity.builder()
                .gameStatus(game.getStatus().toString())
                .gameType(game.getFactoryId())
                .currentPlayerId(1).build();
        gameRepository.save(gameEntity);
        return Optional.of(new GameCreated(id, game));
    }

    public Game getGame(UUID id) {
        game = memoryGameDao.getGame(id);
        return game;
    }

    public void deleteGame(UUID id) {

        if (memoryGameDao.getGamesId().containsKey(id)) {
            memoryGameDao.delete(id);
            LOGGER.info("Deleted");
        } else {
            LOGGER.error("Il n'y a aucun jeu avec cette id");
        }
    }

    @Override
    public List<GameEntity> getAll() {
        List<GameEntity> games = gameRepository.findAll();
        if(LOGGER.isInfoEnabled())
            LOGGER.info(games.toString());
        return games;
    }

}
