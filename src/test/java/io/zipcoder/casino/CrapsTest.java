package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsTest {

    CrapsPlayer player;
    Craps craps;

    @Before
    public void setup() {
        player = new CrapsPlayer(new Player("SumYunGai" , 9001, true), 100);
        craps = new Craps();
    }

    @Test
    public void payOut() throws Exception {
        int chipsBefore = player.getChipCount();
        craps.payOut(player, 100, 2);
        int chipsAfter = player.getChipCount();

        int expectedChange = 200;
        int actualChange = chipsAfter - chipsBefore;

        Assert.assertEquals(expectedChange, actualChange);
    }

}