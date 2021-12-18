package com.example.snakesandladders;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;

public class Dice {

    // -----------------------------------------------------------------------------------------------------------------

    @FXML
    final private Button diceButton;

    @FXML
    final private ImageView diceHolder;

    final private int minimumValue;

    final private int maximumValue;

    private Image[] faces;

    private Image rollAnimation;

    // -----------------------------------------------------------------------------------------------------------------

    public Dice(Button diceButton, ImageView diceHolder) {
        this.diceButton = diceButton;
        this.diceHolder = diceHolder;
        this.minimumValue = 1;
        this.maximumValue = 6;
        this.faces = new Image[6];
        for (int i=minimumValue; i<=maximumValue; i++) {
            String url = "src/main/resources/img/dice/" + Integer.toString(i) + ".png";
            try {
                faces[i-1] = new Image(new FileInputStream(url));
            }
            catch (Exception e) {
                System.out.println("Error occurred while reading files for die face images");
            }
        }
        String url = "src/main/resources/img/dice/animatedDice.gif";
        try {
            this.rollAnimation = new Image(new FileInputStream(url));
        }
        catch (Exception e){
            System.out.println("Error occurred while reading the roll animation");
        }
    }

    // -----------------------------------------------------------------------------------------------------------------

}
