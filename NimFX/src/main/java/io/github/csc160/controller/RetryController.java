package io.github.csc160.controller;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;

import java.net.URL;
import java.util.ResourceBundle;

public class RetryController extends Application {
    @FXML
    Button btnRetry;
    @FXML
    Button btnQuit;
//    will return the user to the main menu if clicked,doesn't end the program like "quit" does
    @FXML
    Button btnReturnToMenu;

    @Override
    public void start(Stage stage) throws Exception {
        btnQuit.setOnAction((ActionEvent event) ->{
            Platform.exit();
        });

    }

}
