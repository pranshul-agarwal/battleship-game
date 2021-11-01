package com.uditagarwal.game.battleship.repository;

import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
public class PlayerRepository {
    @Getter
    List<Player> players;

    public Player getPlayerById(int playerId) {
        return players.stream()
                .filter(p -> {
                    System.out.println(p.getPlayerId()  + " " + playerId);
                    return (p.getPlayerId() == playerId);
                })
                .findFirst()
                .orElse(null);
    }
}
