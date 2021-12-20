package com.example.snakesandladders;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class GameBoard {

    // -----------------------------------------------------------------------------------------------------------------

    // private Snake snakes;

    private Ladder ladders;

    private Player[] players;

    private Dice dice;

    private ImageView winnerPopup;

    // -----------------------------------------------------------------------------------------------------------------

    public GameBoard(ImageView player1mover, ImageView player1token, ImageView player2mover, ImageView player2token,
                     Button diceButton, ImageView diceHolder, ImageView winnerPopup) {
        int[][] ladders = {{2, 23}, {8, 12}, {17, 93}, {29, 54}, {32, 51}, {39, 80}, {62, 78}, {70, 89}, {75, 96}};
        this.ladders = new Ladder(ladders);
        this.players = new Player[2];
        this.players[0] = new Player(player1mover, player1token);
        this.players[1] = new Player(player2mover, player2token);
        this.dice = new Dice(diceButton, diceHolder);
        this.winnerPopup = winnerPopup;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void play(MouseEvent event, int player){
        if (!(this.players[player-1].isLocked()))
            this.players[player-1].repeat(event);
        if (this.players[0].getCurrentPosition() == 100 || this.players[1].getCurrentPosition() == 100) {
            winnerPopup.setVisible(true);
        }
        if (ladders.isPowerElement(this.players[player-1].getCurrentPosition())){
            System.out.println(ladders.ladderTopCoordinates(this.players[player-1].getCurrentPosition()));

        }
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
