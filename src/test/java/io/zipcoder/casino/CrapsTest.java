package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;
import org.junit.*;

public class CrapsTest {

    CrapsPlayer jeff = new CrapsPlayer("jeff", 50.00);
    Craps cPlayer = new Craps();
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

//    @Test
//    public void betTest() {
//        Double expected = 10.0;
//        Double actual = blackjackPlayer.bet(10.0);
//        Assert.assertEquals(expected, actual);
//    }
//
//    @Test
//    public void getWinningsTest() {
//        Double expected = 1100.0;
//        cPlayer.addWinnings();
//        Double actual = blackjackPlayer.checkBalance();
//
//        Assert.assertEquals(expected, actual);
//    }
}
