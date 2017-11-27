package io.zipcoder.casino;


import java.util.ArrayList;

public  class CardPlayer extends Player{
    private ArrayList<Card> hand;

    public CardPlayer(String name) {
        super(name);
    }

    public CardPlayer(){
        super();
        this.hand = hand;
    }
    public ArrayList<Card> getHand() {
        return hand;
    }
}

