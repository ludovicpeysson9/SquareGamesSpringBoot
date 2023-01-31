CREATE TABLE games
(
    game_id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    current_player_id INT,
    game_status VARCHAR(255),
    game_type VARCHAR(255)
);