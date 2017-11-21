package io.zipcoder.casino;

public interface Gamble {

    Double pot = 0.0;

    void placeBet(Double money);

    public boolean hasMoneyToMakeBet(Double amount);

    public void cashInWinnings(Double winnings);

}
