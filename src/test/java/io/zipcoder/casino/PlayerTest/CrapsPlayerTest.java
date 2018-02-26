package io.zipcoder.casino.PlayerTest;


import io.zipcoder.casino.Games.Craps;
import io.zipcoder.casino.Players.CrapsPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrapsPlayerTest {
    Player bob = new Player("Bob", 30, 500);
    CrapsPlayer bobCrapsPlayer;
    Craps game;

    @Before
    public void setup() {
        bobCrapsPlayer = new CrapsPlayer(bob);
        game = new Craps(bob);
    }

    @Test
    public void constructorTest() {
        String expected = "Bob";
        String actual = bobCrapsPlayer.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lostMoneyTest() {
        int moneyTest = 500;
        game.setPlayerBetAmount(500);
        bobCrapsPlayer.lostMoney(500);
        Assert.assertTrue(bob.getBalance() == 0);
    }

    @Test
    public void wonMoneyTest() {
        int moneyTest = 500;
        game.setPlayerBetAmount(500);
        bobCrapsPlayer.wonMoney(500);
        Assert.assertTrue(bob.getBalance() == 1000);
    }

}
