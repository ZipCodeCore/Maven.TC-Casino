package io.zipcoder.casino;

public class CrapsPlayer extends Player implements Gamble {

    void addToList(CrapsPlayer player) {
        this.players.add(player);
    }

    void addToList(Comparable player) {

    }

    CrapsPlayer(String name, Double money) {
        super(name, money);
    }


    public void bet() {

    }
}
