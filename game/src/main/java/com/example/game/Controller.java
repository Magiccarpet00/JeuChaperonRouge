package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.io.File;

public class Controller {
    @FXML
    private Label welcomeText;

    private MainVue mv;

    //public File doc = new File("config.txt");
    //public BufferedReader obj = new BufferedReader(new FileReader(doc));


    public Controller(MainVue v) throws FileNotFoundException {
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

    public int[] tabNiveau() throws IOException {
        File doc = new File("src\\main\\resources\\config.txt");
        BufferedReader obj = new BufferedReader(new FileReader(doc));
        int[] values = new int[16];
        String nextLine = obj.readLine() ;
        String[] temp = nextLine.split(" ");
        for (int i = 0 ; i < temp.length ; i++){
            values[i] = Integer.parseInt(temp[i]) ;
        }
        return values ;
    }

    public void createLevel() throws IOException {
        for (int i = 0 ; i < this.tabNiveau().length ; i++){
            mv.getListCells().get(i).setType_cell(tabNiveau()[i]);
        }
    }

}