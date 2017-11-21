package io.zipcoder.casino;

import java.util.ArrayList;


public class Game {

    private int round;
    private ArrayList<Player> players = new ArrayList<Player>();


    private ArrayList<Player> players = new ArrayList<Player>();

    public abstract void startPlayerTurn();

    public void addPlayer(Player player){
        players.add(player);
    }

    public boolean isEndRound() {
        return false;
    }

    public void startGame(){

    }

    public ArrayList<Player> getPlayers() {
        return players;
    }
}
