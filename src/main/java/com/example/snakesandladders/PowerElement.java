package com.example.snakesandladders;

import java.util.HashMap;

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

    // -----------------------------------------------------------------------------------------------------------------

}
