package io.zipcoder.casino;

import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;

public class CardPlayer extends Player{
    ArrayList<Card> hand;

    public CardPlayer() {
        super("cardPlayer",0,0);
        hand = new ArrayList<>();
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public void clearHand(){
        hand.clear();
    }

    public String getStringDisplayHand(){
        String output = "";
        Card card;
        for (int i=0; i<hand.size(); i++)
        {
            card=hand.get(i);
            if (i!=hand.size()-1)
                output += card.getTopCardRepresentation();
            else
                output+= card.toString();
        }
        return output;
    }

}
