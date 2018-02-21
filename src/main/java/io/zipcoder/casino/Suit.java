package io.zipcoder.casino;

public enum Suit {

    CLUBS("clubs", "\u2663"),
    DIAMONDS("diamonds", "\u2666"),
    HEARTS("hearts", "\u2665"),
    SPADES("spades", "\u2660");

    final String suitWord;
    final String suitSymbol;

    Suit(String suitWord, String suitSymbol) {
        this.suitWord = suitWord;
        this.suitSymbol = suitSymbol;
    }

    public String toString() {
        return this.suitWord;
    }

    public String toSymbol() {
        return this.suitSymbol;
    }

}
