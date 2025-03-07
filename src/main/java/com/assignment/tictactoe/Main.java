package com.assignment.tictactoe;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Random;
import java.util.Scanner;

public class Main extends Application {
    static String[][] board = new String[3][3];
    static String[] location = new String[9];
    static Scanner scanner = new Scanner(System.in);
    static Random rand = new Random();


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/view/BoardForm.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Tic Tac Toe");
        stage.getIcons().add(
                new Image(
                        getClass().getResourceAsStream("/Image/unnamed.png"))
        );
        stage.setScene(scene);
        stage.show();
    }
}
