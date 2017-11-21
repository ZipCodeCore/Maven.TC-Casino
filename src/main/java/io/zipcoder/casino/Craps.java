package io.zipcoder.casino;
import java.util.*;

public class Craps extends DiceGames {

    public static int roll() {
        Random diceRoll = new Random();
        int dice1 = diceRoll.nextInt(6) + 1;
        int dice2 = diceRoll.nextInt(6) + 1;
        System.out.println("\n dice1 = " + dice1 + " dice2 = " + dice2);
        return dice1 + dice2;
    }

    public void testGit(){
        
    }

}
