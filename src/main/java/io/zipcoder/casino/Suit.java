package io.zipcoder.casino;

public enum Suit
{
    HEART( "♡"),
    DIAMOND("♢"),
    CLUB("♤"),
    SPADE("♧");

    private String cardSymbol;

    Suit( String cardSymbol) {
        this.cardSymbol = cardSymbol;
    }


    public String getCardSymbol() {
        return cardSymbol;
    }
}