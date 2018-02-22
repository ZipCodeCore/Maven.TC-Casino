package io.zipcoder.casino.Game.diceGame;

import java.util.Random;

public class Die {
    private int numberOfFaces;
    private Random roller = new Random();

    public Die(int numberOfFaces) {
        this.numberOfFaces = numberOfFaces;
    }

    public int getNumberOfFaces() {
        return this.numberOfFaces;
    }

    public int rollDie(){
        return roller.nextInt(numberOfFaces) +1;
    }

}
