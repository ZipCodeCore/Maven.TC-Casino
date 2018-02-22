package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class WalletTest {

    @Test
    public void addChipsTest() {
        Wallet testWallet = new Wallet();
        int expected = 500;
        testWallet.addChips(expected);
        int actual = testWallet.checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeChipsTest() {
        Wallet testWallet = new Wallet();
        testWallet.addChips(500);
        testWallet.removeChips(200);
        int expected = 300;
        int actual = testWallet.checkChipAmount();
        Assert.assertEquals(actual, expected);
    }
}
