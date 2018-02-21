package io.zipcoder.casino.GameTools;

import java.util.ArrayList;
import java.util.Collections;

public abstract class CardGame {
    int numberOfPlayers;
    int maxNumberOfPlayers;
    public ArrayList<Card> deck = new ArrayList<Card>();

    public void generateDeck(){
        for (Rank currentRank: Rank.values()) {
            for (Suit currentSuit : Suit.values()){
                Card temp = new Card(currentRank, currentSuit);
                deck.add(temp);
            }
        }
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getMaxNumberOfPlayers() {
        return maxNumberOfPlayers;
    }

    public void setMaxNumberOfPlayers(int maxNumberOfPlayers) {
        this.maxNumberOfPlayers = maxNumberOfPlayers;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void shuffleDeck() {
        Collections.shuffle(this.deck);
    }

    public Card deal() { return null; }


}
