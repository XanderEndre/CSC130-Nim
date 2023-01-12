/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.game;
 */
package io.github.csc130.game;

public class Game {

	private final GameBoard gameBoard = new GameBoard(10);
	private final int[] players = new int[2];
	private int turn;

	public Game() {}

	public void run() {

	}
}
