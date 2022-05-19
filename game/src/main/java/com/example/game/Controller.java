package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.io.File;
import java.util.ArrayList;

public class Controller {
    @FXML
    private Label welcomeText;

    private static int numNiveau = 0 ;

    private MainVue mv;

    private ArrayList<Niveau> niveaux = new ArrayList<Niveau>();

    public Controller(MainVue v) throws FileNotFoundException {
        this.mv = v;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    //test git
    //Felix: je sais pas a quoi ça sert le truc au dessus
    public  void play (){

    }
    public void configurer (){

    }

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

    public void lireNiveaux() throws IOException {
        File doc = new File("src\\main\\resources\\config.txt");
        BufferedReader obj = new BufferedReader(new FileReader(doc));
        String line ;
        while ((line = obj.readLine()) != null){
            Niveau level = new Niveau() ;
            int[] values = new int[16] ;
            String[] temp = line.split(" ");
            for (int i = 0 ; i < temp.length ; i++){
                values[i] = Integer.parseInt(temp[i]) ;
            }
            level.setNiveau(values);
            niveaux.add(level) ;
        }
    }

    public void loadLevel(int numNiveau) {
        int[] current = new int[16] ;
        if (numNiveau < niveaux.size()){
            current = niveaux.get(numNiveau).getNiveau() ;
            for (int i = 0 ; i < current.length ; i++){
                mv.getListCells().get(i).setType_cell(current[i]);
            }
        }
    }

    public void createNextLevel() throws IOException {
        int[] current = new int[16] ;
        if (numNiveau < niveaux.size()){
            current = niveaux.get(numNiveau).getNiveau() ;
            for (int i = 0 ; i < current.length ; i++){
                mv.getListCells().get(i).setType_cell(current[i]);
            }
            numNiveau++ ;
        }
        else {
            for (int i = 0 ; i < current.length ; i++){
                current[i] = 0 ;
                mv.getListCells().get(i).setType_cell(current[i]);
            }
        }
    }

}