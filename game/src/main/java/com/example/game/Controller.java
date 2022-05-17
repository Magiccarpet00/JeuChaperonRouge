package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

public class Controller {
    @FXML
    private Label welcomeText;

    private MainVue mv;

    public Controller(MainVue v){
        this.mv = v;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    //test git
    //Felix: je sais pas a quoi ça sert le truc au dessus

    public void eventReset(){

    }

    public void eventRotate(){

    }

    public void eventExecute(){

    }

    public void dragAndDrop(){

    }

    public void rotate(){
        
    }

    public Cell selectCell(int x, int y){
        Cell c = new Cell(0,0,new Rectangle(), new Rectangle());
        for (int i = 0; i<mv.getListCells().size(); i++){
            if(mv.getListCells().get(i).getX() == x && mv.getListCells().get(i).getY() == y){
                c = mv.getListCells().get(i);
            }
        }
        return c;
    }

}