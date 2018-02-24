package io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest;

import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFishPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoFishPlayerTest {

    Profile testProfile;
    GoFishPlayer testGoFishPlayer;

    @Before
    public void setUp() {
        testProfile = new Profile("Kibret",5000, 0);
        testGoFishPlayer = new GoFishPlayer(testProfile);
    }


    @Test
    public void testBuildBook(){


    }

    @Test
    public void setScoreTest(){
        int expected = 10;
        testGoFishPlayer.setScore(10);
        int actual = testGoFishPlayer.getScore();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getScoreTest(){
        int expected = 25;
        testGoFishPlayer.setScore(15);
        int actual = testGoFishPlayer.getScore();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void setHandTest() {
        Profile anotherProfile = new Profile("card player", 500, 5);
        GoFishPlayer anotherCardPlayer = new GoFishPlayer(anotherProfile);
        Hand cardPlayerHand = new Hand();
        anotherCardPlayer.setHand(cardPlayerHand);
        Hand expected = cardPlayerHand;
        Hand actual = anotherCardPlayer.getHand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest() {
        Assert.assertNotNull(testGoFishPlayer.getHand());

    }



}