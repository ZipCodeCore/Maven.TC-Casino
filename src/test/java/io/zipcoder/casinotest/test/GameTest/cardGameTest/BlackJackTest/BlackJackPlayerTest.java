package io.zipcoder.casinotest.test.GameTest.cardGameTest.BlackJackTest;


import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackPlayer;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackJackPlayerTest {

    Profile testProfile;
    BlackJackPlayer testBlackJackPlayer;


    @Before
    public void setup() {
        testProfile = new Profile("Lucky", 100000, 0);
        testBlackJackPlayer = new BlackJackPlayer(testProfile);
    }

    @Test
    public void getHasStoodTest1() {
        boolean actual = testBlackJackPlayer.getHasStood();
        Assert.assertFalse(actual);
    }

    @Test
    public void getHasStoodTest2() {
        boolean stoodStatus = true;
        testBlackJackPlayer.setHasStood(stoodStatus);
        boolean actual = testBlackJackPlayer.getHasStood();
        Assert.assertTrue(actual);
    }

    @Test
    public void getIsBustedTest1() {
        boolean actual = testBlackJackPlayer.getIsBusted();
        Assert.assertFalse(actual);
    }

    @Test
    public void getIsBustedTest2() {
        boolean bustedStatus = true;
        testBlackJackPlayer.setIsBusted(bustedStatus);
        boolean actual = testBlackJackPlayer.getIsBusted();
        Assert.assertTrue(actual);
    }

    @Test
    public void betTest1() {
        double betAmount = 100;
        testBlackJackPlayer.bet("Even Bet",betAmount);
        double expected = 99900;
        double actual = testProfile.getAccountBalance();
    }

    @Test
    public void betTest2() {
        double betAmount = 500;


    }

    @Test
    public void winTest1() {

    }

    @Test
    public void winTest2() {

    }

    @Test
    public void loseTest1() {

    }

    @Test
    public void loseTest2() {

    }


}
