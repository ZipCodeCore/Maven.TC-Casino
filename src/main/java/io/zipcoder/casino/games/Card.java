package io.zipcoder.casino.games;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public class Card {

    private Rank rank;
    private Suit suit;

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

    public Integer getIntValue() {
        return rank.value;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank.toString(), suit.toString());
    }

}
