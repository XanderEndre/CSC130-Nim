package io.github.csc130.views;

public interface UserInterface {
	/**
	 * Gets the pile and number of pieces for a player's turn
	 * @param board the current state of the board. Used to confirm the player has made a valid move
	 * @return an array where the first element is the pile and the second element is the number of pieces
	 */
	int[] getPlayerMove(int[] board);
	void displayBoard(int[] board);
}
