package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;
import org.junit.*;

public class CrapsTest {

    CrapsPlayer jeff = new CrapsPlayer("jeff", 50.00);
    Craps cPlayer = new Craps();

    @Test
   public void firstRollForSeven()  {

        cPlayer.diceRollTotal = 7;

        String expected = "You rolled a: 7! You win!";

        String actual = cPlayer.firstRoll(jeff);

       Assert.assertEquals(expected,actual);
    }

    @Test
    public void firstRollForEleven()  {

        cPlayer.diceRollTotal = 11;

        String expected = "You rolled a: 11! You win!";

        String actual = cPlayer.firstRoll(jeff);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void firstRollForTwo()  {

        cPlayer.diceRollTotal = 2;

        String expected = "You rolled a: 2! You lose!";

        String actual = cPlayer.firstRoll(jeff);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void firstRollForOther()  {

        cPlayer.diceRollTotal = 5;
        String expected = "Your point has be set to: 5. Please roll again.";

        String actual = cPlayer.firstRoll(jeff);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void setPlayerPointTest()  {

       cPlayer.diceRollTotal = 5;
        cPlayer.firstRoll(jeff);
       int expected = 5;

        int actual = jeff.getPlayerPoint();

        Assert.assertEquals(expected,actual);
   }



    @Test
    public void nextRoll()  {
        //The roll is based on a random number so testing is iffy.
      cPlayer.diceRollTotal = 5;
      jeff.setPlayerPoint(5);
        cPlayer.nextRoll(jeff);
        jeff.getPlayerPoint();
        String expected = "You rolled...";

        String actual = Craps.gameMessage;

        Assert.assertEquals(expected,actual);

    }



    @Test
    public void addWinningsTest() {
        jeff.bet(25.00);
        Double expected = 50.0;
        Double actual = cPlayer.addWinnings();

        Assert.assertEquals(expected, actual);
    }
}
