package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class WalletTest {
    Wallet dummy;

    @Test
    public void constructorTest(){
        dummy = new Wallet(1000);
        int actual = 1000;
        int expected = dummy.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void defaultConstructorTest(){
        dummy = new Wallet();
        int expected = 0;
        int actual = dummy.getBalance();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void addMoneyTest(){
        dummy = new Wallet(5);
        dummy.add(5);
        int expected = 10;
        int actual = dummy.getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void subtractMoneyTest(){
        dummy = new Wallet(5);
        dummy.subtract(5);
        int expected = 0;
        int actual = dummy.getBalance();
        Assert.assertEquals(expected, actual);
    }
}
