package io.zipcoder.casino;

import java.util.ArrayList;

public class PlayerWarehouse {
    private static ArrayList<Player> playerList = new ArrayList<>();

    private static Player currentPlayer;

    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    public static void setCurrentPlayer(Player currentPlayer) {
        PlayerWarehouse.currentPlayer = currentPlayer;
    }

    public static void addPlayer(Player aPlayer) {
        playerList.add(aPlayer);
    }

    public static ArrayList<Player> getPlayerList() {
        return playerList;
    }
}
