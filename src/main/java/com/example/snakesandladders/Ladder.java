package com.example.snakesandladders;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Ladder extends PowerElement {

    public Ladder(int[][] ladderPositions) {
        super(ladderPositions, "src/main/resources/audio/powerUp.wav");
    }

    public int[] ladderTopCoordinates(int bottom) {
        Media track = new Media(new File(this.url).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(track);
        mediaPlayer.play();
        return getCoordinates(bottom);
    }

}

    

