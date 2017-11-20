package io.zipcoder.casino;

import javafx.util.Pair;

import java.util.ArrayList;

public class Craps implements Game, Gamble{

    public final int MIN_NUMBER_OF_PLAYERS = 1;
    public final int MAX_NUMBER_OF_PLAYERS = 8;

    private ArrayList<Player<Craps>> players = new ArrayList<>();
    private Pair<Integer, Integer> dice = new Pair<>(1, 1);

    public void addPlayers(ArrayList<Player<Craps>> players) {
        this.players = players;
    }

    public ArrayList<Player<Craps>> getPlayers() {
        return players;
    }

    public int getNumPlayers() {
        return players.size();
    }

    public void rollDice() {

    }

    public Integer getSumOfDice() {
        return 0;
    }

    public Integer getValueOfDieOne() {
        return dice.getKey();
    }

    public Integer getValueOfDieTwo() {
        return dice.getValue();
    }

    @Override
    public boolean play() {
        return false;
    }

    @Override
    public void takeBet(Double amount) {

    }

    @Override
    public void payOutBets() {

    }
}
