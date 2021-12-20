package com.example.snakesandladders;

public class Snake extends PowerElement {

    public Snake(int[][] ladderPositions) {
        super(ladderPositions, "src/main/resources/audio/powerDown.wav");
    }
    
}