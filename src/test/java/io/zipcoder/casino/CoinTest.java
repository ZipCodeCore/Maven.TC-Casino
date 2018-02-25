package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CoinTest {

    /**
     * One of each type of test should pass every time
     */

    @Test
    public void coinLogicTest1() {
        Coin coin = new Coin();
        int expected = 1;
        int actual = coin.coinLogic();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void coinLogicTest2() {
        Coin coin = new Coin();
        int expected = 2;
        int actual = coin.coinLogic();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void coinFlipTestHeads() {
        Coin coin = new Coin();
        String expected = "heads";
        String actual = coin.flip();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void coinFlipTestTails() {
        Coin coin = new Coin();
        String expected = "tails";
        String actual = coin.flip();
        Assert.assertEquals(expected, actual);
    }

}
