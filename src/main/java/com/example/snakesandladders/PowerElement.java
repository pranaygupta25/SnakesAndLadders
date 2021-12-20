package com.example.snakesandladders;

import java.util.HashMap;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PowerElement {

    // -----------------------------------------------------------------------------------------------------------------

    protected HashMap<Integer, int[]> positions;
    protected String url;

    // -----------------------------------------------------------------------------------------------------------------

    protected PowerElement(int[][] startsAndEnds, String url) {
        this.positions = new HashMap<>();
        for (int[] element: startsAndEnds) {
            this.positions.put(element[0], CoordinateLookup.getCoordinates(element[1]));
        }
        this.url = url;
    }

    public boolean isPowerElement(int current) {
        return this.positions.containsKey(current);
    }

    protected int[] getCoordinates(int current) {
        return this.positions.get(current);
    }

    protected void playMusic() {
        Media track = new Media(new File(this.url).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(track);
        mediaPlayer.play();
    }

    public int[] destinationCoordinates(int destination){
        playMusic();
        return getCoordinates(destination);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
