package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {
    Craps crapsGame = new Craps();
    @Test
    public void testWonRound(){
        boolean expected = true;
        Assert.assertNotEquals(expected,crapsGame.wonRound());
    }
}
