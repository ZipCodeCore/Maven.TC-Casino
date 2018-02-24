package io.zipcoder.casino.Game.cardGame.utilities;


import io.zipcoder.casino.CasinoUtilities.Console;

import java.util.ArrayList;

public class Hand {

    private ArrayList<Card>cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public void addCard(Card card){
        cards.add(card);

    }
    public void removeCard(Card card){
        cards.remove(card);
    }

    public void clear(){
        cards.clear();
    }

    public boolean hasCard(Card thisCard) {

        if (cards.contains(thisCard)) {
            return true;
        }
        return false;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }


    public String showHand() {
      StringBuilder cards = new StringBuilder();
        for(Card aCard: getCards()){
        cards.append(aCard.toString() + ",");
    }
      return  null;//cards.toString();

    }
}