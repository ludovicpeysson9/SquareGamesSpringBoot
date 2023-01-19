package com.example.demospringboot;

import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor{

    public int getHeartbeat(){
        int heartbeat = (int) (Math.random() * (300 - 40)) + 40;
        return heartbeat;
    }

}
