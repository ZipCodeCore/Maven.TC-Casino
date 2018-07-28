package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    private Card.Rank[] values = Card.Rank.values();
    private Card.Suit[] suites = Card.Suit.values();

    public Deck(int numberOfDecks) {
        deck = new ArrayList<Card>();
        while (numberOfDecks > 0) {
            for (int i = 1; i < 14; i++)
                for (int j = 0; j < 4; j++)
                    deck.add(new Card(values[i], suites[j]));
            numberOfDecks--;
        }
    }

    public Card getCard() {
        return deck.remove(0);
    }

    public int getRemainingCards() {
        return deck.size();
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }
}
