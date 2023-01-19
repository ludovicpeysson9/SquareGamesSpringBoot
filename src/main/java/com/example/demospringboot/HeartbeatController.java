package com.example.demospringboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class HeartbeatController {

    @Autowired
    private HeartbeatSensor heartbeatSensor;

    @Autowired
    private GameCatalog gameCatalog;

    @GetMapping("/heartbeat")
    public int getHearbeat(){
        return heartbeatSensor.getHeartbeat();
    }

    @GetMapping("/getGamesIDs")
    public ArrayList<String> getGameId(){
        return gameCatalog.getGameId();
    }

}
