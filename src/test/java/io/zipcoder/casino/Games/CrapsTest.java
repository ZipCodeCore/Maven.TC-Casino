package io.zipcoder.casino.Games;

import io.zipcoder.casino.Players.CrapsPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrapsTest {

    @Before
    public void initialize(){

        CrapsPlayer crapsPlayerTest = new CrapsPlayer();
    }

    @Test
    public void passLineWinTest() {
        Craps crapsTest = new Craps();
        String expected = "You win!";
        String actual = crapsTest.passLineWin(1,7);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void passLineLoseTest(){
        Craps crapsTest = new Craps();
        String expected = "You win!";
        String actual = crapsTest.passLineLose(2,3);
        Assert.assertEquals(expected, actual);
    }
    }

    @Test
    public void ifDontPassLineTest() {

    }



}
