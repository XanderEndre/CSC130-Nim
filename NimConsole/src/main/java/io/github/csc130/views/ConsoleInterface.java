package io.github.csc130.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInterface implements UserInterface {
	private BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public int[] getPlayerMove(int[] board) {
		int pile = 0;
		boolean validPile = false;
		while (!validPile) {
			pile = getInt("Which pile would you like to take from? ", 1, board.length);

			if (board[pile - 1] != 0) {
				validPile = true;
			} else {
				System.out.println("You must choose a pile that has at least one piece");
			}
		}
		int pieces = getInt("How many pieces do you want to take? ", 1, board[pile - 1]);
		return new int[] {pile - 1, pieces};
	}

	private int getInt(String prompt, int min, int max) {
		String input = getInput(prompt);

		int inputValue = 0;
		boolean validInput = false;
		while (!validInput) {
			try {
				inputValue = Integer.parseInt(input);
				if (inputValue >= min && inputValue <= max) {
					validInput = true;
				} else {
					System.out.println("You must enter a number between " + min + " and " + max);
				}
			} catch (NumberFormatException e) {
				System.out.println("You must enter a whole number");
			}
		}
		return inputValue;
	}

	private String getInput(String prompt) {
		System.out.print(prompt);

		String input = "";
		boolean validInput = false;
		while (!validInput) {
			try {
				input = bRead.readLine();
				if (!input.isBlank()) {
					validInput = true;
				} else {
					System.out.println("You must enter something");
				}
			} catch (IOException e) {
				System.out.println("Error reading input");
			}
		}
		return input;
	}

	@Override
	public void displayBoard(int[] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println("Pile " + (i + 1) + ": " + board[i] + " pieces");
/*
			for (int j = 0; j < board[i]; j++) {
				System.out.print("O ");
			}
			System.out.println();
*/
		}
	}
}
