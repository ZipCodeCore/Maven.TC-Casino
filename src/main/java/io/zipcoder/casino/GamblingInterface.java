package io.zipcoder.casino;

import java.util.Map;

public interface GamblingInterface {
    int checkChipAmount(Person personToCheck);
    void placeBet(Person personPlacingBet, int betAmount);
    int getAnte();
    void bootPlayerFromGame(Person personToBoot);
    int checkPot();
}
