package io.zipcoder.casino;

public class GoFishPlayer extends Player {

    @Override
    void addToList(GoFishPlayer player) {
        this.players.add(player);
    }

    GoFishPlayer(String name) {
        super(name);
    }

}
