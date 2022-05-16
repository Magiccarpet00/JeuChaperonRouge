package com.example.game;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell {

    private int x,y;

    private Rectangle rectFront;
    private Rectangle rectBack;

    public Cell(int a,int b, Rectangle front, Rectangle back){
        this.x = a;
        this.y = b;
        this.rectFront = front;
        this.rectBack = back;
    }

    public void drawCell(){

        //back
        rectBack.setFill(Color.GREEN);
        //front
        rectFront.setFill(Color.TRANSPARENT);
    }

}
