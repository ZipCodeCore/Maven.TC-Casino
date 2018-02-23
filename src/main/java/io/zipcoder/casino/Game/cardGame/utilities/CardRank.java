package io.zipcoder.casino.Game.cardGame.utilities;

public enum CardRank {

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
    ACE(11);

//    private Integer cardValue2;
    private int cardValue;

//    CardRank(int value, Integer value2) {
//        this.cardValue = value;
//        this.cardValue2 = value2;
//    }

    CardRank(int value) {
        this.cardValue = value;
    }

    public int getCardValue() {
        return cardValue;
    }
}
