package com.example.snakesandladders;

import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameBoard {

    // -----------------------------------------------------------------------------------------------------------------

    private final Snake snakes;

    private final Ladder ladders;

    private Player[] players;

    private Dice dice;

    private Group winnerPopup;

    private Label winner1Label;

    private Label winner2Label;

    // -----------------------------------------------------------------------------------------------------------------

    public GameBoard(ImageView player1mover, ImageView player1token, ImageView player2mover, ImageView player2token,
                     Button diceButton, ImageView diceHolder, Group winnerPopup,Label winner1Label, Label winner2Label){
        int[][] ladders = {{2, 23}, {8, 12}, {17, 93}, {29, 54}, {32, 51}, {39, 80}, {62, 78}, {70, 89}, {75, 96}};
        this.ladders = new Ladder(ladders);
        int[][] snakes = {{99, 4}, {92, 76}, {83, 80}, {69, 50}, {59, 37}, {41, 19}, {31, 14}};
        this.snakes = new Snake(snakes);
        this.players = new Player[2];
        this.players[0] = new Player(player1mover, player1token);
        this.players[1] = new Player(player2mover, player2token);
        this.dice = new Dice(diceButton, diceHolder);
        this.winnerPopup = winnerPopup;
        this.winner1Label = winner1Label;
        this.winner2Label = winner2Label;
    }

    // -----------------------------------------------------------------------------------------------------------------

    private int checkForSpecialTiles(int player) {
        int currentPlayerPosition = this.players[player-1].getCurrentPosition();
        int destinationTile = currentPlayerPosition;
        if (currentPlayerPosition == 100)
            return 1;
        int[] destination = CoordinateLookup.getCoordinates(currentPlayerPosition);
        if (ladders.isPowerElement(currentPlayerPosition)){
            destination = ladders.destinationCoordinates(currentPlayerPosition);
            destinationTile = ladders.destinationTileNumber(currentPlayerPosition);
        }
        if (snakes.isPowerElement(currentPlayerPosition)){
            destination = snakes.destinationCoordinates(currentPlayerPosition);
            destinationTile = snakes.destinationTileNumber(currentPlayerPosition);
        }
        this.players[player-1].moveToTile(destinationTile, destination);
        return 0;
    }

    public int play(MouseEvent event, int player){
        if (!(this.players[player-1].isLocked()))
            this.players[player-1].repeat(event);
        return checkForSpecialTiles(player);
    }

    public void moveTokenByOne(MouseEvent event, int player) {
        this.players[player-1].moveByOne();
    }

    public void rollDice(int player) {
        int dieRoll = dice.roll();
        if (this.players[player-1].getCurrentPosition() + dieRoll > 100)
            return;
        this.players[player-1].setCurrentDieRoll(dieRoll);
        if (dieRoll == 1)
            this.players[player-1].setLocked(false);
    }

    // -----------------------------------------------------------------------------------------------------------------
    
}
