package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DealerWalletTest {

    @Test
    public void dealerWalletRemoveTest() {
        DealerWallet testWallet = new DealerWallet();
        testWallet.removeChipsFromAmount(500);
        Integer expected = Integer.MAX_VALUE;
        Integer actual = testWallet.checkChipAmount();
        Assert.assertEquals(expected, actual);
    }
}
