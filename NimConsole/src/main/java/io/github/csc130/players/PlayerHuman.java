/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.players;

import io.github.csc130.game.GameBoard;

public class PlayerHuman extends PlayerParent {

    public PlayerHuman(String name) {
        super(name);
    }

    @Override
    public void takeTurn(GameBoard gameBoard) {}
}
