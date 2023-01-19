/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.game;
 */
package main.io.github.csc130.game;

import java.util.Arrays;
import java.util.Random;

public class GameBoard {
    /**
     * The value of an index represents the number of pieces in that pile
     */
    int[] piles;
    int maxPieces;

    public GameBoard(int numPiles, int maxPieces) {
        piles = new int[numPiles];
        this.maxPieces = maxPieces;
    }

    public void subtractFromPile(int pile, int quantity, String name) {
        piles[pile] -= quantity;

        System.out.println(name + " took " + quantity + " from pile " + pile + "! Remaining pieces: " + piles[pile]);
    }

    public void resetGame() {
        emptyPiles();
        fillPiles();
    }

    public int[] getPiles() {
        return piles;
    }

    public void displayPiles() {
        for (int i = 0; i < piles.length; i++) {
            System.out.println("Pile " + (i + 1) + ": " + piles[i] + " pieces");
        }
    }

    public void fillPiles() {
        Random random = new Random();
        for (int i = 0; i < piles.length; i++) {
            piles[i] = random.nextInt(maxPieces) + 1;
        }
    }

    public void emptyPiles() {
        Arrays.fill(piles, 0);
    }

    public boolean checkWin() {
        return Arrays.stream(piles).allMatch(i -> i == 0);
    }

}
