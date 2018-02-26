package io.zipcoder.casino.Game.cardGame.utilities;

public enum CardSuit {

//    DIAMONDS,
//    HEARTS,
//    SPADES,
//    CLUBS


    CLUBS("♧"), DIAMONDS("♢"), HEARTS("♡"), SPADES("♤");

    private final String suitSymbols;

    CardSuit(String symbol){
        this.suitSymbols = symbol;
    }

    public String getSuitSymbols() {
        return suitSymbols;
    }

}
