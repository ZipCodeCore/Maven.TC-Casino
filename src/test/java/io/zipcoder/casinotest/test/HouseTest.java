package io.zipcoder.casinotest.test;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.diceGame.DiceGame;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Profile;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HouseTest {


    private double intialBalance1;
    private double intialBalance2;
    private String playerName1;
    private String playerName2;

    private Profile profile1;
    private Profile profile2;
    private Profile profile3;
    private CardGame game1;
    private DiceGame game2;
    private ArrayList<Profile> listOfProfiles;
    private House casino;

    @Before

    public void setUp() throws Exception {
        intialBalance1 = 1000.0;
        intialBalance2 = 2000.0;
        playerName1 = "John";
        playerName2 = "Stella";

       //profile1 = new Profile(playerName1, intialBalance1, 0);
       //profile2 = new Profile(playerName2, intialBalance2, 0);
      //  profile3 = new Profile("Susan", 10.00);

        //casino.createProfile(playerName1, intialBalance1);
        //casino.createProfile(playerName2, intialBalance2);
        //listOfProfiles = new ArrayList<>();
        casino = new House();
        casino.createProfile(playerName1, intialBalance1);

    }


    @Test
    public void getProfileTest() {
        Profile expected = profile1;
      //  Profile actual = casino.getProfile(profile1);
       // assertEquals(expected, actual);
    }

    @Test
    public void chooseGame() {
    }

    @Test
    public void chooseCardGame() {
    }

    @Test
    public void chooseDiceGame() {
    }

    @Test
    public void createProfile() {
        casino.createProfile(playerName1, intialBalance1);
        Profile expexted = profile1;
       Profile actual = casino.getProfileById(1);

      assertEquals(expexted, actual);
    }


    @Test
    public void selectExistingProfile() {
    }

    @Test
    public void removeProfile() {
    }
}