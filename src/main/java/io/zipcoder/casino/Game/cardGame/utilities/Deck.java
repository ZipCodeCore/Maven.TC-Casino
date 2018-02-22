package io.zipcoder.casino.Game.cardGame.utilities;

import java.util.Collections;
import java.util.Stack;


public class Deck {

    private Stack<Card> deckOfCards = new Stack<>();


    public Deck() {
        fillDeck();
    }

    public void fillDeck() {

        for (CardSuit aSuit : CardSuit.values()) {
            for (CardRank aRank : CardRank.values()) {
                Card tempCard = new Card(aSuit, aRank);
                deckOfCards.push(tempCard);
            }
        }
    }


    public Card getCard() {
        return deckOfCards.pop();
    }

    public int countRemainingCards() {
        return deckOfCards.size();
    }

    public void addCard(Card card) {
        deckOfCards.push(card);
    }

    public Card peek() {
        return deckOfCards.peek();
    }


    public void shuffle() {
        Collections.shuffle(deckOfCards);
    }

}
