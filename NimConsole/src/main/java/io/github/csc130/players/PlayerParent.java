/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.players;

import io.github.csc130.game.GameBoard;

public abstract class PlayerParent {

    private String name;

    public PlayerParent(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void takeTurn(GameBoard gameBoard);
}
