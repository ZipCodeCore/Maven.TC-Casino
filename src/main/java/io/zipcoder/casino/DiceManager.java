package io.zipcoder.casino;

import java.util.Arrays;

public class DiceManager {

    // Die faces will be stored in an array
    private Die[] diceArray;

    public DiceManager(int amountOfDice) {
        this.diceArray = new Die[amountOfDice];
        for(int i = 0; i < this.diceArray.length; i++) {
            this.diceArray[i] = new Die();
        }
    }

    public Die rollSpecificDie(int index) {
        diceArray[index].rollDie();
        return diceArray[index];
    }

    public void setSpecificDie(int index, DieFace desiredFace) {
        this.diceArray[index].setDieFace(desiredFace);
    }

    public Die getDie(int indexOfDie) {
        return this.diceArray[indexOfDie];
    }

    public void rollAllDice() {
        for (int i = 0; i < diceArray.length; i++) {
            rollSpecificDie(i);
        }
    }

    public DieFace[] getAllDieFaces() {
        Die[] copyOfDiceArray = Arrays.copyOf(this.diceArray, this.diceArray.length);
        DieFace[] dieFaces = new DieFace[copyOfDiceArray.length];
        for(int i = 0; i < this.diceArray.length; i++) {
            dieFaces[i] = this.diceArray[i].getDieFace();
        }
        return dieFaces;
    }

    public int getTotalValue() {
        int sum = 0;
        for (int i = 0; i < diceArray.length; i++) {
            sum += diceArray[i].getDieFace().toInt();
        }
        return sum;
    }

}