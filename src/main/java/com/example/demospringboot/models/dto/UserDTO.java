package com.example.demospringboot.models.dto;


import lombok.*;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class UserDTO {
    public String username;
    public String token;
}
