package io.zipcoder.casino;

public class CrapsPlayer extends Player<CrapsPlayer> implements Gamble {

    CrapsPlayer(String name, Double money) {
        super(name, money);
    }

    public Double bet() {
        return null;
    }

    public static void firstRoll(){
    }
}
