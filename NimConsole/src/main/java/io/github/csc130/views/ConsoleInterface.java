package io.github.csc130.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static io.github.csc130.utils.Utils.getInt;

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

	@Override
	public void displayBoard(int[] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println("Pile " + (i + 1) + ": " + board[i] + " pieces");
		}
	}
}
