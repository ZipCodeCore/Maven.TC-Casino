package io.zipcoder.casino;

public class Card {

    private CardValue value;
    private Suit suit;

    public Card(Suit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuitSymbols(){

        return suit.getSuit();
    }

    public int getCardsValue() {
        return value.getValue();
    }
}
