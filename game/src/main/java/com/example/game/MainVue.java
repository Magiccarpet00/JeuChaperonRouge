package com.example.game;

import javafx.application.Application;
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

import java.io.IOException;
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

    private int SIZE_GRID = 3;
    private int SIZE_RECT = 70;

    @Override
    public void start(Stage stage) throws IOException {

        Thread.currentThread().setUncaughtExceptionHandler((thread, throwable) -> {
            System.out.println("Handler caught exception: "+throwable.getMessage());
        });

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

        grid_stack.getChildren().addAll(grid_back,grid_front);
        grid_stack.setPadding(new Insets(10));
        grid_back.setVgap(1);
        grid_back.setHgap(1);
        grid_front.setVgap(1);
        grid_front.setHgap(1);
        root.getChildren().addAll(grid_stack, selectPath, selectButton);
        draw();


//        FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Game");
        stage.setScene(scene);
        stage.show();
    }

    public void draw(){
        for (int i = 0; i < listCells.size(); i++){
            listCells.get(i).drawCell();
        }
    }



    public static void main(String[] args) {
        launch();
    }
}