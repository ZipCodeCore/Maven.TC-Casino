package io.zipcoder.casino;

public interface Gamble {
    public void takeBet(Player player, Double amount);

    public void payOutBets();
}
