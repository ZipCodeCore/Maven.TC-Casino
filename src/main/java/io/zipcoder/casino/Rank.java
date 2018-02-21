package io.zipcoder.casino;

public enum Rank {

    DEUCE(2,"2"),
    THREE(3,"3"),
    FOUR(4,"4"),
    FIVE(5,"5"),
    SIX(6,"6"),
    SEVEN(7,"7"),
    EIGHT(8,"8"),
    NINE(9,"9"),
    TEN(10,"10"),
    JACK(11,"J"),
    QUEEN(12,"Q"),
    KING(13,"K"),
    ACE(1,"A");

    final int rankValue;
    final String rankSymbol;

    Rank(int rankValue, String rankSymbol) {
        this.rankValue = rankValue;
        this.rankSymbol = rankSymbol;
    }

    public int toInt() {
        return this.rankValue;
    }

    public String toString() {
        return this.rankSymbol;
    }

}
