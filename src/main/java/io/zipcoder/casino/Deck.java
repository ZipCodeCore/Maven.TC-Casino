package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

//    ArrayDeque<Card> cards = new ArrayDeque<>();

    ArrayList<Card> cards = new ArrayList();

    Deck() {
        for (Suit suit : Suit.values()) {
            for (CardValue cardValue : CardValue.values()) {
                cards.add(new Card(suit, cardValue));
            }
        }
    }

    public Card dealOneRandomCard() {
        Card topCard = cards.get(0);
        cards.remove(topCard);
        return topCard;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

}
