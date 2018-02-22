package io.zipcoder.casinotest.test;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.diceGame.DiceGame;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class HouseTest {


    private double intialBalance1;
    private String playerName1;
    private String playerName2;

    private CardGame game1;
    private DiceGame game2;
    private ArrayList<Profile> listOfProfiles;
    private House casino;

    @Before

    public void setUp() throws Exception {
        intialBalance1 = 1000.0;
        playerName1 = "John";
        playerName2 = "Stella";

        casino = new House();
        //casino.createProfile(playerName1, intialBalance1);

    }


    @Test
    public void getProfileTest() {
        Profile expected = new Profile(playerName1, intialBalance1, -8);
        casino.createProfile(expected);
        Profile actual = casino.getProfileById(-8);

        assertEquals(expected, actual);
    }


//    @Test
//    public void chooseCardGame() {
//
//
//        String cardGame = "Black Jack";
//       CardGame actual =  casino.chooseCardGame(cardGame);
//       CardGame expected =
//    }

    @Test
    public void chooseDiceGame() {
    }

    @Test
    public void createProfile() {
        Profile expexted = new Profile(playerName2, intialBalance1, 1);
        casino.createProfile(expexted);
        Profile actual = casino.getProfileById(1);
        Assert.assertEquals(expexted, actual);
    }


    @Test
    public void selectExistingProfile() {

    }

    @Test
    public void removeProfile() {
    }
}