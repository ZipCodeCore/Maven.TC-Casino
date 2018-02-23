package io.zipcoder.casino.Games;

import java.util.Random;

public class Dice {

    private Integer dice1;
    private Integer dice2;
    // static final Integer SEED = 3900;

    public Integer rollDice(){
        Random  dice1 = new Random();
        Random  dice2 = new Random();
         Integer diceRoll = (dice1.nextInt(6)+1) + dice1.nextInt(6)+1;
        return diceRoll;
    }

    public void setDice1() {

    }

    public void setDice2() {

    }

    public Integer getDice1() {
        return 0;
    }

    public Integer getDice2() {
        return 0;
    }

}
