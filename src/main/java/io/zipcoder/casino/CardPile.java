package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.StringJoiner;

public class CardPile {

    private ArrayList<Card> cards = new ArrayList<>();

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public void addCardToPile(Card card) {
        cards.add(card);
    }

    public void addCardsToPile(CardPile cards) {
        for(Card card : cards.getCards()) {
            addCardToPile(card);
        }
    }

    public boolean contains(Card card) {
        if(cards.contains(card)) {
            return true;
        } else {
            for(Card c : cards) {
                if(c.matches(card)) {
                    return true;
                }
            }
            return false;
        }
    }

    public boolean containsAll(CardPile cardPile) {
        CardPile temp = new CardPile();
        temp.addCardsToPile(cardPile);
        while(temp.numCards() > 0) {
            Card nextCard = temp.getCard(0);
            if(cards.contains(nextCard)) {
                temp.removeCard(nextCard);
            } else {
                return false;
            }
        }
        return true;
    }

    public int numCards() {
        return cards.size();
    }

    public Card getCard(int index) {
        return cards.get(index);
    }

    public void removeCard(Card card) {
        ArrayList<Card> matchedCards = new ArrayList<>();
        for(Card c : cards) {
            if(c.matches(card)) {
                matchedCards.add(c);
            }
        }
        if(matchedCards.size() > 0) {
            cards.remove(matchedCards.get(0));
        }
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ");
        for(Card card : cards) {
            stringJoiner.add(card.getFaceValue().getIcon() + card.getSuit().getIcon());
        }
        return stringJoiner.toString();
    }
}
