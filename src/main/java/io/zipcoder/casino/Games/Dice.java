package io.zipcoder.casino.Games;

import java.util.Random;

public class Dice {

    public static Integer rollDice(){
        Random  dice1 = new Random();
        Integer diceRoll = (dice1.nextInt(6)+1);
        return diceRoll;
    }
}
