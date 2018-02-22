package io.zipcoder.casino;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public class Card {
    public enum Rank {
        TWO(2),
        THREE(3),
        FOUR(4),
        FIVE(5),
        SIX(6),
        SEVEN(7),
        EIGHT(8),
        NINE(9),
        TEN(10),
        JACK(10),
        QUEEN(10),
        KING(10),
        ACE(1, 11);

        private Integer val1;
        private Integer val2;

        Rank(int val1) {
            this(val1, null);
        }

        Rank(int val1, Integer val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
        public Integer getVal1() {
            return val1;
        }
        public Integer getVal2() {
            return val2;
        }
    }

    public enum Suit {
        HEARTS,
        CLUBS,
        SPADES,
        DIAMONDS
    }

    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return String.format("%s of %s", rank.toString(), suit.toString());
    }

    public Integer getValue() {
        return rank.val1;
    }
}
