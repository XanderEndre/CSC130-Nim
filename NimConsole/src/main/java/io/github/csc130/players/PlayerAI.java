/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.players;

import io.github.csc130.game.GameBoard;
import io.github.csc130.utils.Utils;

import java.util.Random;

public class PlayerAI extends Player {

    public PlayerAI(String name) {
        super(name);
    }

    @Override
    public void takeTurn(GameBoard gameBoard) {
        boolean validPile = false;
        int pile = 0;
        while (!validPile) {
            pile = gameBoard.getPiles().length == 1 ? 1 : new Random().nextInt(1, gameBoard.getPiles().length);

            if (gameBoard.getPiles()[pile - 1] != 0) {
                validPile = true;
            } else {
                System.out.println("You must choose a pile that has at least one piece!");
            }
        }
        gameBoard.subtractFromPile(pile,
                gameBoard.getPiles().length == 1 ? 1 : (new Random().nextInt(1, 2)),
                getName());
    }
}
