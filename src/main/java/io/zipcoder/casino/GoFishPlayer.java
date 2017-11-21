package io.zipcoder.casino;

public class GoFishPlayer extends Player<GoFishPlayer> implements Comparable<GoFishPlayer> {

    @Override
    void addToList(GoFishPlayer player) {
        this.players.add(player);
    }

    GoFishPlayer(String name) {
        super(name);
    }

    public int compareTo(GoFishPlayer o) {
        return 0;
    }
}
