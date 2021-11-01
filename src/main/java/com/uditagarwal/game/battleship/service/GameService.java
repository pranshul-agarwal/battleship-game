package com.uditagarwal.game.battleship.service;

import com.uditagarwal.game.battleship.model.player.Player;

public interface GameService {
    Player firstPlayer();
    Player pickNextPlayer(int currentPlayerId);
    Player getWinner();
}
