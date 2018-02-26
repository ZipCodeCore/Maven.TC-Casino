package io.zipcoder.casino.GameTools.Deck;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    public ArrayList<Card> deck = new ArrayList<Card>();

    public Deck() {
        for (Rank currentRank: Rank.values()) {
            for (Suit currentSuit : Suit.values()){
                Card temp = new Card(currentRank, currentSuit);
                deck.add(temp);
            }
        }
    }
    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public Card getTopCard() {
        return this.deck.get(0);
    }
}
