package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CoinTest {

    private static Coin coin;

    @Before
    public void setup() {
        this.coin = new Coin();
    }

    /**
     * One of each test type should pass
     * Or maybe not because I'm a dingus and don't know how to make good tests but if you run them enough times you'll get the idea
     */

    @Test
    public void coinLogicTest1() {
        int expected = 1;
        int actual = coin.coinLogic();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void coinLogicTest2() {
        int expected = 2;
        int actual = coin.coinLogic();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void coinFlipTestHeads() {
        String expected = "heads";
        String actual = coin.flip();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void coinFlipTestTails() {
        String expected = "tails";
        String actual = coin.flip();
        Assert.assertEquals(expected, actual);
    }

}
