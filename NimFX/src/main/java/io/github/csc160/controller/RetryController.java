package io.github.csc160.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class RetryController implements Initializable {
    @FXML
    Button btnRetry;
    @FXML
    Button btnQuit;
//    will return the user to the main menu if clicked,doesn't end the program like "quit" does
    @FXML
    Button btnReturnToMenu;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
