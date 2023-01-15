package io.github.csc130.nimfx;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class NimGame {
    @FXML
    Canvas cvsItemsCon;
    public void drawLines(GraphicsContext gc,int numOfLines){
        gc.fillOval(10,15,30,15);
    }
}
