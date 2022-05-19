package com.example.game;

import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Path {
    private int type;

    private double x, y;

    private boolean onGrid;
    private Rectangle tile;

    Image path1 = new Image("file:src/main/resources/com/example/game/path1.png");
    Image path2 = new Image("file:src/main/resources/com/example/game/path2.png");
    Image path3 = new Image("file:src/main/resources/com/example/game/path3.png");
    Image path4 = new Image("file:src/main/resources/com/example/game/path4.png");
    Image path5 = new Image("file:src/main/resources/com/example/game/path5.png");

    public Rectangle getTile() {
        return tile;
    }

    //constructeur pas forcement pertinant
    public Path(int type, double x, double y){
        this.type = type;
        this.x = x;
        this.y = y;
        this.tile = new Rectangle(x, y, 140,70);
        this.tile.setOnMousePressed(event -> {
            if (event.getButton() == MouseButton.SECONDARY){
                rotate(this.tile) ;
            }
        });
    }

    public void rotate(Node node){
        switch ((int) node.getRotate()){
            case 0:
                node.setRotate(90);
                break;

            case 90:
                node.setRotate(180);
                break;

            case 180:
                node.setRotate(270);
                break;

            case 270:
                node.setRotate(0);
                break;
        }
    }

    public void drawPath(){
        switch (this.type){
            case 0 :
                this.tile.setFill(new ImagePattern(path1));
                break;
            case 1 :
                this.tile.setFill(new ImagePattern(path2));
                break;
            case 2 :
                this.tile.setFill(new ImagePattern(path3));
                break;
            case 3 :
                this.tile.setFill(new ImagePattern(path4));
                break;
            case 4 :
                this.tile.setFill(new ImagePattern(path5));
                break;
        }
        this.tile.setArcHeight(10);
        this.tile.setArcWidth(10);
    }
}
