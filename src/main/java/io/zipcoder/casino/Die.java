package io.zipcoder.casino;

public class Die {

    int value;

    public Die() {
    }

    public void rollDie() {
        this.value = (int) Math.ceil(Math.random() * 6);
    }

    public int getValue() {
        return value;
    }

}
