package io.zipcoder.casino.nuts_n_bolts.cards;

import java.util.ArrayList;
import java.util.Collections;

public class PlayingDeck {

    private ArrayList<PlayingCard> cards;

    public PlayingDeck(){}

    public void shuffle(){}

    public void reset(){}

    public void countLeft(){}

    public PlayingCard draw(){
        //remove the card you drew from the deck
        return null;
    }

}

/*
    private ArrayList<Card> cards;

    public Deck(){
        populate();
    }

    public Card getCard(){
        if(cards.size() == 0) {
            populate();
            shuffle();
        }
        Card card = cards.get(0);
        cards.remove(0);
        return card;
    }

    public ArrayList<Card> getAllCards(){
        return cards;
    }


    private void populate() {
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
    */