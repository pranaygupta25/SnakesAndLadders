package com.example.snakesandladders;

import javafx.scene.control.Button;
import javafx.scene.image.ImageView;

public class GameBoard {

    // -----------------------------------------------------------------------------------------------------------------

    // private Snake[] snakes;

    // private Ladder[] ladders;

    private Player[] players;

    private Dice dice;

    // -----------------------------------------------------------------------------------------------------------------

    public GameBoard(ImageView player1mover, ImageView player1token, ImageView player2mover, ImageView player2token,
                     Button diceButton, ImageView diceHolder) {
        this.players = new Player[2];
        this.players[0] = new Player(player1mover, player1token);
        this.players[1] = new Player(player2mover, player2token);
        this.dice = new Dice(diceButton, diceHolder);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
