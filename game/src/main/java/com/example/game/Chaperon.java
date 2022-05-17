package com.example.game;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Chaperon extends Cell{

    public Chaperon(int a, int b, Rectangle front, Rectangle back) {
        super(a, b, front, back);


    }

    @Override
    public void drawCell(){
        Image img_chaperon = new Image("file:src/main/resources/com/example/game/chaperon.png");


    }
}
