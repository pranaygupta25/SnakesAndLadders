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

    private GameBoard board;

    private int activePlayer;

    // -----------------------------------------------------------------------------------------------------------------

    public void initialize() {
        // Is automatically executed while the application launches
        this.board = new GameBoard(player1mover, player1token, player2mover, player2token, diceButton, diceHolder);
        this.activePlayer = 1;
    }

    @FXML
    void movePlayer1(MouseEvent event) {
        // Component responsible for event: player1mover
        new Thread() {
            @Override public void run() {
                board.play(event, 1);
            }
        }.start();
    }

    @FXML
    void movePlayer2(MouseEvent event) {
        // Component responsible for event: player2mover
        new Thread() {
            @Override public void run() {
                board.play(event, 2);
            }
        }.start();
    }

    @FXML
    void moveToken1(MouseEvent event) {
        // Component responsible for event: player1token
        board.moveTokenByOne(event, 1);
    }

    @FXML
    void moveToken2(MouseEvent event) {
        // Component responsible for event: player2token
        board.moveTokenByOne(event, 2);
    }

    @FXML
    void roll(ActionEvent event) {
        // Component responsible for event: diceButton
        new Thread() {
            @Override public void run() {
                board.rollDice(activePlayer);
                if (activePlayer == 1) {

                    activePlayer = 2;
                }
                else {

                    activePlayer = 1;
                }
            }
        }.start();
    }

    // -----------------------------------------------------------------------------------------------------------------

}
