package io.zipcoder.casino;

import java.util.Map;

public interface GamblingInterface {
    int checkChipAmount();
    void placeBet(int betAmount);
    int getAnte();
    void bootPlayerFromGame();
    int chekcPot();
}
