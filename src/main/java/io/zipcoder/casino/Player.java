package io.zipcoder.casino;

public class Player {
    private double bank;
    private String name;
    private int score;

    public Player(){

        this.bank=bank;
        this.name = name;
        this.score= score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {                // only for test purpose, delete it later
        this.score = score;
    }
}
