package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;


public class CrapsTest {
    Craps craps = new Craps();

    @Test
    public void getPointTest() throws Exception {
        int expected = 0;
        int actual = craps.getPoint();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setPointTest() throws Exception {
        int expected = 12;
        craps.setPoint(12);
        int actual = craps.getPoint();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setPotTest() throws Exception {
        Double expected = 500.0;
        craps.setPot(500.0);
        Double actual = craps.getPot();
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void getPotTest() throws Exception {
        Double expected = 0.0;
        Double actual = craps.getPot();
        Assert.assertEquals(expected,actual,0);
    }

    @Test
    public void placeBetWhenHasMoneySoPotIsSetTest() throws Exception{
        Player crapsPlayer = new Player();
        craps.placeBet();
        Double expected;
        Double actual = craps.getPot();
    }

    @Test
    public void placeBetWhenHasMoneyToBetTest() throws Exception {
        Player crapsPlayer = new Player();
        Double expected;
        Double actual = crapsPlayer.getMoney();
        Assert.assertTrue();
    }

    @Test
    public void placeBetWhenDontHasMoneyToBetTest() throws Exception {
        Player crapsPlayer = new Player();
        Double expected;
        Double actual;
        Assert.assertFalse();
    }

    @Test
    public void hasMoneyToMakeBetTest() throws Exception {
    }

    @Test
    public void cashInWinningsTest() throws Exception {
    }

    @Test
    public void firstRollTest() throws Exception {
    }
}