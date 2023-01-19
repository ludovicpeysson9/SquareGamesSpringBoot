package com.example.demospringboot;

import org.springframework.stereotype.Service;

@Service
public class RandomHeartbeat implements HeartbeatSensor{

    public int getHeartbeat(){

        return 1;
    }

}
