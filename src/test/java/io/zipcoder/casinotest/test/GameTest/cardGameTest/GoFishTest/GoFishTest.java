package io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest;

import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFish;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GoFishTest {

    private Profile testUserProfile;
    private GoFish testGame;


    @Before
    public void setup() {
        testUserProfile = new Profile("Kibret", 100000, 2);
        testGame = new GoFish(testUserProfile);
    }

    @Test
    public void dealTest1() {
        testGame.deal();
        int expected = 38;
        int actual = testGame.getDeck().countRemainingCards();
        Assert.assertEquals(expected, actual);
    }
//    @Test
//    public void transferTest1(){
//        testGame.transfer(testGame.getDeck().getCard(),testGame.);
//    }


}


