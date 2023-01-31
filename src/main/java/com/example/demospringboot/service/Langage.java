//package com.example.demospringboot.service;
//
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//import java.util.Locale;
//import java.util.ResourceBundle;
//
//public class Langage {
//
//    private Locale langue;
//
//    public Langage() {
//        this.langue = Locale.forLanguageTag("fr");
//    }
//
//    ResourceBundle resourceBundle = ResourceBundle.getBundle("message", langue);
//
//    public String getMessage() {
//        String message = resourceBundle.getString("lancement_partie");
//        return message;
//    }
//
//}
