package io.zipcoder.casino;

import java.util.ArrayList;

public abstract class CardGame extends Deck {

    ArrayList<Card> hand = new ArrayList<Card>();

    public ArrayList<Card> showHand() {
        return hand;
    }

    public boolean isHandEmpty() {
        if(hand.size() == 0) {
            return true;
        }
        return false;
    }

    public void addToHandFromPile() {
        //taking top card from the pile (cards in Deck)
        hand.add(getCard());
    }

    public void addToHandFromPlayer() {

    }
}
