/**
 * @author Xander
 * @createdOn 1/22/2023 at 9:35 PM
 * @projectName NimFXV2
 * @packageName io.github.csc130.nimfxv2.controller;
 */
package io.github.csc130.nimfxv2.controller;

import io.github.csc130.nimfxv2.ChangeScene;
import io.github.csc130.nimfxv2.model.Game;
import io.github.csc130.nimfxv2.model.GameHolder;
import io.github.csc130.nimfxv2.model.Player;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class GameController implements Initializable {

    private final List<Player> players = new ArrayList<>();
    Game game;
    @FXML
    VBox gamePanel;
    private int[] piles;
    private int turn;
    @FXML
    private Button btnMainMenu;

    @FXML
    private Button btnQuitGame;

    @FXML
    private Text playerTurn;

    private final List<Button> buttons = new ArrayList<>();

    @FXML
    void btnQuitGame(ActionEvent event) throws IOException {
        Platform.exit();
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Grab all the local data saved
        game = receieveData();

        // Add the players to an array
        players.add(game.getPlayerOne());
        players.add(game.getPlayerTwo());

        // Reset the turn count
        turn = 0;
        playerTurn.setText(players.get(turn).getName() + "'s turn!");

        // Declare a default winner and loser
        Player winner = null, loser = null;

        // Create the board
        piles = new int[game.getGameDifficultyType()];

        Random random = new Random();
        for (int i = 0; i < piles.length; i++) {
            int randomNum = random.nextInt(10) + 1;
            buttons.add(i, new Button(String.valueOf(randomNum)));

            gamePanel.getChildren().add(buttons.get(i));

           final int pileIndex = i;


            buttons.get(i).setOnAction(event -> {
                int stonesLeft = Integer.parseInt(buttons.get(pileIndex).getText());

                if (stonesLeft == 1) {
                    buttons.get(pileIndex).setDisable(true);
                }

                buttons.get(pileIndex).setText(String.valueOf(stonesLeft - 1));

                //remove a stone;
                if (++turn == players.size()) turn = 0;

                //if (event.getText().equals("0"))
                playerTurn.setText(players.get(turn).getName() + "'s turn!");
            });


        }

        btnMainMenu.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChangeScene changeScene =  new ChangeScene();
                try{
                    changeScene.sceneChange(actionEvent, "main_menu.fxml");

                } catch(IOException e){
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    private Game receieveData() {
        GameHolder holder = GameHolder.getInstance();
        return holder.getGame();
    }

}
