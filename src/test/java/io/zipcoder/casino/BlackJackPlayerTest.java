package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackJackPlayerTest {

    Profile testProfile;
    BlackJackPlayer testBlackJackPlayer;


    @Before
    public void setup() {
        testProfile = new Profile("Lucky", 100000);
        testBlackJackPlayer = new BlackJackPlayer(testProfile);
    }

    @Test
    public void getHasStoodTest() {
        boolean actual = testBlackJackPlayer.getHasStood();
        Assert.assertFalse(actual);
    }

//    @Test
//    public void setHasStoodTest() {
//        boolean hasStood = true;
//        testBlackJackPlayer.setHasStood(hasStood);


//    }

    @Test
    public void getIsBustedTest() {

    }

    @Test
    public void setIsBustedTest() {

    }



}
