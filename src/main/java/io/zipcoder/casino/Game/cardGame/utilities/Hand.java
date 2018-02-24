package io.zipcoder.casino.Game.cardGame.utilities;


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

    public boolean hasCard(Card thisCard){

        if (cards.contains(thisCard)) {
            return true;
        }
        return false;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }





}
