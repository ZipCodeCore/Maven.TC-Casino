package io.zipcoder.casino.Game.cardGame.utilities;


import io.zipcoder.casino.CasinoUtilities.Console;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<>();
    }

    public void addCard(Card card) {
        hand.add(card);

    }

    public void removeCard(Card card) {
        hand.remove(card);
    }

    public void clear() {
        hand.clear();
    }

    public boolean hasCard(Card thisCard) {

        if (hand.contains(thisCard)) {
            return true;
        }
        return false;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }


    public String showHand() {
      StringBuilder cards = new StringBuilder();
        for(Card aCard: getHand()){
        cards.append(aCard.toString() + ",");
    }
      return  null;//cards.toString();

    }
}