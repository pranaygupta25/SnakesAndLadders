package com.example.snakesandladders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // FXML File Configuration
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("hello-view.fxml"));
        // New scene initialization
        Scene scene = new Scene(fxmlLoader.load());
        // Application Name Configuration
        stage.setTitle("Snakes and Ladders | CSE201 Project");
        // Application Window Resize
        stage.setResizable(false);
        // Setting up the current scene to the stage
        stage.setScene(scene);
        // Display the stage
        stage.show();
    }

    public static void main(String[] args) {
        // Static method from Application Class of the JavaFX library which is being inherited by this class
        launch();
    }
}