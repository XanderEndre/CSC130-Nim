/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.players;

import io.github.csc130.game.GameBoard;
import io.github.csc130.utils.Utils;

public class PlayerHuman extends Player {

    public PlayerHuman(String name) {
        super(name);
    }

    @Override
    public void takeTurn(GameBoard gameBoard) {
        boolean validPile = false;
        int pile = 0;
        while (!validPile) {
            pile = Utils.getInt(getName() + " which pile would you like to pick from: ", 1, gameBoard.getPiles().length);

            if (gameBoard.getPiles()[pile - 1] > 0) {
                validPile = true;
            } else {
                System.out.println("PLAYER // You must choose a pile that has at least one piece!");
            }
        }
        gameBoard.subtractFromPile(pile - 1, Utils.getInt("How many pieces do you want to take: ", 1, gameBoard.getPiles()[pile - 1] >= 2 ? 2 : 1), getName());
    }
}
