package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class Game {
    private int playerTurn;

    private ArrayList<Player> players = new ArrayList<Player>();

    public abstract void startPlayerTurn();

    public void addPlayer(Player player){
        players.add(player);
    }

    public boolean isEndRound() {
        return false;
    }
}
