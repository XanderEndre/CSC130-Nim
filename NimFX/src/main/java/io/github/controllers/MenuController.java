package io.github.controllers;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuController implements Initializable {
    @FXML
    private Button btnPlay;
    @FXML
    private Button btnQuit;
    @FXML
    private ComboBox numOfPiles;

    @Override
    public void initialize(URL url,ResourceBundle resourceBundle){
        btnQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChangeScene changeScene = new ChangeScene();
                try{
                    changeScene.sceneChange(actionEvent, "nim-game.fxml");
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        });
    }





}
