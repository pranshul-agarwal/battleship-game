package com.uditagarwal.game.battleship.service;

import com.uditagarwal.game.battleship.model.Coordinate;
import com.uditagarwal.game.battleship.model.PlayerMoveTarget;
import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.strategy.IMoveGenerationStrategy;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

public interface PlayerService {
    List<Player> getAllPlayers();
    Player getPlayer(int PlayerId);
    PlayerMoveTarget takeMove(int currentPlayerId);

    void takeHit(Player player, @NonNull Coordinate coordinate);

    boolean areAllShipsKilled(Player player);
}
