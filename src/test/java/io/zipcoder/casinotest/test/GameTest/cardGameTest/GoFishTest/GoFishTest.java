package io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest;

import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFish;

import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GoFishTest {

    private Profile testUserProfile;
    private GoFish testGame;
//    GoFishPlayer user;
//    GoFishPlayer dealer;


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


    @Test
    public void testGetDeck(){


    }

    @Test
    public void calculateScore(){


    }

    @Test
    public void testDecideWinner( ){



    }

    @Test
    public void testAddPlayer() {

    }

    @Test
    public void testRemovePlayer() {

    }

    @Test
    public void testStartGame() {

    }

    @Test
    public void testEndGame() {

    }

    @Test
    public void testGetRules() {


    }


}


