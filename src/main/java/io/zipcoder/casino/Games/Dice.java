package io.zipcoder.casino.Games;

import java.util.Random;

public class Dice {

    // static final Integer SEED = 3900;
    public Integer rollDice(){
        Random  dice1 = new Random();
        Integer diceRoll = (dice1.nextInt(6)+1);
        return diceRoll;
    }
}
