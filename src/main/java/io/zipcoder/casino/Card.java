package io.zipcoder.casino;

public class Card {
    private Suit suit;
    public static String[] suitSymbols = {"♡", "♢", "♧", "♤"};
    public static String[] faceSymbols = {"A", "J", "Q", "K"};
    private Integer value;
    private String cardRepresentation;

    private Card() { }

    public Card(Suit suit, Integer value) {
        this.suit = suit;
        this.value = value;
    }

    public Card(Suit passedSuit, Integer passedValue, String passedSuitRepresentation, String passedFaceRepresentation) {
        suit = passedSuit;
        value = passedValue;
        cardRepresentation = String.format("%s%-4s", passedFaceRepresentation, passedSuitRepresentation);
    }

    @Override
    public String toString() {
        return cardRepresentation;
    }

    public String getCardRepresentation() {
        return cardRepresentation;
    }

    public Integer getValue() {
        return value;
    }

    public Suit getSuit() {
        return suit;
    }
}