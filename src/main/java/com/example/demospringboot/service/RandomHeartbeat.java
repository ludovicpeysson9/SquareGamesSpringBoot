package com.example.demospringboot.service;

import com.example.demospringboot.interfaces.HeartbeatSensor;
import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    public int getHeartbeat(){
        int heartbeat = (int) (Math.random() * (230 - 40)) + 40;
        return heartbeat;
    }

}
