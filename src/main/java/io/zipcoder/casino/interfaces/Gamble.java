package io.zipcoder.casino.interfaces;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public interface Gamble {
    /**
     * long win()
     * determine the amount a player is paid (usually as a modifier of baseValue)
     *
     * @return the (typically modified) value paid for a winning bet
     */
    long win();

    /**
     * long lose()
     * determines the amount paid out for a losing bet. (usually nothing if we're dealing with chips/money)
     * but could be 'SeveredBodyPart finger' or 'GamblePenalty.COAL' or whatever
     *
     * @return
     */
    long lose();
}
