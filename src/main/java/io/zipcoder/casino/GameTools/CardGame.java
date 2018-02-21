package io.zipcoder.casino.GameTools;

import java.util.ArrayList;

public abstract class CardGame {
    int numberOfPlayers;
    int maxNumberOfPlayers;
    public ArrayList<Card> deck = new ArrayList<Card>();

//    public void generateDeck(){
//        for (suit i = suit.S; i < suit.H; i++){
//
//        }
//    }

    public void generateDeck(){
        for (Rank currentRank: Rank.values()) {
            for (Suit currentSuit : Suit.values()){
                Card temp = new Card(currentRank, currentSuit);
                deck.add(temp);
            }
        }
    }

    public void shuffleDeck() { }

    public Card deal() { return null; }


}
