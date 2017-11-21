package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {
    Player player = new Player();

    @Test
    public void getNameTest() throws Exception {
        String expected = "Player";
        String actual = player.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest() throws Exception {
        String expected = "Leon";
        player.setName("Leon");
        String actual = player.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getMoneyTest() throws Exception {
        Double expected = 500.0;
        Double actual = player.getMoney();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setMoneyTest() throws Exception {
        Double expected = 1000.0;
        player.setMoney(1000.0);
        Double actual = player.getMoney();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasMoneyToMakeBetTest(){
        Assert.assertTrue(player.hasMoneyToMakeBet(250.0));
        Assert.assertFalse(player.hasMoneyToMakeBet(1000.0));
    }

    @Test
    public void receiveWinnings() {
        Double expected = 800.0;
        player.receiveWinnings(300.0);
        Double actual = player.getMoney();
        Assert.assertEquals(expected, actual);
    }
}