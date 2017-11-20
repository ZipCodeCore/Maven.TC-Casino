package io.zipcoder.casino;

public class BlackjackPlayer extends Player {

    BlackjackPlayer(String name, Double money) {
        super(name, money);
    }

    double bet() {
        return 0;
    }

    void addToList(BlackjackPlayer player) {
        players.add(player);
    }
}
