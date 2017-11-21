package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        populate();
    }

    public ArrayList<Card> getAllCards() {
        return cards;
    }

    public Card getCard() {
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }


    public void populate() {
        cards = new ArrayList<Card>();
        for (Suit suit: Suit.values()) {
            for (int value = 1; value <= 13; value++)
            {
                if (value < 11)
                {
                    if (value==1)
                        cards.add(new Card(suit, value, Card.suitSymbols[suit.ordinal()], Card.faceSymbols[0]));
                    else
                        cards.add(new Card(suit, value, Card.suitSymbols[suit.ordinal()], ""+value));
                }
                else
                    cards.add(new Card(suit, 10, Card.suitSymbols[suit.ordinal()], Card.faceSymbols[value - 10]));

            }
        }
    }

    public void shuffle(){
        Collections.shuffle(cards);
    }

    public boolean isDeckEmpty() {
        if(cards.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    //may need, may not need.......
    public void createDeck() {
        if (isDeckEmpty()) {
            populate();
            shuffle();
        }
    }
}
