package com.uditagarwal.game.battleship.model;

import com.uditagarwal.game.battleship.model.player.Player;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PlayerMoveTarget {

    final Player targetPlayer;
    final Coordinate target;
}
