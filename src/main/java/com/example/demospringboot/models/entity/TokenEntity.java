package com.example.demospringboot.models.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tokens")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TokenEntity {

    @Id
    @GeneratedValue
    @Column(name = "tokenId")
    private Long id;
    private Integer posX;
    private Integer posY;
}
