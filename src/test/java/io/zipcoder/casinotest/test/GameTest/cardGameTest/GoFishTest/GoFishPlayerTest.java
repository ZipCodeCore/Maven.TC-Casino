package io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest;

import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFishPlayer;
import io.zipcoder.casino.Profile;
import org.junit.Before;
import org.junit.Test;

public class GoFishPlayerTest {
    Profile testProfile;
    GoFishPlayer testGoFishPlayer;

    @Before
    public void setUp() {
        testProfile = new Profile("Kibret",5000,0);
        testGoFishPlayer = new GoFishPlayer(testProfile);


    }
    @Test
    public void testBuildBook(){


    }





}