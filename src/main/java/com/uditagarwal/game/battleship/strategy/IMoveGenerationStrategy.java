package com.uditagarwal.game.battleship.strategy;

import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.model.PlayerMoveTarget;

import java.util.List;

public interface IMoveGenerationStrategy {

    PlayerMoveTarget getPlayerMoveTarget(List<Player> opponents);
}
