package com.example.game;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell {

    private int x,y;

    private Rectangle rectFront;
    private Rectangle rectBack;

    Image img_wolf = new Image("file:src/main/resources/com/example/game/wolf.png");
    Image img_tree = new Image("file:src/main/resources/com/example/game/tree.png");
    Image img_chaperon = new Image("file:src/main/resources/com/example/game/chaperon.png");

    public Cell(int a,int b, Rectangle front, Rectangle back){
        this.x = a;
        this.y = b;
        this.rectFront = front;
        this.rectBack = back;
    }

    public void drawCell(){
        strokeCell();

        //back
        rectBack.setFill(Color.GREEN);
        rectBack.setArcHeight(10);
        rectBack.setArcWidth(10);

        //front
        rectFront.setFill(Color.TRANSPARENT);
        rectFront.setArcHeight(10);
        rectFront.setArcWidth(10);
    }

    public void strokeCell(){
        rectFront.setStroke(Color.BLACK);
        rectBack.setStroke(Color.BLACK);
    }

    public int getX() {
        return x;
    }

    public int getY(){
        return y;
    }

    public void drawTemp() {
        rectFront.setFill(Color.BLUEVIOLET);
    }


}
