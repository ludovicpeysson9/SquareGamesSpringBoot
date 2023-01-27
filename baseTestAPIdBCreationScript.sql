CREATE TABLE players
(
    playerId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    nickname VARCHAR(255) NOT NULL
);

CREATE TABLE games
(
    gameId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    gameType VARCHAR(255),
    gameStatus VARCHAR(255),
    currentPlayerId INT,
    FOREIGN KEY (currentPlayerId) REFERENCES players(playerId)
);

CREATE TABLE tokens
(
    tokenId INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    posX INT,
    posY INT,
    gameId INT,
    ownerId INT,
    FOREIGN KEY (gameId) REFERENCES games(gameId),
    FOREIGN KEY (ownerId) REFERENCES players(playerId)
);

CREATE TABLE gamePlayers
(
    gameId INT,
    player1Id INT,
    player2Id INT,
    FOREIGN KEY (gameId) REFERENCES games(gameId),
    FOREIGN KEY (player1Id) REFERENCES players(playerId),
    FOREIGN KEY (player2Id) REFERENCES players(playerId)
);