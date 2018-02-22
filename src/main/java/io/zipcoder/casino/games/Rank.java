package io.zipcoder.casino.games;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/22/18
 */
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

    private Integer scoreValue;
    private Integer aceValue2;


    Rank(int scoreValue) {
        this(scoreValue, null);
    }

    Rank(int scoreValue, Integer aceValue2) {
        this.scoreValue = scoreValue;
        this.aceValue2 = aceValue2;
    }

    public Integer getScoreValue() {
        return scoreValue;
    }

    public Integer getAceValue2() {
        return aceValue2;
    }
}
