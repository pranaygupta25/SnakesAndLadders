package com.example.snakesandladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameController {

    // -----------------------------------------------------------------------------------------------------------------

    @FXML
    private Button diceButton;
    // On action: roll()

    @FXML
    private ImageView diceHolder;
    // For displaying faces of a die and the dice roll animation

    @FXML
    private ImageView player1mover;
    // On action: movePlayer1()

    @FXML
    private ImageView player1token;
    // On action: moveToken1()

    @FXML
    private ImageView player2mover;
    // On action: movePlayer2()

    @FXML
    private ImageView player2token;
    // On action: moveToken2()

    // -----------------------------------------------------------------------------------------------------------------

    public void initialize() {
        // Is automatically executed while the application launches

    }

    @FXML
    void movePlayer1(MouseEvent event) {
        // Component responsible for event: player1mover

    }

    @FXML
    void movePlayer2(MouseEvent event) {
        // Component responsible for event: player2mover

    }

    @FXML
    void moveToken1(MouseEvent event) {
        // Component responsible for event: player1token

    }

    @FXML
    void moveToken2(MouseEvent event) {
        // Component responsible for event: player2token

    }

    @FXML
    void roll(ActionEvent event) {
        // Component responsible for event: diceButton

    }

    // -----------------------------------------------------------------------------------------------------------------

}
