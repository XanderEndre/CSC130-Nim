/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:06 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.game;
 */
package main.io.github.csc130.game;

import main.io.github.csc130.players.PlayerAI;
import main.io.github.csc130.players.PlayerHuman;
import main.io.github.csc130.players.Player;
import main.io.github.csc130.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private int numOfPiles;
	private GameBoard gameBoard;
	private List<Player> players = new ArrayList<>();

	private int turn;

	public Game(int numOfPiles) {
		gameBoard = new GameBoard(numOfPiles, 10);
	}

	public void startGame() {
		System.out.println("		NIM\n-----------------------------");
		System.out.println("	Choose type of game!\n");
		System.out.println("  - Player versus Player (PVP)");
		System.out.println("  - Player versus Computer (PVC)");
		System.out.println("  - Computer versus Computer (CVC)");
		System.out.println("\n-----------------------------");

		String gameType;
		int difficulty = 0;
		boolean gameActive = false;

		do {
			gameType = Utils.getString("Game Type: ");
			//Utils.getInt("Select a difficulty (Easy, Medium, Hard)")
			switch (gameType.toLowerCase()) {
				case "pvp" -> {
					players.add(new PlayerHuman(Utils.getString("Enter the first players name: ")));
					players.add(new PlayerHuman(Utils.getString("Enter the second players name: ")));
					gameActive = true;
				}
				case "pvc" -> {
					players.add(new PlayerHuman(Utils.getString("Enter the players name: ")));
					players.add(new PlayerAI(Utils.getString("Enter the computers name: ")));
					gameActive = true;
				}
				case "cvc" -> {
					players.add(new PlayerAI(Utils.getString("Enter the first computers name: ")));
					players.add(new PlayerAI(Utils.getString("Enter the second computers name: ")));
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

		// Restart the game
		gameBoard.resetGame();
		turn = 0;

		Player loser = null, winner = null;

		do {
			Player player = players.get(turn);

			gameBoard.displayPiles();

			player.takeTurn(gameBoard);

			if(gameBoard.checkWin()) {
				gameActive = false;
				loser = player;
				if(++turn == players.size()) turn = 0;
				winner = players.get(turn);
			}

			if(++turn == players.size()) turn = 0;
		} while(gameActive);

		if(loser != null && winner != null) {
			System.out.println(loser.getName() + " took the last stone and lost the game! The winner was " + winner.getName() + "!");
		} else {
			System.out.println("idfk who won the game");
		}
	}

}
