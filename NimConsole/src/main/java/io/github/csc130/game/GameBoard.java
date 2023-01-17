/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.game;
 */
package io.github.csc130.game;

import java.util.Random;

public class GameBoard {
	/**
	 * The value of an index represents the number of pieces in that pile
	 */
	int[] piles = new int[3];

	public GameBoard(int maxPieces) {
		Random random = new Random();
		for (int pile : piles) {
			pile = random.nextInt(maxPieces) + 1;
		}
	}
}
