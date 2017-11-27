package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsPlayerTest {

    CrapsPlayer player;

    @Before
    public void setup() {
        player = new CrapsPlayer(new Player("Tester", 100, true), 10);
    }

    @Test
    public void getChipCount() throws Exception {
        int expected = 10;
        int actual = player.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void tradeInChips() throws Exception {
        int expected = 10;
        int actual = player.tradeInChips();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addChips() throws Exception {

        int plusValue = 10;

        int chipsBeforeAdd = player.getChipCount();
        player.addChips(plusValue);
        int chipsAfterAdd = chipsBeforeAdd + plusValue;

        int expected = chipsAfterAdd - chipsBeforeAdd;
        int actual = player.getChipCount();
    }

    @Test
    public void placeBet() throws Exception {
    }

}