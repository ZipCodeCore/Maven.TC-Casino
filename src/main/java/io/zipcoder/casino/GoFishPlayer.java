package io.zipcoder.casino;


import java.util.ArrayList;

public class GoFishPlayer extends Player<GoFishPlayer> implements Comparable<GoFishPlayer> {

    ArrayList<Card> hand;

    GoFishPlayer(String name) {
        super(name);
    }

    public int compareTo(GoFishPlayer o) {
        return 0;
    }

    @Override
    void addToList(GoFishPlayer player) {

    }

    public void dealGoFishHAnd(ArrayList<GoFishPlayer> players, Deck deck) {
        for (int i = 1; i <= 5; i++) {
            for (GoFishPlayer player : players)
                player.hand.add(deck.dealOneRandomCard());
        }
    }
}
