package io.zipcoder.casino.nuts_n_bolts.cards;

public enum PlayingSuit {

    HEART("♡"),
    DIAMOND("♢"),
    CLUB("♧"),
    SPADE("♤");

    String symbol;

    PlayingSuit(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }

}
