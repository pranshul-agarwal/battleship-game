package com.uditagarwal.game.battleship.strategy;

import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.service.PlayerService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class DefaultWinnerStrategy implements IWinnerStrategy {
    PlayerService playerService;
    @Override
    public Player getWinner(@NonNull final List<Player> playerList) {
        final List<Player> alivePlayers = new ArrayList<>();
        for (Player player : playerList) {
            if (!playerService.areAllShipsKilled(player)) {
                alivePlayers.add(player);
            }
        }
        if (alivePlayers.size() == 1) {
            return alivePlayers.get(0);
        }
        return null;
    }
}
