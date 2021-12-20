package com.example.snakesandladders;

import java.util.HashMap;
import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class PowerElement {

    // -----------------------------------------------------------------------------------------------------------------

    protected HashMap<Integer, int[]> destinationCoordinates;
    protected HashMap<Integer, Integer> destinationTileNumber;
    protected String url;

    // -----------------------------------------------------------------------------------------------------------------

    protected PowerElement(int[][] startsAndEnds, String url) {
        this.destinationCoordinates = new HashMap<>();
        this.destinationTileNumber = new HashMap<>();
        for (int[] element: startsAndEnds) {
            this.destinationCoordinates.put(element[0], CoordinateLookup.getCoordinates(element[1]));
            this.destinationTileNumber.put(element[0], element[1]);
        }
        this.url = url;
    }

    public boolean isPowerElement(int current) {
        return this.destinationCoordinates.containsKey(current);
    }

    protected int[] getCoordinates(int current) {
        return this.destinationCoordinates.get(current);
    }

    protected void playMusic() {
        Media track = new Media(new File(this.url).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(track);
        mediaPlayer.play();
    }

    public int[] destinationCoordinates(int source){
        playMusic();
        return getCoordinates(source);
    }

    public int destinationTileNumber(int source) {
        return this.destinationTileNumber.get(source);
    }

    // -----------------------------------------------------------------------------------------------------------------

}
