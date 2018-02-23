package io.zipcoder.casino.Game.cardGame.utilities;


import java.util.ArrayList;

public class Hand {
    private ArrayList<Card>hand;

    public Hand(ArrayList<Card> cards) {
        this.hand = cards;
    }

    public void addCard(Card aCard){
        hand.add(aCard);

    }
    public void removeCard(Card thisCard){
        hand.remove(thisCard);
    }

    public void clear(){
        hand.clear();
    }

    public boolean hasCard(Card thisCard){

        if (hand.contains(thisCard)) {
            return true;
        }
        return false;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }



}
