package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
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

    private GridPane grid_backGround = new GridPane(); //Le grid où il y a les chemins et les cases vertes , la maison
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

    @Override
    public void start(Stage stage) throws IOException {

        for(int i = 0; i <= SIZE_GRID; i++){
            for(int j = 0; j <= SIZE_GRID; i++){
                Rectangle square_back = new Rectangle(j, i, 20,20);
                Rectangle square_front = new Rectangle(j, i, 20,20);
                Cell c = new Cell(j,i,square_front,square_back);
                listCells.add(c);
            }
        }
//        grid_stack.getChildren().addAll(grid_backGround,grid_front);
//        root.getChildren().addAll(grid_stack, selectPath, selectButton);

        FXMLLoader fxmlLoader = new FXMLLoader(MainVue.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}