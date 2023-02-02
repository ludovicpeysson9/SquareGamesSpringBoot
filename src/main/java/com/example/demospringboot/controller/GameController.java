package com.example.demospringboot.controller;

//import com.example.demospringboot.DAO.JPADAORepository;
//import com.example.demospringboot.DAO.JPADao;
import com.example.demospringboot.DAO.MemoryGameDao;
import com.example.demospringboot.DAO.MySQLGameDAO;
import com.example.demospringboot.models.GameCreated;
import com.example.demospringboot.models.GameCreationParams;
import com.example.demospringboot.interfaces.GameService;
import com.example.demospringboot.models.UserEntity;
import com.example.demospringboot.service.JDBCConnection;
import fr.le_campus_numerique.square_games.engine.Game;
import fr.le_campus_numerique.square_games.engine.GameFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;

@RestController
public class GameController {

    private Game game;
    private GameFactory gameFactory;

    @Autowired
    private GameService gameService;
//    @Autowired

    private Locale langue;

    @Autowired
    private MemoryGameDao memoryGameDao;
    @Autowired
    private MySQLGameDAO mySQLGameDAO;
    @Autowired JDBCConnection jdbcConnection;
//    @Autowired
//    private JPADAORepository jpadaoRepository;

    private static Logger LOGGER = LoggerFactory.getLogger(GameController.class);

    private UUID id;

    @Autowired
    private MessageSource messageSource;
    private Map <UUID, Game> games = new HashMap<>();

    @PostMapping("/games")
    public GameDTO createGame(
//            @RequestHeader("Accept-Language") String langue,
                              @RequestBody GameCreationParams params) throws SQLException {
//        Locale locale = Locale.forLanguageTag(langue);
//        ResourceBundle resourceBundle = ResourceBundle.getBundle("message", LocaleContextHolder.getLocale());
        System.out.println(messageSource.getMessage("lancement_partie", null, LocaleContextHolder.getLocale()));
        GameCreated gameCreated = gameService.createGameService(params);
//        System.out.println(resourceBundle.getString("lancement_partie"));
        return new GameDTO(gameCreated.getGame().getFactoryId(), gameCreated.getId(), gameCreated.getGame().getBoardSize(), gameCreated.getGame().getStatus(), gameCreated.getGame().getRemainingTokens());
    }

//    @PostMapping("/games")
//    public @ResponseBody String addNewGame (@RequestParam String gameType, @RequestParam String gameStatus){
//        JPADao j = new JPADao();
//        j.getGameType(gameType);
//        j.getGameStatus(gameStatus);
//        JPADAORepository.save(j);
//        return "Saved";
//    }


    // Test d'inscription BDD, adapter dans service

//    @PostMapping("/games/test")
//    public void testInsert() throws SQLException {
//        gameService.testInsertJDBC();
//    }


    @GetMapping("/games/{gameId}")
    public GameDTO getGame(@PathVariable(name = "gameId") UUID id) {

        game = gameService.getGameService(id);
        return new GameDTO(game.getFactoryId(), id, game.getBoardSize(), game.getStatus(), game.getRemainingTokens());
    }

    @PutMapping("/games/{gameId}")
    public void updateGame(@PathVariable(name = "gameId") UUID id){

    }

    @DeleteMapping("/games/{gameId}")
    public void deleteGame(@PathVariable(name = "gameId") UUID id) throws Exception{

        gameService.deleteGameService(id);
    }

//    @GetMapping("/test")
//    public void testConnexion() throws SQLException {
//        JDBCConnection.getInstance().getConnection();
//        System.out.println("m");
//    }

    @GetMapping("/games")
    public void showMap(){

        games = memoryGameDao.getGamesId();
        for(Map.Entry m : games.entrySet()){
            System.out.println(m);
        }
    }
}
