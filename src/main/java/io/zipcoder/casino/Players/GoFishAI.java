package io.zipcoder.casino.Players;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.InputOutput.InputOutput;

import java.util.ArrayList;
import java.util.List;


public class GoFishAI extends GoFishPlayer {
    private List<Card> cardHand;
    private int numPairs;


    public GoFishAI() {
        cardHand = new ArrayList<Card>();
        numPairs = 0;
    }

    public int getNumPairs() {
        return numPairs;
    }

}

