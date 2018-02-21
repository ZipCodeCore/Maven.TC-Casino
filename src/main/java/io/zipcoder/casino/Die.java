package io.zipcoder.casino;

public class Die {
    private int die1;
    private int die2;

    public Die(){
        rollDice();
    }

    public void rollDice(){
        die1 = (int) (Math.random()*6) + 1;
        die2 = (int) (Math.random()*6) + 1;
    }

    public void setDie1(int die1) {
        this.die1 = die1;
    }

    public void setDie2(int die2) {
        this.die2 = die2;
    }

    public int getDie1() {
        return die1;
    }

    public int getDie2() {
        return die2;
    }

    public int diceTotal() {
        return die1 + die2;
    }

}

