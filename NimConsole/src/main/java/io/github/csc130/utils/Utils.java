/**
 * @author Xander
 * @createdOn 1/12/2023 at 2:07 PM
 * @projectName NimConsole
 * @packageName io.github.csc130.utils;
 */
package io.github.csc130.utils;

import java.io.BufferedReader;
import java.io.IOException;

public class Utils {

    BufferedReader bufferedReader = new BufferedReader();

    private String getMessage(String message, boolean required) throws IOException {
        String response = null;
        do {
            System.out.println(message);
            response = bufferedReader.readLine();
            if (response.isBlank() || required) {
                response = null;
                System.out.println("Error // A valid response is required");
            }
        } while (response == null);
        return response;
    }
}
