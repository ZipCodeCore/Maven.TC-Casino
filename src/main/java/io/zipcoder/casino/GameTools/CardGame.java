package io.zipcoder.casino.GameTools;

import java.util.ArrayList;

public abstract class CardGame {
    int numberOfPlayers;
    int maxNumberOfPlayers;
    public ArrayList<Card> deck = new ArrayList<Card>();

    public void shuffleDeck() { }

    public Card deal() { return null; }


}
