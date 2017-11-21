package io.zipcoder.casino;

import java.util.ArrayList;

public class CardGamePlayer extends Player {

    ArrayList<Card> hand = new ArrayList<Card>();

    public void addToHandFromPile() {
        //taking top card from the pile (cards in Deck)
        hand.add(getCard());
    }

    public void addToHandFromPlayer() {

    }
}

