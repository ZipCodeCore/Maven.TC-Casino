package io.zipcoder.casino;

import java.util.ArrayList;
import java.util.Collections;


public class Hand {

    private ArrayList<Card> handArrayList;
    private ArrayList<Card> specificCardsArrayList;
    private Rank rank;
    private Suit suit;

    public Hand() {
        this.handArrayList = new ArrayList<Card>();
        this.specificCardsArrayList = new ArrayList<Card>();
    }

    public ArrayList<Card> getHandArrayList() {
        return handArrayList;
    }

    public ArrayList<Card> getSpecificCardsArrayList(Card... cards) {

        for (Card card : cards) {
            handArrayList.remove(card);
            specificCardsArrayList.add(card);
        }

        return specificCardsArrayList;
    }

    public void receiveCards(Card... cards) {
        for (Card card : cards) {
            handArrayList.add(0, card);
        }
    }

    public Card drawCardfromHand() {

        return handArrayList.remove(handArrayList.size() - 1);
    }

    public void clearHand() {
        handArrayList.clear();
    }

    public void shuffleHand() {
        Collections.shuffle(handArrayList);
    }

}
