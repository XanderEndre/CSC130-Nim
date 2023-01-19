package io.github.csc130.nimfx;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

public class NimGame extends Application {
    @FXML
    Canvas cvsItemsCon = new Canvas();
    public void drawLines(GraphicsContext gc,int numOfLines){
        int x1 = 10;
        int y1 = 15;
        int x2 = 30;
        int y2 = 15;
        for (int shape = 0; shape < numOfLines; shape++) {
            gc.strokeLine(x1,y1,x2,y2);
            x1 += 10;
            x2 = x1*2;
        }

    }


    @Override
    public void start(Stage stage) throws Exception {
        Group groupObject = new Group();
        GraphicsContext gc = cvsItemsCon.getGraphicsContext2D();
        int totalLines = 9;
        int x1 = 10;
        int y1 = 15;
        int x2 = 30;
        int y2 = 15;
        gc.setLineWidth(5);
        for (int shapes = 0; shapes < totalLines; shapes++) {
            gc.strokeLine(x1,y1,x2,y2);
            x1 += 10;
            x2 = x1*2;
        }
        groupObject.getChildren().add(cvsItemsCon);
        Scene sceneObj = new Scene(groupObject);
        stage.setScene(sceneObj);
    }
}
