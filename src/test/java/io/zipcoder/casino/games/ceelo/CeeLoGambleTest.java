package io.zipcoder.casino.games.ceelo;

import org.junit.Assert;
import org.junit.Test;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public class CeeLoGambleTest {
    @Test
    public void testWin() {
        long base = 43;
        CeeLoGamble bet = new CeeLoGamble(base);
        long expected = base * 2;
        long actual = bet.win();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testLose() {
        long base = 43;
        CeeLoGamble bet = new CeeLoGamble(base);
        long expected = 0;
        long actual = bet.lose();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPush() {
        long base = 43;
        CeeLoGamble bet = new CeeLoGamble(base);
        long expected = 43;
        long actual = bet.push();

        Assert.assertEquals(expected, actual);
    }
}
