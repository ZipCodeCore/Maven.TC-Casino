package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.games.Card;

import java.util.ArrayList;

public class Crazy8Player {

    String name;

    private ArrayList<Card> playersHand = new ArrayList<>();

    // Variables to hold state
    boolean playerCardsValid;
    boolean playerHasEight;

    public Crazy8Player(String name) {
        this.name = name;
    }

    public ArrayList<Card> getPlayersHand() {
        return playersHand;
    }

    public void setPlayersHand(ArrayList<Card> playersHand) {
        this.playersHand = playersHand;
    }

    public boolean isPlayerCardsValid() {
        return playerCardsValid;
    }

    public void setPlayerCardsValid(boolean playerCardsValid) {
        this.playerCardsValid = playerCardsValid;
    }

    public boolean isPlayerHasEight() {
        return playerHasEight;
    }

    public void setPlayerHasEight(boolean playerHasEight) {
        this.playerHasEight = playerHasEight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
