package com.example.snakesandladders;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class Player {

    // -----------------------------------------------------------------------------------------------------------------

    @FXML
    final private ImageView playerMover;

    @FXML
    final private ImageView playerToken;

    private int currentPosition;

    private int currentDieRoll;

    private boolean locked;

    // -----------------------------------------------------------------------------------------------------------------

    public Player(ImageView playerMover, ImageView playerToken) {
        this.playerMover = playerMover;
        this.playerToken = playerToken;
        this.currentPosition = 0;
        this.currentDieRoll = 0;
        this.locked = true;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    public ImageView getPlayerToken() {
        return playerToken;
    }

    // -----------------------------------------------------------------------------------------------------------------

    public void moveToCell(int cellNumber) {

    }

    // -----------------------------------------------------------------------------------------------------------------

}
