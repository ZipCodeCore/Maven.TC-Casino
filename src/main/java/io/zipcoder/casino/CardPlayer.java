package io.zipcoder.casino;


import java.util.ArrayList;

public class CardPlayer extends Player{
    private ArrayList<Card> hand;




    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }
}

