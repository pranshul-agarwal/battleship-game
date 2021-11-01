package com.uditagarwal.game.battleship.model;

import com.uditagarwal.game.battleship.model.boundary.IBoundary;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Board {

    private final List<BoardItem> ships;
    private final IBoundary boundary;
    private final List<Coordinate> bombedLocations;

    public Board(@NonNull final List<BoardItem> ships, @NonNull final IBoundary boundary) {
        // TODO: Validate whether ships in board's boundary
        this.ships = ships;
        this.boundary = boundary;
        this.bombedLocations = new ArrayList<>();
    }
}
