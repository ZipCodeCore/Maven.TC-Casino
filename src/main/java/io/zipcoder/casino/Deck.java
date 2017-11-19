package io.zipcoder.casino;

import sun.security.jca.GetInstance;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck(){

        cards = new ArrayList();

        for (int i = 0; i < 4; i++) {
            Suit[] suitArray = new Suit[]{Suit.CLUB, Suit.DIAMOND, Suit.HEART, Suit.SPADE};
            for (int j = 0; j < 13; j++) {
                Rank[] rankArray = new Rank[]{Rank.ACE, Rank.TWO, Rank.THREE, Rank.FOUR, Rank.FIVE, Rank.SIX, Rank.SEVEN, Rank.EIGHT, Rank.NINE, Rank.TEN, Rank.JACK, Rank.QUEEN, Rank.KING};

                Card card = new Card(rankArray[j], suitArray[i]);

                cards.add(card);
            }
        }

    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card nextAvailableCard(){

        return null;
    }


    public Integer getDeckSize() {
        return cards.size();
    }
}
