/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.game;
 */
package io.github.csc130.game;

import io.github.csc130.players.PlayerHuman;
import io.github.csc130.players.PlayerParent;
import io.github.csc130.utils.Utils;
import jdk.jshell.execution.Util;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private int numOfPiles;
	private final GameBoard gameBoard = new GameBoard(10);
	private List<PlayerParent> players = new ArrayList<>();
	private final int[] aryNumOfPiles = new int[numOfPiles];
	private int turn;

	public Game(int numOfPiles) {
		this.numOfPiles = numOfPiles;
	}

	public void startGame() {
		System.out.println("		NIM\n-----------------------------");
		System.out.println("	Choose type of game!\n\n");
		System.out.println("  - Player versus Player (PVP)");
		System.out.println("  - Player versus Computer (PVP)");
		System.out.println("  - Computer versus Computer (PVP)");
		System.out.println("\n\n -----------------------------");

		String gameType;

		boolean gameActive = false;

		do {
			gameType = Utils.getString("Game Type:", true);
			switch (gameType.toLowerCase()) {
				case "pvp" -> {
					players.add(new PlayerHuman(Utils.getString("Enter the first players name:", true)));
					players.add(new PlayerHuman(Utils.getString("Enter the second players name:", true)));
					gameActive = true;
				}
				case "pvc" -> {
					players.add(new PlayerHuman(Utils.getString("Enter the players name:", true)));
					players.add(new PlayerHuman(Utils.getString("Enter the computers name:", true)));
					gameActive = true;
				}
				case "cvc" -> {
					players.add(new PlayerHuman(Utils.getString("Enter the first computers name:", true)));
					players.add(new PlayerHuman(Utils.getString("Enter the second computers name:", true)));
					gameActive = true;
				}
				case "exit" -> {
					System.out.println("The game of Nim has been ended...");
					System.exit(0);
				}
				default -> {
					System.out.println("You did not enter a valid game type...");
					break;
				}
			}
		} while (!gameActive);
	}
}
