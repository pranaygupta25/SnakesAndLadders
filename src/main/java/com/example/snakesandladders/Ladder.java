package com.example.snakesandladders;

import java.util.HashMap;

public class Ladder {
    // leader  map  where value[0] is x coordinate and value[1] is y coordinate
    private HashMap<Integer, int[]> ladder_coordinate = new HashMap<Integer, int[]>(){
        {
            put(2, new int[]{100, -150});
            put(8, new int[]{400,-100});
            put(17, new int[]{350,-500});
            put(29, new int[]{300,-300});
            put(39, new int[]{0,-400});
            put(32, new int[]{450,-300});
            put(62, new int[]{100,-400});
            put(70, new int[]{400,-450});
            put(75, new int[]{200,-500});

        }
    };

    

    // function to give corrdinate where we have to go after taking ladder
    public int[] getCoordinates(int current) {
        int[] result = new int[2];
        result[0] = ladder_coordinate.get(current)[0];
        result[1] = ladder_coordinate.get(current)[1];
        return result;
    }

    // function to check where we are at ladder or not 
    public boolean isLadder(int current) {
        return ladder_coordinate.containsKey(current);
        
    }

    // how to use above function if we are at ladder face then call corrdinate fn of ladder to get new postion  to drop player


}

    

