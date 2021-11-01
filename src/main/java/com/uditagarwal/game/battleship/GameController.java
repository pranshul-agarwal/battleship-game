package com.uditagarwal.game.battleship;

import com.uditagarwal.game.battleship.exceptions.CoordinateOutOfBoundaryException;
import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.model.PlayerMoveTarget;
import com.uditagarwal.game.battleship.io.output.IOutputPrinter;
import com.uditagarwal.game.battleship.repository.PlayerRepository;
import com.uditagarwal.game.battleship.service.GameService;
import com.uditagarwal.game.battleship.service.PlayerService;
import com.uditagarwal.game.battleship.strategy.IWinnerStrategy;
import com.uditagarwal.game.battleship.strategy.IPlayerPickingStrategy;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.List;

@AllArgsConstructor
public class GameController {
    @NonNull
    private final IOutputPrinter printer;
    @NonNull
    private final GameService gameService;
    @NonNull
    private final PlayerService playerService;

    public void start() {
        Player currentPlayer = gameService.firstPlayer();
        printer.printMsg("Starting game!");
        while (true) {
            printer.printMsg("\n\nPlayer: " + currentPlayer.getPlayerId() + " chance:");
            final PlayerMoveTarget playerMoveTarget = playerService.takeMove(currentPlayer.getPlayerId());

            try {
                playerService.takeHit(playerMoveTarget.getTargetPlayer(), playerMoveTarget.getTarget());
            } catch (CoordinateOutOfBoundaryException exception) {
                printer.printMsg("Hit was out of bounds.");
            }

            printer.printSelfBoard(currentPlayer);
            printer.printOpponentBoard(playerService.getAllPlayers(), currentPlayer);

            final Player winner = gameService.getWinner();
            if (winner != null) {
                printer.printWinner(winner);
                break;
            }
            currentPlayer = gameService.pickNextPlayer(currentPlayer.getPlayerId());
        }
    }

}
