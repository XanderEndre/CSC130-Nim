/**
 * @author Xander
 * @createdOn 1/22/2023 at 7:52 PM
 * @projectName NimFXV2
 * @packageName io.github.csc130.nimfxv2.controller;
 */
package io.github.csc130.nimfxv2.controller;

import io.github.csc130.nimfxv2.ChangeScene;
import io.github.csc130.nimfxv2.model.Game;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainMenuController implements Initializable {

    //private ComboBox typeOfGame, gameDifficulty;
    @FXML
    ComboBox<String> typeOfGame, gameDifficulty;
    @FXML
    private Button btnStartGame, btnQuitGame;
    @FXML
    private TextField tbxFirstPlayer, tbxSecondPlayer;
    @FXML
    private Text tbxErrorMessage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        typeOfGame.getItems().add("Player Versus Player");
        typeOfGame.getItems().add("Player Versus Computer");
        typeOfGame.getItems().add("Computer Versus Computer");

        gameDifficulty.getItems().add("Easy");
        gameDifficulty.getItems().add("Medium");
        gameDifficulty.getItems().add("Hard");
    }

    @FXML
    void btnQuitGame(ActionEvent event) throws IOException {
        Platform.exit();
    }

    @FXML
    void btnStartGame(ActionEvent event) throws IOException {
        tbxErrorMessage.setText("");
        if (tbxFirstPlayer.getText().isEmpty() || tbxSecondPlayer.getText().isEmpty() || typeOfGame.getValue() == null || gameDifficulty.getValue() == null) {
            tbxErrorMessage.setText("One or more fields above are empty/invalid.");
        } else {
            Game game = new Game(tbxFirstPlayer.getText(), tbxSecondPlayer.getText(), typeOfGame.getValue(), gameDifficulty.getValue());

            ChangeScene scene = new ChangeScene();

            scene.sceneChange(event, "game_screen.fxml", game);

            System.out.println(game);
        }
    }
}
