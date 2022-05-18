package com.example.game;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class MainVue extends Application {

    private Stage primaryStage ;

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
    private Stage stage ;
    private Stage configuration ;
    private Button [] btns;

    private String[] btnLabels = {  // Labels des 6 niveaux

            "1", "2", "3",
            "4", "5", "6",
    };

    public MainVue() throws FileNotFoundException {
    }

    @Override


    public void start (Stage primaryStage) throws IOException {

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

        game.setOnAction( e ->
        {
            try {
                play();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        Button parametre  = new Button("SELECT LEVEL");
        parametre.setId("button-even");

        parametre.setOnAction( e ->
        {
            configurer();
        });

        Button quit  = new Button("QUIT");
        quit.setId("button-even");

        quit.setOnAction( e ->
        {
            Platform.exit();
        });

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

    public void configurer () {
        BorderPane contente = new BorderPane();
        Stage configuration = new Stage();
        this.configuration = configuration;

        configuration.setTitle("CONFIGURATION");
        Text scenetitle = new Text("PLEASE SELECT LEVEL");
        scenetitle.setId("CONFIGURATION-text");
        configuration.setResizable(false);
        configuration.setMinWidth(300);

        //créer les  6 Botuons  3x2 btn
        int nbCols = 3;
        // On utilise le GridPane pour organiser les boutons
        GridPane paneButton = new GridPane();
        paneButton.setGridLinesVisible(false);

        // Padding : top, right, bottom, left
        paneButton.setPadding(new Insets(15, 10, 0, 10));

        // Espacement vertical entre les noeuds (composants)
        paneButton.setVgap(20);

        // Espacement horizontal entre les noeuds (composants)
        paneButton.setHgap(20);

        // créer les  6 Botuons et les ajouter au GridPane
        btns = new Button[6];

        VBox button = new VBox(20);

        Button quit = new Button("QUIT THE GAME");
        quit.setId("button-even");

        quit.setOnAction(e ->
        {
            Platform.exit();
        });

        button.getChildren().addAll(quit);
        button.setAlignment(Pos.CENTER);
        button.setSpacing(20);
        quit.setMinSize(150, 50);



        Pane headertext = new Pane();
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 12, 10, 12));
        hbox.setSpacing(10);
        hbox.getChildren().add(scenetitle);
        hbox.setAlignment(Pos.CENTER);
        headertext.getChildren().add(hbox);


        for (int i = 0; i <6; ++i) {
            btns[i] = new Button(btnLabels[i]);

            // associer l'auditeur à tous les boutons.
            int finalI = i;

            btns[i].setId("button-even");
            btns[i].setMinSize(50, 50);
            // Placement des boutons selon les règles du GridPane (composant, col, ligne)
            paneButton.add(btns[i], i % nbCols, i / nbCols);
        }


        GridPane racine = new GridPane();
        racine.setGridLinesVisible(false);
        racine.setHgap(20);
        racine.setVgap(10);
        GridPane contenaire = new GridPane();
        contenaire.setHgap(20);
        contenaire.setVgap(10);

        contente.setTop(racine);
        contente.setCenter(contenaire);
        contente.setBottom(button);

        GridPane.setHalignment(scenetitle, HPos.CENTER);
        contenaire.add(paneButton, 3, 2);
        contenaire.setGridLinesVisible(false);

        racine.add(scenetitle, 1,1);
        contente.setPadding(new Insets(30, 30, 60, 30));

        Scene scene = new Scene( contente,  400, 400);
        scene.getStylesheets().add("Style.css");
        configuration.setScene(scene);
        configuration.show();
    }

    public void play () throws IOException{
        primaryStage.close();
        Stage stage = new  Stage();
        this.stage = stage;
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