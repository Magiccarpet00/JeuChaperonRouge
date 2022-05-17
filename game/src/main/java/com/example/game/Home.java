package com.example.game;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Home extends Application {
    private Stage primaryStage ;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Red Riding Hood");
        Text scenetitle = new Text("            Welcome to\nRed Riding Hood The GAME");
        scenetitle.setId("Bienvenue-text");
        primaryStage.setResizable(true);
        primaryStage.setMinWidth(500);

        BorderPane contenaire = new BorderPane();

        VBox button = new VBox(20);

        Button game = new Button("PLAY");
        game.setId("button-even");

        /*game.setOnAction( e ->
        {
            play();
        });*/

        Button parametre  = new Button("SELECT LEVEL");
        parametre.setId("button-even");

        /*parametre.setOnAction( e ->
        {
            configurer();
        });*/

        Button quit  = new Button("QUIT");
        quit.setId("button-even");

        /*quit.setOnAction( e ->
        {
            quit();
        });*/

        button.getChildren().addAll(game, parametre, quit);
        button.setAlignment(Pos.CENTER);
        button.setSpacing(20);
        parametre.setMinSize(150, 50);
        quit.setMinSize(150, 50);
        game.setMinSize(150, 50);


        Pane headertext = new Pane();
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 12, 10, 12));
        hbox.setSpacing(10);
        hbox.getChildren().add(scenetitle);
        hbox.setAlignment(Pos.CENTER);
        headertext.getChildren().add(hbox);

        contenaire.setTop(headertext);
        contenaire.setCenter(button);


        Scene scene = new Scene( contenaire,  500, 400);

        scene.getStylesheets().add("Style.css");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
