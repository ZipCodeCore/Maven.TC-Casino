package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;
import org.junit.*;

public class CrapsPlayerTest {

    CrapsPlayer cPlayer = new CrapsPlayer("Jeff", 100.00);
    @Test
    public void bet() throws Exception {
    }

    @Test
    public void bet1() throws Exception {
    }

    @Test
    public void addWinnings() throws Exception {
    }

    @Test
    public void firstRollForSeven()  {

        CrapsPlayer.shooter = 7;

        String expected = "You win!";

        String actual = CrapsPlayer.firstRoll();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void firstRollForEleven()  {

        CrapsPlayer.shooter = 11;

        String expected = "You win!";

        String actual = CrapsPlayer.firstRoll();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void firstRollForTwo()  {

        CrapsPlayer.shooter = 2;

        String expected = "You lose!";

        String actual = CrapsPlayer.firstRoll();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void nextRoll()  {
    }
}
