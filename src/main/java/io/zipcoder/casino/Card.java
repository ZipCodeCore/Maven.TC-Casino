package io.zipcoder.casino;

public class Card {

    private CardValue value;
    private Suit suit;

    public Card(Suit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public String getSuitSymbols() {

        return suit.getSuit();
    }

    public int getCardsValue() {
        return value.getValue();
    }

    //while this method was not originally supposed to be required in this class it is because of the contracts
    //we have entered due to our arrangement of abstract and interfaces... had to make this empty method to use my
    //addCardsToHand and cardsInHand for Blackjack
    public void add(Card newCard) {
    }
}
