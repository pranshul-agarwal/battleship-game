package com.uditagarwal.game.battleship.service;

import com.uditagarwal.game.battleship.model.Coordinate;
import com.uditagarwal.game.battleship.model.PlayerMoveTarget;
import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.repository.PlayerRepository;
import com.uditagarwal.game.battleship.strategy.IMoveGenerationStrategy;
import com.uditagarwal.game.battleship.strategy.IPlayerPickingStrategy;
import com.uditagarwal.game.battleship.strategy.IWinnerStrategy;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PlayerServiceImpl implements PlayerService {
    PlayerRepository playerRepository;
    IMoveGenerationStrategy moveGenerationStrategy;
    BoardService boardService;

    @Override
    public List<Player> getAllPlayers() {
        return playerRepository.getPlayers();
    }

    @Override
    public Player getPlayer(int playerId) {
        return playerRepository.getPlayerById(playerId);
    }

    @Override
    public PlayerMoveTarget takeMove(int currentPlayerId) {
        List<Player> allPlayers = getAllPlayers();
        List<Player> opponents = new ArrayList<>();
        for (Player player: allPlayers) {
            if (player.getPlayerId() != currentPlayerId) {
                opponents.add(player);
            }
        }
        return moveGenerationStrategy.getPlayerMoveTarget(opponents);
    }

    @Override
    public void takeHit(Player player, @NonNull final Coordinate coordinate) {
        boardService.takeHit(player.getBoard(), coordinate);
    }

    @Override
    public boolean areAllShipsKilled(Player player) {
        return boardService.areAllShipsKilled(player.getBoard());
    }
}
