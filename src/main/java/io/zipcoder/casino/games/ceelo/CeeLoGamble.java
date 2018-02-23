package io.zipcoder.casino.games.ceelo;

import io.zipcoder.casino.interfaces.Gamble;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public class CeeLoGamble implements Gamble {
    private long base;

    public CeeLoGamble(long base) {
        this.base = base;
    }

    /**
     * CeeLo bet is 'even money', a win pays out double the bet amount
     *
     * @return double the bet amount
     */
    public long win() {
        return base * 2;
    }

    /**
     * loss gets you nothing
     *
     * @return 0 chips
     */
    public long lose() {
        return 0;
    }

    /**
     * player tied the banker, return the bet amount
     *
     * @return the number of chips originally bet
     */
    public long push() {
        return base;
    }
}
