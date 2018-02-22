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
}
