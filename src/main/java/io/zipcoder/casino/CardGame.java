package io.zipcoder.casino;

import java.util.ArrayList;

public class CardGame extends Game {

    private Deck gameDeck;
    CardPlayer player = new CardPlayer();


    public CardGame(){



    }


    public void startPlayerTurn() {
//     this. gameDeck = gameDeck;
//     this.player = player;
    }

    public Deck getGameDeck() {
         Deck deck = new Deck();
         return deck;
    }

//    public void setGameDeck(Deck gameDeck) {
//        this.gameDeck = gameDeck;
//    }
}
