package com.uditagarwal.game.battleship.service;

import com.uditagarwal.game.battleship.model.Board;
import com.uditagarwal.game.battleship.model.Coordinate;
import lombok.NonNull;

import java.util.List;

public interface BoardService {
    void takeHit(Board board, @NonNull Coordinate coordinate);

    boolean areAllShipsKilled(Board board);

    List<Coordinate> hitLocations(Board board);

    List<Coordinate> missedLocations(Board board);
}
