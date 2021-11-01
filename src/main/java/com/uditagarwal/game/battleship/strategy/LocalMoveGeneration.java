package com.uditagarwal.game.battleship.strategy;

import com.uditagarwal.game.battleship.io.input.IInputProvider;
import com.uditagarwal.game.battleship.io.input.PlayerInput;
import com.uditagarwal.game.battleship.model.player.Player;
import com.uditagarwal.game.battleship.exceptions.InvalidInputException;
import com.uditagarwal.game.battleship.model.Coordinate;
import com.uditagarwal.game.battleship.model.PlayerMoveTarget;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class LocalMoveGeneration implements IMoveGenerationStrategy {

    private final IInputProvider inputProvider;

    @Override
    public PlayerMoveTarget getPlayerMoveTarget(@NonNull final List<Player> opponents) {
        final PlayerInput playerInput = inputProvider.takeInput();
        Player targetPlayer = opponents.stream()
                .filter(p -> p.getPlayerId() == playerInput.getPlayerNum())
                .findFirst()
                .orElse(null);

        if (targetPlayer == null) {
            throw new InvalidInputException();
        }
        return new PlayerMoveTarget(targetPlayer, new Coordinate(playerInput.getTargetX(), playerInput.getTargetY()));
    }
}
