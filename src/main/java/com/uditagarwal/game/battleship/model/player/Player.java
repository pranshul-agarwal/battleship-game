package com.uditagarwal.game.battleship.model.player;

import com.uditagarwal.game.battleship.model.Board;
import com.uditagarwal.game.battleship.model.Coordinate;
import com.uditagarwal.game.battleship.model.PlayerMoveTarget;
import com.uditagarwal.game.battleship.strategy.IMoveGenerationStrategy;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class Player {

    private final Board board;
    private final int playerId;
}
