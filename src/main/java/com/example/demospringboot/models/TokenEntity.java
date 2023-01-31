package com.example.demospringboot.models;


import jakarta.persistence.*;

@Entity
@Table(name = "tokens")
public class TokenEntity {

    @Id
    @GeneratedValue
    @Column(name = "tokenId")
    private Long id;


    private Integer posX;
    private Integer posY;

//    @ManyToOne
//    private GameEntity game ;


    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
