package com.example.game;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Wolf extends Cell{
    public Wolf(int a, int b, Rectangle front, Rectangle back) {
        super(a, b, front, back);
    }

    @Override
    public void drawCell(){
        Image img_wolf = new Image("file:src/main/resources/com/example/game/wolf.png");
    }
}
