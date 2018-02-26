package io.zipcoder.casino.shady;

import io.zipcoder.casino.core.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/25/18
 */
public class ManInBlackTest {
    private ManInBlack mib;
    private Player player;
    @Before
    public void setup() {
        mib = new ManInBlack();
        player = new Player();
    }

    @Test
    public void testIsValidChoiceLowDebtTrue() {
        Assert.assertTrue(mib.isValidChoice("yes"));
        Assert.assertTrue(mib.isValidChoice("no"));
    }

    @Test
    public void testIsValidChoiceLowDebtFalse() {
        Assert.assertFalse(mib.isValidChoice("dick move"));

    }

    @Test
    public void testIsValidChoiceTooMuchDebtTrue() {
        Assert.assertTrue(mib.isValidChoice("rock off"));
        Assert.assertTrue(mib.isValidChoice("roll"));
        Assert.assertTrue(mib.isValidChoice("run"));
    }

    @Test
    public void testIsValidChoiceTooMuchDebtFalse() {
        Assert.assertFalse(mib.isValidChoice("sfdghewjd"));
    }
}