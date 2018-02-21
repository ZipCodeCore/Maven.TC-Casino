package io.zipcoder.casino;

public interface PlayForMoney {

    double makeBet(Double amount);

    double collectWinnings(boolean isWin);
}
