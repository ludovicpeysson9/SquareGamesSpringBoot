package com.example.demospringboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoSpringBootApplication {

    public static void main(String[] args) {


        SpringApplication.run(DemoSpringBootApplication.class, args);
        System.out.println("hello world!");
    }
}
