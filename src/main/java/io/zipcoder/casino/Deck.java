package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

//    ArrayDeque<Card> cards = new ArrayDeque<>();

    private ArrayList<Card> cards = new ArrayList();

    Deck() {
        for (Suit suit : Suit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                cards.add(new Card(suit, cardValue));
            }
        }
    }

    public void populate() {
        cards = new ArrayList();

    }

    public Card dealOneRandomCard() {
        Card topCard = cards.get(0);
        cards.remove(topCard);
        return topCard;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public int getDeckSize() {
        return cards.size();
    }

    public Card getCardByIndex(int index) {
        return cards.get(index);
    }

}
