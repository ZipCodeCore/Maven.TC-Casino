package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;
    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public ArrayList<Card> createFullDeck() {

        for (Suit cardSuit : Suit.values()) {
            for (Value cardValue : Value.values()) {
                this.cards.add(new Card(cardSuit, cardValue));
            }
        }
        return cards;
    }

    @Override
    public String toString() {
        String output = "";
        for (Card card : cards) {
            output += card.getValue() + " of " + card.getSuit() + "\n";
        }
        output = output.trim();
        return output;
    }

    public int getSize() {
        return cards.size();
    }

    public void shuffle() {
        ArrayList<Card> tmpDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();

        for (int i = 0; i < originalSize; i++) {
            randomCardIndex = random.nextInt((this.cards.size() - 1) + 1);
            tmpDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }

        this.cards = tmpDeck;
    }
    public Card giveCard(){
        return cards.remove(cards.size()-1);
    }


}
