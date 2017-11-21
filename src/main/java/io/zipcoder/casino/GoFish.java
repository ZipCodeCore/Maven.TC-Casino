package io.zipcoder.casino;

import java.util.ArrayList;

public class GoFish extends CardGame {


    public GoFish(){
        this.gameDeck = new Deck();
        gameDeck.shuffle();
    }

    public Deck getGameDeck() {
        return gameDeck;
    }

    public Player endGameDeclareWinner(){
        return null;
    }

}
