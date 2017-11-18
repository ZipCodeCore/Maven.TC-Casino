package io.zipcoder.casino.Player;

import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;

public class Player extends Person {
    private double amount;
    private ArrayList<Card> hand = new ArrayList();

    public Player(String name, int age) {
        super(name, age);
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void addToCard(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public void clearHand(){
        hand.clear();
    }

    public int getRoll(){
        int first = (int)(Math.random()*6+1);
        int second = (int)(Math.random()*6+1);
        return first+second;
    }
}
