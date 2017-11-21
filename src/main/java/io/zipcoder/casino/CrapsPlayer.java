package io.zipcoder.casino;

public class CrapsPlayer extends Player<CrapsPlayer> implements Comparable<CrapsPlayer> ,Gamble {

    void addToList(CrapsPlayer player) {
        this.players.add(player);
    }

    CrapsPlayer(String name, Double money) {
        super(name, money);
    }

    public int compareTo(CrapsPlayer o) {
        return 0;
    }

    public Double bet() {
        return null;

    }

    public static void firstRoll(){

    }
}
