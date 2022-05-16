package com.example.game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainVue extends Application {

    private GridPane grid_backGround = new GridPane(); //Le grid où il y a les chemins et les cases vertes , la maison
    private GridPane grid_front  = new GridPane();     //Le grid où il y a les personage, les arbres la maison

    private List<Cell> listCells = new ArrayList<Cell>();

    private VBox selectPath = new VBox();

    private Button btnReset = new Button();
    private Button btnRotate = new Button();
    private Button btnExecute = new Button();

    @Override
    public void start(Stage stage) throws IOException {
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