package io.zipcoder.casinotest.test;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackGame;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackPlayer;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.diceGame.DiceGame;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Player;
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
    private House casino;

    @Before

    public void setUp() throws Exception {
        intialBalance1 = 1000.0;
        playerName1 = "John";
        playerName2 = "Stella";

        casino = new House();

    }


    @Test
    public void getProfileTest() {

        Profile expected = new Profile(playerName1, intialBalance1, -8);
        casino.createProfile(expected);
        Profile actual = casino.getProfileById(-8);

        assertEquals(expected, actual);
    }

/*
    @Test
    public void chooseBlackCardGameTest() {
        Profile someProfile = new Profile(playerName1, intialBalance1, -5);
        String cardGame = "BlackJack";
        casino.createProfile(someProfile);

        Profile profile = casino.getProfileById(1);
        BlackJackPlayer player = new BlackJackPlayer(profile);

        CardGame expected = new BlackJackGame(player);
        CardGame actual = casino.chooseCardGame(cardGame);

        Assert.assertEquals(expected, actual);
    }*/

    @Test
    public void chooseDiceGame() {
    }

    @Test
    public void createProfileTest() {

        Profile expexted = new Profile(playerName2, intialBalance1, 1);
        casino.createProfile(expexted);
        Profile actual = casino.getProfileById(1);
        Assert.assertEquals(expexted, actual);
    }

    @Test
    public void createPlayerTest() {
        Profile user = new Profile("Tim", 100.0, 5);
        casino.createProfile(user);
        casino.createPlayer(user);
        Player expected = new Player(user);
        Player actual = casino.getPlayerById(5);

        assertEquals(true, expected.equals(actual));
    }


    @Test
    public void selectExistingProfile() {
    String playerName = "Sue";
    Profile expected = new Profile(playerName, 100.0, 2);
    casino.createProfile(expected);
    Profile actual = casino.selectExistingProfile(playerName);

    assertEquals(true,expected.equals(actual));
    }

    @Test
    public void removeProfileTest() {
        Profile player = new Profile("Tim", 100.0, 1);
        Profile testProfile = new Profile("Tim", 100.0, 2);

        casino.createProfile(testProfile);
        casino.createProfile(player);
        casino.removeProfile(player.getId());
        Profile expected = null;
        Profile actual = casino.getProfileById(player.getId());

        Assert.assertEquals(expected, actual);

    }
    @Test
    public void removePlayerTest() {
        Profile user = new Profile("Tim", 100.0, 2);
        casino.createProfile(user);
        casino.createPlayer(user);
        casino.removePlayer(user.getId());
        Player expected = null;
        Player actual = casino.getPlayerById(user.getId());

        assertEquals(true, expected.equals(actual));
    }


}