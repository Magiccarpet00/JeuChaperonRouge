package com.example.game;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainVue extends Application {

    private GridPane grid_back = new GridPane(); //Le grid où il y a les chemins et les cases vertes , la maison
    private GridPane grid_front  = new GridPane();     //Le grid où il y a les personage, les arbres
    private StackPane grid_stack = new StackPane(); //Stack afin d'empiler les 2 gridPane

    private List<Cell> listCells = new ArrayList<Cell>();

    private VBox selectPath = new VBox();
    private VBox selectButton = new VBox();

    private HBox root = new HBox();

    private Button btnReset = new Button();
    private Button btnRotate = new Button();
    private Button btnExecute = new Button();

    private Button btnNext = new Button("next level") ;

    private int SIZE_GRID = 3;
    private int SIZE_RECT = 70;

    private Controller c = new Controller(this);

    public MainVue() throws FileNotFoundException {
    }

    @Override
    public void start(Stage stage) throws IOException {

        createGrid();
        setupGrid();
        draw();

        //FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("hello-view.fxml"));
        root.getChildren().add(btnNext);
        Scene scene = new Scene(root);
        stage.setTitle("Chaperon Rouge");
        stage.setScene(scene);
        stage.show();

        oldMain(); // fonction provisoire pour afficher dans la console
    }

    public void createGrid(){
        for(int i = 0; i <= SIZE_GRID; i++){
            for(int j = 0; j <= SIZE_GRID; j++){
                Rectangle square_back = new Rectangle(j, i, SIZE_RECT,SIZE_RECT);
                Rectangle square_front = new Rectangle(j, i, SIZE_RECT,SIZE_RECT);
                grid_back.add(square_back,j,i);
                grid_front.add(square_front,j,i);
                Cell c = new Cell(j,i,square_front,square_back);
                listCells.add(c);
            }
        }
    }

    public void setupGrid() {
        grid_stack.getChildren().addAll(grid_back,grid_front);
        grid_stack.setPadding(new Insets(10));
        grid_back.setVgap(1);
        grid_back.setHgap(1);
        grid_front.setVgap(1);
        grid_front.setHgap(1);
        root.getChildren().addAll(grid_stack, selectPath, selectButton);
    }

    public void draw(){
        for (int i = 0; i < listCells.size(); i++){
            listCells.get(i).drawCell();
        }
    }

    // [TEMPORAIRE] fonction pour effectuer des test
    public void oldMain() throws IOException {
        c.lireNiveaux();
        c.createNextLevel();
        draw();

        btnNext.setOnAction(new EventHandler <ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                try {
                    c.createNextLevel() ;
                    draw();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

    }

    public List<Cell> getListCells() {
        return listCells;
    }

    public static void main(String[] args) {
        launch();

    }
}