package io.github.csc130.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInterface implements UserInterface {
	private BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in));

	private String getInput(String prompt) {
		System.out.print(prompt);

		String input = "";
		try {
			input = bRead.readLine();
		} catch (IOException e) {
			System.out.println("Error reading input");
		}
		return input;
	}

	private int getInt(String prompt) {
		String input = getInput(prompt);
		int inputValue;
		try {
			inputValue = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("You must enter a whole number");
			inputValue = getInt(prompt);
		}
		return inputValue;
	}

	@Override
	public int getPlayerMove() {
		return getInt("How many pieces do you want to take? ");
	}

	@Override
	public void displayBoard(int board) {
		System.out.println("There are " + board + " pieces left");
	}
}
