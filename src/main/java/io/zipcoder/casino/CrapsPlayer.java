package io.zipcoder.casino;

public class CrapsPlayer extends Player {

    void addToList(CrapsPlayer player) {
        this.players.add(player);
    }

    CrapsPlayer(String name, Double money) {
        super(name, money);
    }


}
