package io.zipcoder.casinotest.test;

import io.zipcoder.casino.House;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PlayerTest {
    private String name1;
    private String name2;
    private double intialBalance1;
    private double intialBalance2;
    private Profile profile1;
    private Profile profile2;
    private Player player1;

    @Before
    public void setUp() throws Exception {
        name1 = "Sally";
        name2 = "Rachel";
        intialBalance1 = 100.0;
        intialBalance2 = 5.00;
        profile1 = new Profile(name1, intialBalance1, 0);
        profile2 = new Profile(name2, intialBalance2, 0);

        player1 = new Player(profile1);
    }

    @Test
    public void setPlayerTest(){
        player1.setProfile(profile2);
        Profile expexted = profile2;
        Profile actual = player1.getProfile();

        Assert.assertEquals(expexted, actual);
    }
    @Test
    public void setPlayer1Test(){
        player1.setProfile(profile2);
        Profile expexted = profile2;
        Profile actual = player1.getProfile();

        Assert.assertEquals(expexted, actual);
    }


}
