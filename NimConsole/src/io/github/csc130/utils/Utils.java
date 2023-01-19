/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:07 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.utils;
 */
package io.github.csc130.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Utils {

    private static BufferedReader bRead = new BufferedReader(new InputStreamReader(System.in));

    public static int getInt(String prompt, int min, int max) {
        int inputValue = 0;
        boolean validInput = false;
        while (!validInput) {
            try {
                String input = getString(prompt);
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

    public static String getString(String prompt) {
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

}
