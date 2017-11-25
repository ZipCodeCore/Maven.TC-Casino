package io.zipcoder.casino;

public class CrapsPlayer extends Player implements PlayForMoney {
    private double walletAmount;
    private Integer[] currentRoll = new Integer[2];

    public CrapsPlayer(){
        super("A player has no name");
        this.walletAmount = 10000.0;
    }
    public CrapsPlayer(String name) {
        super(name);
        this.walletAmount = 10000.0;
    }

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



    public double getWallet() {
        return walletAmount;
    }

    public void setWallet(double amount) {
        this.walletAmount = amount;
    }

    public double makeBet(Double amount) {
        return 0;
    }

    public double collectWinnings(boolean isWin) {
        return 0;
    }

    public double collectWinnings(boolean isWin, Craps craps) {
        return 0;
    }

    public void makeBet(Double amount, Craps craps) {
        craps.setPlayerBet(amount);


    }

}
