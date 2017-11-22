package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFishPlayer extends Player<GoFishPlayer> implements Gamble {

    ArrayList<Card> hand;

    GoFishPlayer(String name) {
        super(name);
    }

    public void dealGoFishHAnd(ArrayList<GoFishPlayer> players, Deck deck) {
        for (int i = 1; i <= 5; i++) {
            for (GoFishPlayer player : players)
                player.hand.add(deck.dealOneRandomCard());
        }
    }

    @Override
    public Double bet(){
        return null;
    }
}
