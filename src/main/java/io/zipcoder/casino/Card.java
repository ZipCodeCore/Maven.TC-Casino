package io.zipcoder.casino;


public class Card {

    enum Rank {

        JOKER, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

        public int getValue() {
            return ordinal() + 1;
        }
    }

    enum Suit {
        CLUBS((char)'\u2663'), SPADES((char)'\u2660'), HEARTS((char)'\u2665'), DIAMONDS((char)'\u2666');

        private char val;
         Suit(char val){
            this.val=val;
        }

    }


    private Rank rank;
    private Suit suit;

    public Card(Rank v, Suit s) {
        this.rank = v;
        this.suit = s;
    }

    public int getValue() {
        return rank.getValue();
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public String toString() {
        return rank + " of " + suit.val;
    }
}
