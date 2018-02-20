package io.zipcoder.casino.games;

public interface Gamble {

    public void takeBet(Double bet);
    public Double settleBet(Double winnings);//payout

}
