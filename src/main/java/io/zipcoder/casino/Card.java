package io.zipcoder.casino;

public class Card {
    private final CardValue value;
    private final Suit suit;
    public Card(Suit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }
}
