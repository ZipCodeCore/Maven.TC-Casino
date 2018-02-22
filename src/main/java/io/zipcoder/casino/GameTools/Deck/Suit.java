package io.zipcoder.casino.GameTools.Deck;

public enum Suit {

    HEARTS("Hearts"),
    CLUBS("Clubs"),
    DIAMOND("Diamonds"),
    SPADE("Spades");

    private String suitValue;

    Suit(String suitValue){
        this.suitValue = suitValue;
    }

    public String getSuitValue() {
        return suitValue;
    }

}
