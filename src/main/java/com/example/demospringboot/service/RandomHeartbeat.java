package com.example.demospringboot.service;

import com.example.demospringboot.interfaces.HeartbeatSensor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class RandomHeartbeat implements HeartbeatSensor {

    private final Random random = new Random();

    public int getHeartbeat(){
        return random.nextInt() * (230 - 40) + 40;
    }

}
