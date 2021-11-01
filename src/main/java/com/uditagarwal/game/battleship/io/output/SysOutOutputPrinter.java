package com.uditagarwal.game.battleship.io.output;

import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.service.BoardService;
import com.uditagarwal.game.battleship.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class SysOutOutputPrinter implements IOutputPrinter {
    BoardService boardService;

    @Override
    public void printMsg(String msg) {
        System.out.println(msg);
    }

    @Override
    public void printWinner(@NonNull final Player player) {
        System.out.println("Game Finished!");
        System.out.println("Player: " + player.getPlayerId() + " won");
    }

    private void printPlayerInfo(@NonNull final Player player) {
        printMsg("Player: " + player.getPlayerId());
    }

    @Override
    public void printSelfBoard(@NonNull final Player player) {
        printMsg("Your board status: ");
        printPlayerInfo(player);
        printMsg("Board boundary: " + player.getBoard().getBoundary());
        printMsg("Ships: " + player.getBoard().getShips());
        printMsg("Hit locations: " + boardService.hitLocations(player.getBoard()));
        printMsg("Missed locations: " + boardService.missedLocations(player.getBoard()));
    }

    private void printOpponentBoard(@NonNull final Player player) {
        printMsg("\nOpponent board status: ");
        printPlayerInfo(player);
        printMsg("Board boundary: " + player.getBoard().getBoundary());
        printMsg("Hit locations: " + boardService.hitLocations(player.getBoard()));
        printMsg("Missed locations: " + boardService.missedLocations(player.getBoard()));
    }

    @Override
    public void printOpponentBoard(@NonNull final List<Player> allPlayers, @NonNull final Player currentPlayer) {

        for (Player player : allPlayers) {
            if (player.getPlayerId() != currentPlayer.getPlayerId()) {
                printOpponentBoard(player);
            }
        }
    }
}
