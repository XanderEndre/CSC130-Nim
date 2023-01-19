package io.github.controllers;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
public class ChangeScene {
    public Stage stage;
    public static Scene scene;
    private static Parent root;

    public void sceneChange(ActionEvent event, String strFXMLFileName) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource(strFXMLFileName)));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
