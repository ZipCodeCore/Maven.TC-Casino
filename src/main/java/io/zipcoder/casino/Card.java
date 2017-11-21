package io.zipcoder.casino;

public class Card {
    private final int value;
    private final Suit suit;
    public Card(Suit suit, int value) {
        this.suit = suit;
        this.value = value;
    }
}
