package io.zipcoder.casino;

import java.util.ArrayList;

public class CardPlayer extends Player {

    private ArrayList<Card> hand = new ArrayList<Card>();

    public CardPlayer(String name, Double money) {
        super(name, money);

    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void takeCard(Card card){
        hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return this.hand;
    }
}
