package io.zipcoder.casino;

public enum Suit {

    CLUB("♧"), DIAMOND("♢"), HEART("♡"), SPADE("♤");

    private final String suitSymbols;

    Suit(String symbol){
        this.suitSymbols = symbol;
    }

    public String getSuit() {
        return suitSymbols;
    }
}
