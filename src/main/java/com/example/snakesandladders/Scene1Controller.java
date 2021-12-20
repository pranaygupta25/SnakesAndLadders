package com.example.snakesandladders;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Scene1Controller {
    private Stage stage;
    private Scene scene;
    private Parent root;

    static String playerName1;
    static String playerName2;

    @FXML
    private TextField player1name;

    @FXML
    private TextField player2name;

    public void play(ActionEvent event) throws IOException{
        playerName1 = player1name.getText();
        playerName2 = player2name.getText();
        Parent root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
