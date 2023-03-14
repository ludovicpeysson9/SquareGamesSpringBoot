package com.example.demospringboot.models.dto;

import fr.le_campus_numerique.square_games.engine.GameStatus;
import fr.le_campus_numerique.square_games.engine.Token;
import lombok.*;

import java.util.Collection;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class GameDTO {
    private String factoryId;
    private UUID id;
    private int boardSize;
    private GameStatus gameStatus;
    private Collection<Token> remainingTokens;
}
