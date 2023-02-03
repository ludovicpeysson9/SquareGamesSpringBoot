package com.example.demospringboot.controller;


import org.springframework.stereotype.Component;

//@Component
public class UserDTO {

    public String username;
    public String token;

    public UserDTO(String username, String token) {
        this.username = username;
        this.token = token;
    }

}
