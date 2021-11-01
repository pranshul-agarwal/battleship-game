package com.uditagarwal.game.battleship.service;

import com.uditagarwal.game.battleship.exceptions.CoordinateOutOfBoundaryException;
import com.uditagarwal.game.battleship.model.Board;
import com.uditagarwal.game.battleship.model.BoardItem;
import com.uditagarwal.game.battleship.model.Coordinate;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardServiceImpl implements BoardService {
    @Override
    public void takeHit(Board board, @NonNull final Coordinate coordinate) {
        if (!board.getBoundary().contains(coordinate)) {
            throw new CoordinateOutOfBoundaryException();
        }
        board.getBombedLocations().add(coordinate);
    }
    @Override
    public boolean areAllShipsKilled(Board board) {
        for (BoardItem ship : board.getShips()) {
            if (!ship.isKilled(board.getBombedLocations())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Coordinate> hitLocations(Board board) {
        final List<Coordinate> result = new ArrayList<>();

        for (Coordinate coordinate: board.getBombedLocations()) {
            for (BoardItem ship: board.getShips()) {
                if (ship.containsCoordinate(coordinate)) {
                    result.add(coordinate);
                    break;
                }
            }
        }

        return result;
    }

    @Override
    public List<Coordinate> missedLocations(Board board) {
        final List<Coordinate> result = new ArrayList<>();

        for (Coordinate coordinate: board.getBombedLocations()) {
            boolean doesBelongToShip = false;
            for (BoardItem ship: board.getShips()) {
                if (ship.containsCoordinate(coordinate)) {
                    doesBelongToShip = true;
                    break;
                }
            }
            if (!doesBelongToShip) {
                result.add(coordinate);
            }
        }

        return result;
    }
}
