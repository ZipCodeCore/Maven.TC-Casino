package io.zipcoder.casino;

import java.util.Arrays;

public class DiceManager {

    // Die faces will be stored in an array
    private Die[] diceArray;

    public DiceManager(int amountOfDice) {
        this.diceArray = new Die[amountOfDice];
        Arrays.fill(diceArray, new Die());
    }

    public void rollSpecificDie(int index) {
        diceArray[index].rollDie();
    }

    public void setSpecificDie(int index, int desiredFace) {
        diceArray[index].setDieFace(desiredFace);
    }

    public void rollAllDice() {
        for (int i = 0; i < diceArray.length; i++) {
            rollSpecificDie(i);
        }
    }

    public int[] getAllDieFaces() {
        int[] allDieFaces = new int[diceArray.length];
        for (int i = 0; i < allDieFaces.length; i++) {
            allDieFaces[i] = diceArray[i].getDieFace().toInt();
        }
        return allDieFaces;
    }

    public int getTotalValue() {
        int sum = 0;
        for (int i = 0; i < diceArray.length; i++) {
            sum += diceArray[i].getDieFace().toInt();
        }
        return sum;
    }


}