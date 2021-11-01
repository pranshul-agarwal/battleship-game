package com.uditagarwal.game.battleship.service;

import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.strategy.IPlayerPickingStrategy;
import com.uditagarwal.game.battleship.strategy.IWinnerStrategy;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameServiceImpl implements GameService {
    IWinnerStrategy winnerStrategy;
    IPlayerPickingStrategy nextPlayerStrategy;
    PlayerService playerService;

    @Override
    public Player pickNextPlayer(int currentPlayerId) {
        return playerService.getPlayer(nextPlayerStrategy.pickNextPlayer(currentPlayerId, playerService.getAllPlayers()));
    }

    @Override
    public Player firstPlayer() {
        return playerService.getPlayer(nextPlayerStrategy.firstPlayer(playerService.getAllPlayers()));
    }

    @Override
    public Player getWinner() {
        return winnerStrategy.getWinner(playerService.getAllPlayers());
    }
}
