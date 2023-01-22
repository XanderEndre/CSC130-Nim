package io.github.csc130.nimfx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class NimGameCanvas extends Application {
    @FXML
    Canvas cvsItemsCon = new Canvas(400,200);
    @FXML
    Button takeOne;
    @FXML
    Button takeTwo;
    int totalItems = 9;
    public void drawLines(GraphicsContext gc,int numOfLines){
        int x1 = 10;
        int y1 = 15;

        int x2 = 30;
        int y2 = 15;
        for (int shape = 0; shape < numOfLines; shape++) {
            gc.strokeLine(x1,y1,x2,y2);
            x1 += 15;
            y1 -= 5;
            x2 = x1;
        }
    }
    public  void clearCanvas(GraphicsContext gc){
        gc.clearRect(0,0,400,200);
    }



    @Override
    public void start(Stage stage) throws Exception {
        GraphicsContext gc = cvsItemsCon.getGraphicsContext2D();
        int totalLines = 9;
        int x1 = 10;
        int y1 = 15;
        int x2 = 30;
        int y2 = 15;
        gc.setLineWidth(2.0);
        for (int shapes = 0; shapes < totalLines; shapes++) {
            gc.strokeLine(x1,y1,x2,y2);
            x1 += 15;
            y1 +=5;
            x2 = x1;
            System.out.println("line stroked at ("+x1+", "+y1+")");
        }
        Pane root =new Pane();
        root.setStyle("-fx-padding: 10;" +
                "-fx-border-style: solid inside;" +
                "-fx-border-width: 2;" +
                "-fx-border-insets: 5;" +
                "-fx-border-radius: 5;" +
                "-fx-border-color: blue;");
        root.getChildren().add(cvsItemsCon);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Nim game");
        stage.show();
    }

    public void takeOne(ActionEvent actionEvent) {
        GraphicsContext gc = cvsItemsCon.getGraphicsContext2D();
        clearCanvas(gc);
        drawLines(gc,totalItems-1);
    }
}
