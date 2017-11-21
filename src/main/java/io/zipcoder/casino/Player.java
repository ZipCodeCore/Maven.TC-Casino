package io.zipcoder.casino;

public class Player {
    private double bank;
    private String name;


    public Player(String name) {
        this.name = name;
    }

    public void setBank(double bank) {
        this.bank = bank;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double getBank() {
        return bank;
    }
}
