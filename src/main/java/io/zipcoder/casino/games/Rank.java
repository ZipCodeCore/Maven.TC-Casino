package io.zipcoder.casino.games;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/22/18
 */
public enum Rank {
    TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8), NINE(9), TEN(10),
    JACK(10), QUEEN(10), KING(10), ACE(1);

    Rank(int value) {
        this.value = value;
    }

    int value;
}
