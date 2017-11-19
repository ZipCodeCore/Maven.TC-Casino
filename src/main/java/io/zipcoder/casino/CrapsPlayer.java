package io.zipcoder.casino;

public class CrapsPlayer extends Player {
    private Bank wallet;
    private Integer[] currentRoll = new Integer[2];

    public Integer roll2Dice() {

        int rollOne = (int) (Math.random()*6)+1;
        int rollTwo = (int) (Math.random()*6)+1;

        currentRoll[0] = rollOne;
        currentRoll[1] = rollTwo;

        return rollOne+rollTwo;
    }

    public void printRoll(){
        System.out.println("["+ currentRoll[0]+"," +currentRoll[1]+"]");
    }



    public Bank getWallet() {
        return wallet;
    }

    public void setWallet(Bank wallet) {
        this.wallet = wallet;
    }
}
