package io.zipcoder.casino;

public class BlackjackPlayer extends Player<BlackjackPlayer> implements Comparable<BlackjackPlayer>, Gamble {



    BlackjackPlayer(String name, Double money) {
        super(name, money);
    }


    void addToList(BlackjackPlayer player) {
        players.add(player);
    }

    public int compareTo(BlackjackPlayer o) {
        return 0;
    }

    public Double bet() {
        return null;
    }
}
