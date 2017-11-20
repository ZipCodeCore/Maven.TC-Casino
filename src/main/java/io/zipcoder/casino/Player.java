package io.zipcoder.casino;

import io.zipcoder.casino.Deck.Card;

import java.util.ArrayList;

public class Player {
    public String name;
    public double balance;
    public double age;
    public ArrayList<Card> playerHand = new ArrayList<Card>();

    public Player(String name, double balance, double age){
        this.name = name;
        this.balance = balance;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public ArrayList<Card> getPlayerHand() {
        return playerHand;
    }

    public void setPlayerHand(ArrayList<Card> playerHand) {
        this.playerHand = playerHand;
    }

    public void addCard(Card card){
        playerHand.add(card);
    }

    public void clearHand(){
        playerHand.clear();
    }

    public String getStringDisplayHand(){
        String output = "";
        Card card;
        for (int i=0; i<playerHand.size(); i++)
        {
            card=playerHand.get(i);
            if (i!=playerHand.size()-1)
                output += card.getTopCardRepresentation();
            else
                output+= card.toString();
        }
        return output;
    }
}
