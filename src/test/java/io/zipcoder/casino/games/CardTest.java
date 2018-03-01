package io.zipcoder.casino.games;

import org.junit.Assert;
import org.junit.Test;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public class CardTest {
    @Test
    public void testCardConstruction() {
        Card c = new Card(Rank.ACE, Suit.SPADES);
        String expected = "ACE of SPADES";
        String actual = c.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetIntValue() {
        Card c = new Card(Rank.ACE, Suit.SPADES);
        int expected = 1;
        int actual = c.getIntValue();

        Assert.assertEquals(expected, actual);
    }
}
