package io.zipcoder.casino;

public class DiceManager {

    // Die faces will be stored in an array

    private Die[] diceArray;

    public DiceManager(int amountOfDice) {
        this.diceArray = new Die[amountOfDice];
    }

    public void rollSpecificDice(int index) {
        diceArray[index].rollDie();
    }

    public void rollAllDice() {
        for (int i = 0; i < diceArray.length; ) {
            rollSpecificDice(i);
        }
    }

    public int[] checkDiceValue() {
        int[] allDieFaces = new int[]{diceArray.length};
        for (int i = 0; i < diceArray.length; i++) {
            allDieFaces[i] = diceArray[i].getDieFace().toInt();
        }
        return allDieFaces;
    }

    public int checkTotalValue() {
        return 0;
    }


}