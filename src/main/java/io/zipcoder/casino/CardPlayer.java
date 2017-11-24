package io.zipcoder.casino;

import java.util.ArrayList;

public class CardPlayer extends Player {

    private ArrayList<Card> hand;

    public CardPlayer(String name, Double money) {
        super(name, money);
        hand = new ArrayList<Card>();
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

    public Card givePlayerCard(Card card){
        Card cardToGive = card;
        hand.remove(card);
        return cardToGive;
    }

    @Override
    public String toString() {
        String output = "";
        for (Card card : hand){
            output += card.getValue() + " of " + card.getSuit() + "\n";
        }
        output = output.trim();
        return output;
    }
}
