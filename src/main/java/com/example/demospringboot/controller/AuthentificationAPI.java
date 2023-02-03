package com.example.demospringboot.controller;

import com.example.demospringboot.models.UserEntity;
import com.example.demospringboot.service.AuthentificationRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.catalina.User;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/api/public")
public class AuthentificationAPI {

    private final AuthenticationManager authenticationManager;
//    private UserDTO userDTO;
    private static final String secret = "myownsecretsecuritytokensauce";

    private final Long tokenValidity = 3600 * 1000L;


    public AuthentificationAPI(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody @Valid AuthentificationRequest request){

        try {
            final Authentication authenticate = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getUsername(),
                            request.getPassword())
            );

            final UserEntity user = (UserEntity) authenticate.getPrincipal();
            final String token = Jwts.builder().setSubject(authenticate.getName())
                    .claim("authorities", authenticate.getAuthorities()
                            .stream().map(GrantedAuthority::getAuthority)
                            .collect(Collectors.toList()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(System.currentTimeMillis() + tokenValidity))
                    .signWith(SignatureAlgorithm.HS512, secret.getBytes()).compact();

            UserDTO userDTO = new UserDTO(user.getUsername(), token);
            return ResponseEntity.ok()
                    .header(HttpHeaders.AUTHORIZATION,"Bearer " + token)
                    .body(userDTO);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
}
