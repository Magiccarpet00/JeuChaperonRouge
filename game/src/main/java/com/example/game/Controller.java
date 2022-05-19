package com.example.game;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;

import java.io.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    @FXML
    private Label welcomeText;

    private static int numNiveau ;

    private MainVue mv;

    private ArrayList<Niveau> niveaux = new ArrayList<Niveau>();
    private ArrayList<Solution> solutions = new ArrayList<Solution>();
    private Path[] solutionPaths;

    public Controller(MainVue v) throws FileNotFoundException {
        this.mv = v;
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

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
        System.out.println(niveaux.size());
    }

    public void lireSolutions() throws IOException {
        File doc = new File("src\\main\\resources\\soluce.txt.txt");
        BufferedReader obj = new BufferedReader(new FileReader(doc));
        String line ;
        while ((line = obj.readLine()) != null){
            Solution sol = new Solution() ;
            int[] solution = new int[20] ;
            String[] temp = line.split(" ");
            for (int i = 0 ; i < temp.length ; i++){
                solution[i] = Integer.parseInt(temp[i]) ;
            }
            sol.setSolution(solution);
            solutions.add(sol) ;
        }


    }

    public void createSolutionPaths() throws IOException {
        lireSolutions();
        int niveau = numNiveau ;
        int[] solution = solutions.get(numNiveau).getSolution() ;
        int count =0;
        for (int i = 0 ; i < 5 ; i ++){
            solutionPaths[i] = new Path(count, solution[count+1], solution[count+2]) ;
            count +=3;
        }
    }

    public void compareToWin() throws IOException {
        createSolutionPaths();
        List<Path> currentPaths = mv.getListPath() ;
        boolean reussi = false ;
        for (int i = 0 ; i < currentPaths.size() ; i++){
            ;
        }
    }

    public void loadLevel(int nblevel) {
        int[] current = new int[16] ;
        if (nblevel < niveaux.size()){
            current = niveaux.get(nblevel).getNiveau() ;
            for (int i = 0 ; i < current.length ; i++){
                mv.getListCells().get(i).setType_cell(current[i]);
            }
            numNiveau = nblevel ;
        }
    }

    public void createNextLevel() throws IOException {
        numNiveau++ ;
        int[] current = new int[16] ;
        if (numNiveau < niveaux.size()){
            current = niveaux.get(numNiveau).getNiveau() ;
            for (int i = 0 ; i < current.length ; i++){
                mv.getListCells().get(i).setType_cell(current[i]);
            }
        }
        else {
            for (int i = 0 ; i < current.length ; i++){
                current[i] = 0 ;
                mv.getListCells().get(i).setType_cell(current[i]);
            }
        }
    }

    public int getNumNiveau(){
        return numNiveau ;
    }
}