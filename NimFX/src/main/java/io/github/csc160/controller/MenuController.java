package io.github.csc160.controller;
import io.github.csc160.ChangeScene;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

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
    @FXML
    private AnchorPane anchorRoot;
    @FXML
    private StackPane parentContainer;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void loadSecond(ActionEvent event) throws IOException{
        //change scene set up(in class because I'm not sure why I can't pull it off in ChangeScene.java)
        Parent root = FXMLLoader.load(getClass().getResource("src/main/resources/nim-game.fxml"));
        Scene scene = btnPlay.getScene();
        root.translateYProperty().set(scene.getHeight());
        parentContainer.getChildren().add(root);

        //animation attempt
        Timeline timeline = new Timeline();
        KeyValue kv = new KeyValue(root.translateYProperty(), 0, Interpolator.EASE_IN);
        KeyFrame kf =  new KeyFrame(Duration.seconds(1), kv);
        timeline.getKeyFrames().add(kf);
        timeline.play();


    }



}
