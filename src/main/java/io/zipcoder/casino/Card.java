package io.zipcoder.casino;

public class Card {

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    // Modified toString on Sat Feb 24 to: rank + "" + suit;
//    public String toString() {
//        return rank + " of " + suit;
//    }
    public String toString() {
        return rank + "" + suit;
    }

}
