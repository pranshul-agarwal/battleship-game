package com.uditagarwal.game.battleship.model;

import com.uditagarwal.game.battleship.model.boundary.IBoundary;

public class Ship extends BoardItem {
    public Ship(String name, IBoundary boundary) {
        super(name, boundary);
    }
}
