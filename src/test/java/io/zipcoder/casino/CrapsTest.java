package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

    Player player = new Player("Zach",5000,23);
    Craps test = new Craps(player);

    @Test
    public void winTest() {
        double expected = 6000;

        test.playerWin(1000);
        double actual = player.balance;

        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void loseTest() {
        double expected = 4000;

        test.playerLose(1000);
        double actual = player.balance;

        Assert.assertEquals(expected, actual, 0);
    }
}


