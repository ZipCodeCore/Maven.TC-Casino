package io.zipcoder.casinotest.test.GameTest.cardGameTest;

import io.zipcoder.casino.Game.cardGame.CardPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardPlayerTest {

    CardPlayer testCardPlayer;
    Profile testProfile;

    @Before
    public void setUp() {
        testCardPlayer = new CardPlayer(testProfile);
    }

    @Test
    public void setScoreTest(){
      int expected = 10;
      testCardPlayer.setScore(10);
      int actual = testCardPlayer.getScore();
      Assert.assertEquals(expected, actual);
    }


    @Test
    public void getScoreTest(){
        int expected = 25;
        testCardPlayer.setScore(15);
        int actual = testCardPlayer.getScore();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void setHandTest() {
        Profile anotherProfile = new Profile("card player", 500, 5);
        CardPlayer anotherCardPlayer = new CardPlayer(anotherProfile);
        Hand cardPlayerHand = new Hand();
        anotherCardPlayer.setHand(cardPlayerHand);
        Hand expected = cardPlayerHand;
        Hand actual = anotherCardPlayer.getHand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest() {
        Assert.assertNotNull(testCardPlayer.getHand());

    }
}