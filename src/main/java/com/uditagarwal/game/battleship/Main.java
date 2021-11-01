package com.uditagarwal.game.battleship;

import com.uditagarwal.game.battleship.io.input.IInputProvider;
import com.uditagarwal.game.battleship.io.input.SysInInputProvider;
import com.uditagarwal.game.battleship.model.Ship;
import com.uditagarwal.game.battleship.model.boundary.RectangularBoundary;
import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.io.output.SysOutOutputPrinter;
import com.uditagarwal.game.battleship.model.Board;
import com.uditagarwal.game.battleship.model.boundary.IBoundary;
import com.uditagarwal.game.battleship.model.Coordinate;
import com.uditagarwal.game.battleship.model.BoardItem;
import com.uditagarwal.game.battleship.repository.PlayerRepository;
import com.uditagarwal.game.battleship.service.*;
import com.uditagarwal.game.battleship.strategy.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        //SpringApplication.run(ParkingLotApplication.class, args);
        final IInputProvider inputProvider = new SysInInputProvider();
        List<Player> players = new ArrayList<>();
        players.add(getPlayer1());
        players.add(getPlayer2());
        IMoveGenerationStrategy moveGenerationStrategy = new LocalMoveGeneration(inputProvider);
        PlayerRepository playerRepository = new PlayerRepository(players);
        BoardService boardService = new BoardServiceImpl();
        PlayerService playerService = new PlayerServiceImpl(playerRepository, moveGenerationStrategy, boardService);
        GameService gameService = new GameServiceImpl(new DefaultWinnerStrategy(playerService), new RoundRobinPlayerPickingStrategy(), playerService);
        GameController gameController = new GameController(
                new SysOutOutputPrinter(boardService),
                gameService,
                playerService);
        gameController.start();
    }

    private static Player getPlayer1() {
        final IBoundary boardBoundary = new RectangularBoundary(new Coordinate(0, 10), new Coordinate(10, 0));

        BoardItem ship1 = new Ship("Carrier", new RectangularBoundary(new Coordinate(0, 7), new Coordinate(4,7)));
        BoardItem ship2 = new Ship("Battleship", new RectangularBoundary(new Coordinate(4, 1), new Coordinate(4,4)));
        BoardItem ship3 = new Ship("Cruiser", new RectangularBoundary(new Coordinate(7, 3), new Coordinate(7, 5)));
        BoardItem ship4 = new Ship("Destroyer", new RectangularBoundary(new Coordinate(4, 9), new Coordinate(6,9)));
        BoardItem ship5 = new Ship("Submarine", new RectangularBoundary(new Coordinate(3, 6), new Coordinate(4,3)));

        ArrayList<BoardItem> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);
        ships.add(ship5);

        Board board = new Board(ships, boardBoundary);

        return new Player(board, 0);
    }

    private static Player getPlayer2() {
        final IBoundary boardBoundary = new RectangularBoundary(new Coordinate(0, 10), new Coordinate(10, 0));

        BoardItem ship1 = new Ship("Carrier", new RectangularBoundary(new Coordinate(0, 7), new Coordinate(4,7)));
        BoardItem ship2 = new Ship("Battleship", new RectangularBoundary(new Coordinate(4, 1), new Coordinate(4,4)));
        BoardItem ship3 = new Ship("Cruiser", new RectangularBoundary(new Coordinate(7, 3), new Coordinate(7, 5)));
        BoardItem ship4 = new Ship("Destroyer", new RectangularBoundary(new Coordinate(4, 9), new Coordinate(6,9)));
        BoardItem ship5 = new Ship("Submarine", new RectangularBoundary(new Coordinate(3, 6), new Coordinate(4,3)));

        ArrayList<BoardItem> ships = new ArrayList<>();
        ships.add(ship1);
        ships.add(ship2);
        ships.add(ship3);
        ships.add(ship4);
        ships.add(ship5);

        Board board = new Board(ships, boardBoundary);

        return new Player(board, 1);
    }
}
