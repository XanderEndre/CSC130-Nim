/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.players;
 */
package io.github.csc130.players;

import io.github.csc130.game.GameBoard;
import io.github.csc130.utils.Utils;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class PlayerAI extends Player {

    public PlayerAI(String name) {
        super(name);
    }

    @Override
    public void takeTurn(GameBoard gameBoard) {
        boolean validPile = false;
        int pile = 0;

        ArrayList<Integer> listOPiles = new ArrayList<>();
        while (!validPile) {
            // Empty all the list of piles
            listOPiles.clear();

            // Iterate over all piles
            for(int i = 0; i < gameBoard.getPiles().length; i++) {
                // check if the pile is empty
                if(gameBoard.getPiles()[i] != 0) {
                    listOPiles.add(i);
                }
            }

            pile = listOPiles.size() == 1 ? listOPiles.get(0) : listOPiles.get(new Random().nextInt(0, listOPiles.size() - 1));

            if (gameBoard.getPiles()[pile] > 0) {
                validPile = true;
            } else {
                System.out.println("AI // You must choose a pile that has at least one piece!");
            }
        }
        gameBoard.subtractFromPile(pile,
                gameBoard.getPiles().length == 1 ? 1 : (new Random().nextInt(1, 3)),
                getName());
    }
}
