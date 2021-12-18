package com.example.snakesandladders;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;

public class GameController {

    // -----------------------------------------------------------------------------------------------------------------

    @FXML
    private ImageView backgroundBoard;

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
        changeBackground(1);
    }

    private void changeBackground(int player) {
        String url = "src/main/resources/img/gameBoard/player" + Integer.toString(player) + ".png";
        try {
            backgroundBoard.setImage(new Image(new FileInputStream(url)));
        }
        catch (Exception e){
            System.out.println("Background Image Switching Error");
        }
    }

    @FXML
    void movePlayer1(MouseEvent event) {
        // Component responsible for event: player1mover
        new Thread() {
            @Override
            public void run() {
                board.play(event, 1);
            }
        }.start();
        changeBackground(2);
        player1mover.setCursor(Cursor.cursor("DEFAULT"));
        diceButton.setCursor(Cursor.cursor("HAND"));
    }

    @FXML
    void movePlayer2(MouseEvent event) {
        // Component responsible for event: player2mover
        new Thread() {
            @Override public void run() {
                board.play(event, 2);
            }
        }.start();
        changeBackground(1);
        player2mover.setCursor(Cursor.cursor("DEFAULT"));
        diceButton.setCursor(Cursor.cursor("HAND"));
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
                    player1mover.setCursor(Cursor.cursor("HAND"));
                    activePlayer = 2;
                }
                else {
                    player2mover.setCursor(Cursor.cursor("HAND"));
                    activePlayer = 1;
                }
            }
        }.start();
        diceButton.setCursor(Cursor.cursor("DEFAULT"));
    }

    // -----------------------------------------------------------------------------------------------------------------

}
