package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.StringJoiner;

public abstract class Game<T extends Game> {

    protected ArrayList<Player<T>> players = new ArrayList<Player<T>>();

    public abstract ArrayList<Player<T>> getPlayers();

    public int getNumPlayers() {
        return players.size();
    }

    public void addPlayers(ArrayList<Player<T>> players) {
        this.players = players;
    }

    public String printPlayersMoney() {
        StringJoiner stringJoiner = new StringJoiner(" ] , [ ", "[ ", " ]");
        int i = 1;
        for(Player player : players) {
            stringJoiner.add(String.format("Player %d, %s, Total money: $%.2f", i, player.getName(), player.getMoney()));
            i++;
        }
        return stringJoiner.toString();
    }
}
