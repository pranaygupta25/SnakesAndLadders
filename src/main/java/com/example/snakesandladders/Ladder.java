package com.example.snakesandladders;

import java.util.HashMap;

public class Ladder {
    // leader  map  where value[0] is the lader face and ladder[1] is the top of the ladder
    private HashMap<Integer, int[]> ladder_x = new HashMap<Integer, int[]>(){
        {
            put(2, new int[]{50, 100});
            put(8, new int[]{350, 400});
            put(17, new int[]{150, 350});
            put(29, new int[]{400, 300});
            put(39, new int[]{50, 0});
            put(32, new int[]{400, 450});
            put(62, new int[]{50, 100});
            put(70, new int[]{450, 400});
            put(75, new int[]{250, 200});

        }
    };

    private HashMap<Integer, int[]> ladder_y = new HashMap<Integer, int[]>(){
        {
            put(2, new int[]{-50, -150});
            put(8, new int[]{-50, -100});
            put(17, new int[]{-100, -500});
            put(29, new int[]{-150, -300});
            put(39, new int[]{-200, -400});
            put(32, new int[]{-200, -300});
            put(62, new int[]{-350, -400});
            put(70, new int[]{-350, -450});
            put(75, new int[]{-400, -500});

        }
    };

    // function to give corrdinate where we have to go after taking ladder
    public int[] getCoordinates(int current) {
        int[] result = new int[2];
        result[0] = ladder_x.get(current)[1];
        result[1] = ladder_y.get(current)[1];
        return result;
    }

    // function to check where we are at ladder or not 
    public boolean isLadder(int current) {
        return ladder_x.containsKey(current);
        
    }

    // how to use above function if we are at ladder face then call corrdinate fn of ladder to get new postion  to drop player


}

    

