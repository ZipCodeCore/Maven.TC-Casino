package io.zipcoder.casino;

import java.util.Random;

public class Dice {

    private int diceValue;

    public int getDiceValue() {
        return diceValue;
    }

    public static int rollDice() {
        Random rand = new Random();
        int dice1 = rand.nextInt(6) + 1;
        int dice2 = rand.nextInt(6) + 1;
        System.out.println("Dice one is " + dice1 + ", dice two is " + dice2 +". The total value of roll dice is " +(dice1+dice2));
        return dice1 + dice2;
    }
    public DicePlayer passDice(DicePlayer player2){
        DicePlayer newDicePlayer = new DicePlayer(player2);
        return newDicePlayer;
    }
}
