package io.zipcoder.casino;


import java.util.ArrayList;

public class GoFishPlayer extends Player<GoFishPlayer> implements Gamble {

    private ArrayList<Card> cardsInHand;

    GoFishPlayer (String name) {
        this.name = name;
    }

    public void dealGoFishHAnd(ArrayList<GoFishPlayer> players, Deck deck) {
        for (int i = 1; i <= 5; i++) {
            for (GoFishPlayer player : players)
                player.cardsInHand.add(deck.dealOneRandomCard());
        }
    }

    @Override
    public Double bet(Double bet) {
        return null;
    }

    public void addCardToHand(Card newCard) {
        cardsInHand.add(newCard);
    }
}
