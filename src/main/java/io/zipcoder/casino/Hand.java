package io.zipcoder.casino;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;

    public Hand() {
        hand = new ArrayList<Card>();
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void addCard(ArrayList<Card> cards) {
        hand.addAll(cards);
    }

    public void clearHand() {
        hand.clear();
    }

    public Card removeCard(Card.Rank rank) {
        Card cardToRemove = null;
        for (Card card : hand)
            if (card.getRank().equals(rank)) {
                cardToRemove = card;
                break;
            }
        hand.remove(cardToRemove);
        return cardToRemove;
    }

    public String toString() {
        String cardsInHand = "Hand is Empty.";
        if (hand.size() > 0) {
            cardsInHand = " {"+hand.get(0).toString()+"}";
            for (int i = 1; i < hand.size(); i++)
                cardsInHand += " {" + hand.get(i).toString()+"}";
        }
        return cardsInHand;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
