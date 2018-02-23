package io.zipcoder.casinotest.test.GameTest.diceGameTest;

import io.zipcoder.casino.Game.diceGame.Craps.CrapsGame;
import io.zipcoder.casino.Game.diceGame.Craps.CrapsPlayer;
import io.zipcoder.casino.Game.diceGame.DiceGame;
import io.zipcoder.casino.Game.diceGame.Die;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class DiceGameTest {

    DiceGame testGame;
    Player stinkyPete;
    Player smellyPeter;


    @Before
    public void setup(){
        stinkyPete = new Player();
        smellyPeter = new Player();
        testGame = new CrapsGame(stinkyPete);

    }

    @Test
    public void createDieTest1(){
        //Given
        int faces = 6;
        int number = 2;

        //When
        int[] expected = {6,6};
        testGame.createDie(faces,number);
        Die[] actualDice = testGame.getDice();
        int[] actual = {actualDice[0].getNumberOfFaces(), actualDice[1].getNumberOfFaces()};

        //Then
        Assert.assertTrue(Arrays.equals(expected,actual));
    }

    @Test
    public void createDieTest2(){
        //Given
        int faces = 20;
        int number = 5;

        //When
        int[] expected = {20,20,20,20,20};
        testGame.createDie(faces,number);
        Die[] actualDice = testGame.getDice();
        int[] actual = {actualDice[0].getNumberOfFaces(), actualDice[1].getNumberOfFaces(), actualDice[2].getNumberOfFaces(),
                actualDice[3].getNumberOfFaces(), actualDice[4].getNumberOfFaces()};

        //Then
        Assert.assertTrue(Arrays.equals(expected,actual));
    }

    @Test
    public void rollDiceTest1(){
        //Given

        testGame.createDie(6,2);


        //When
        int expectedlowerBound = 1;
        int expectedupperBound = 6;
        boolean actual = areOutOfBounds(expectedlowerBound, expectedupperBound);

        //Then
        Assert.assertFalse(actual);


    }

    @Test
    public void rollDiceTest2(){
        //Given
        testGame.createDie(20,5);

        //When
        int expectedlowerBound = 1;
        int expectedupperBound = 20;
        boolean actual = areOutOfBounds(expectedlowerBound, expectedupperBound);

        //Then
        Assert.assertFalse(actual);
    }

    @Test
    public void addPlayerTest(){
        //Given
        //DiceGame testGame

        //When
        Player expected = stinkyPete;
        testGame.addPlayer(stinkyPete);
        ArrayList<Player> actual = testGame.getPlayers();

        //Then
        Assert.assertTrue(actual.contains(expected));
    }

    @Test
    public void addPlayerTwiceTest(){
        //Given
        //DiceGame testGame

        //When
        Player expected2 = smellyPeter;
        testGame.addPlayer(smellyPeter);
        testGame.addPlayer(smellyPeter);
        testGame.addPlayer(smellyPeter);
        ArrayList<Player> actual = testGame.getPlayers();

        //Then
        Assert.assertTrue(actual.contains(expected2) && actual.size() == 2);
    }

    @Test
    public void removePlayerTest(){
        //Given
        //DiceGame testGame
        testGame.addPlayer(smellyPeter);

        //When

        Player notExpected = smellyPeter;
        testGame.removePlayer(smellyPeter);
        ArrayList<Player> actual = testGame.getPlayers();

        //Then
        Assert.assertFalse(actual.contains(notExpected));
    }

    @Test
    public void removeNonExistentPlayerTest(){
        //Given
        //DiceGame testGame
        testGame.addPlayer(smellyPeter);

        //When
        Player notExpected = smellyPeter;
        testGame.removePlayer(smellyPeter);
        testGame.removePlayer(smellyPeter);
        ArrayList<Player> actual = testGame.getPlayers();


        //Then
        Assert.assertFalse(actual.contains(notExpected));
    }



    private boolean areOutOfBounds(int expectedLowerBound, int expectedUpperBound) {
        for(int i = 0; i< 100000; i++){
            int[] testRolls = testGame.rollDice();
            //System.out.println(Arrays.toString(testRolls));
            for (int roll : testRolls) {
                if (roll < expectedLowerBound || roll > expectedUpperBound) {
                    return true;
                }
            }
        }
        return false;
    }

}
