package com.example.snakesandladders;

import java.util.HashMap;

public class Snake {

    //map list to store snake postion with corrdinates
    // value has inter type array of size 2 where array[0] is the head of the snake and array[1] is the tail of the snake
    private HashMap<Integer, int[]> snakes_x = new HashMap<Integer, int[]>(){
        {
            put(99, new int[]{50, 150});
            put(91, new int[]{450, 200});
            put(83, new int[]{100, 0});
            put(67, new int[]{300, 450});
            put(59, new int[]{50, 150});
            put(41, new int[]{0, 0});
            put(31, new int[]{450, 300});

        }
    };

    private HashMap<Integer, int[]> snakes_y = new HashMap<Integer, int[]>(){
        {
            put(99, new int[]{-500, -50});
            put(91, new int[]{-500, -400});
            put(83, new int[]{-450, -400});
            put(67, new int[]{-350, -250});
            put(59, new int[]{-300, -200});
            put(41, new int[]{-250, -100});
            put(31, new int[]{-200, -100});

        }
    };
    // function to give corrdinate where we have to drop player after snake ne bite kr liya
    public int[] getCoordinates(int current) {
        int[] result = new int[2];
        result[0] = snakes_x.get(current)[1];
        result[1] = snakes_y.get(current)[1];
        return result;
    }

    // function to check where we are at snake or not
    public boolean isSnake(int current) {
        return snakes_x.containsKey(current);
    }

    // how to use above function if we are at snake head then call corrdinate fn of snake to get new postion  to drop player

    //------------------------------------------------------------
}
    

