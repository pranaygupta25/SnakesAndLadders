package com.example.snakesandladders;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GameController {

    // -----------------------------------------------------------------------------------------------------------------

    private Stage stage;
    private Scene scene;
    private Parent root;
    
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

    @FXML
    private ImageView topHelperArrow;

    @FXML
    private ImageView bottomHelperArrow;

    @FXML
    private ImageView playerOverlay;

    @FXML
    private Label player1name;

    @FXML
    private Label player2name;

    @FXML
    private Label winner1Label;

    @FXML
    private Label winner2Label;

    @FXML
    private Group winnerPopup;

    @FXML
    private Button exitButton;

    private GameBoard board;

    private int activePlayer;

    // -----------------------------------------------------------------------------------------------------------------

    public void initialize() {
        // Is automatically executed while the application launches
        this.board = new GameBoard(player1mover, player1token, player2mover, player2token, diceButton, diceHolder);
        this.activePlayer = 1;
        player1name.setText(Scene1Controller.playerName1);
        player2name.setText(Scene1Controller.playerName2);
        winner1Label.setText(Scene1Controller.playerName1 + " Wins!");
        winner2Label.setText(Scene1Controller.playerName2 + " Wins!");
    }

    private void shiftOverlay(int player) {
        if (player == 1) {
            playerOverlay.setTranslateX(0);
        }
        else if (player == 2) {
            playerOverlay.setTranslateX(-243);
        }
    }

    private void toggleHelperArrows(boolean state) {
        if (state) {
            topHelperArrow.setOpacity(1);
            bottomHelperArrow.setOpacity(1);
        }
        else {
            topHelperArrow.setOpacity(0);
            bottomHelperArrow.setOpacity(0);
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

    @FXML
    void movePlayer1(MouseEvent event) {
        // Component responsible for event: player1mover
        new Thread() {
            @Override
            public void run() {
                int win = board.play(event, 1);
                shiftOverlay(2);
                toggleHelperArrows(true);
                if (win == 1){
                    winner1Label.setVisible(true);
                    winnerPopup.setVisible(true);
                }
            }
        }.start();
        diceButton.setCursor(Cursor.cursor("HAND"));
    }

    @FXML
    void movePlayer2(MouseEvent event) {
        // Component responsible for event: player2mover
        new Thread() {
            @Override public void run() {
                int win = board.play(event, 2);
                shiftOverlay(1);
                toggleHelperArrows(true);
                if (win == 1){
                    winner2Label.setVisible(true);
                    winnerPopup.setVisible(true);
                }
            }
        }.start();
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
        toggleHelperArrows(false);
        new Thread() {
            @Override public void run() {
                board.rollDice(activePlayer);
                MouseEvent newClick = new MouseEvent(MouseEvent.MOUSE_CLICKED, 0, 0, 0, 0,
                        MouseButton.PRIMARY, 1, true, true, true, true, true, true,
                        true, true, true, true, null);
                if (activePlayer == 1) {
                    activePlayer = 2;
                    movePlayer1(newClick);
                }
                else {
                    activePlayer = 1;
                    movePlayer2(newClick);
                }
            }
        }.start();
        diceButton.setCursor(Cursor.cursor("DEFAULT"));
    }

    public void moveToScreen1(ActionEvent event) throws IOException{
        
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Are you sure you want to end current game?");
        alert.setContentText("Click OK to end current game, or Cancel to stay.");
        if(alert.showAndWait().get() == ButtonType.OK){
            
            Parent root = FXMLLoader.load(getClass().getResource("scene1.fxml"));
            stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    
        }

    }

    // -----------------------------------------------------------------------------------------------------------------

}
