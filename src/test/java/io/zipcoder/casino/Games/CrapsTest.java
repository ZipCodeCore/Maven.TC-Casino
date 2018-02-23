package io.zipcoder.casino.Games;

import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {

    @Test
    public void userPlacesBetTest() {
    Craps crapsTest = new Craps();
    String expected = "Pass Line";
    String actual = crapsTest.userPlacesBet();

    Assert.assertEquals(expected, actual);
    }

    @Test
    public void addDieValuesTogetherTest() {

    }

    @Test
    public void ifPassLineTest() {

    }

    @Test
    public void playAgainTest() {

    }

    @Test
    public void ifDontPassLineTest() {

    }

    @Test
    public void playDifferentGame() {

    }

}
