package com.example.demospringboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoSpringBootApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoSpringBootApplication.class);
    public static void main(String[] args) {


        SpringApplication.run(DemoSpringBootApplication.class, args);
        LOGGER.info("hello world!");
    }
}
