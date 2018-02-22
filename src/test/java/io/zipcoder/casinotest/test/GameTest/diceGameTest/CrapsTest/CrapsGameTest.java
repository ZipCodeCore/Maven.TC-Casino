package io.zipcoder.casinotest.test.GameTest.diceGameTest.CrapsTest;

import io.zipcoder.casino.Game.diceGame.Craps.CrapsGame;
import io.zipcoder.casino.Game.diceGame.Craps.CrapsPlayer;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CrapsGameTest {

    CrapsGame testGame;
    Profile stinkyProfile = new Profile("Stinky Pete", 100000, 1);
    Player stinkyPete = new CrapsPlayer(stinkyProfile);


    @Before
    public void setup(){
        testGame = new CrapsGame();
        testGame.startGame();
    }

    @Test
    public void comeOutPhaseTest(){
        //Given
        //testGame

        //When
        ArrayList<Integer> expectedPoints = new ArrayList<Integer>();
        expectedPoints.add(4);
        expectedPoints.add(5);
        expectedPoints.add(6);
        expectedPoints.add(8);
        expectedPoints.add(9);
        expectedPoints.add(10);

        int actualPoint = testGame.getPoint();

        //Then
        Assert.assertTrue(expectedPoints.contains(actualPoint));
    }

    @Test
    public void getRollValueTest(){
        //Given
        //testGame

        //When
        int lowerExpectedBound = 2;
        int upperExpectedBound = 12;
        boolean actual = isRollOutOfBounds(lowerExpectedBound,upperExpectedBound);

        //Then
        Assert.assertFalse(actual);

    }

    @Test
    public void isCrapsTestTrue(){
        //Given
        int rollValue = 12;

        //When
        boolean expected = true;
        boolean actual = CrapsGame.isCraps(rollValue);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isCrapsTestFalse(){
        //Given
        int rollValue = 7;

        //When
        boolean expected = false;
        boolean actual = CrapsGame.isCraps(rollValue);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isNaturalTestTrue(){
        //Given
        int rollValue = 11;

        //When
        boolean expected = true;
        boolean actual = CrapsGame.isNatural(rollValue);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void isNaturalTestFalse(){
        //Given
        int rollValue = 4;

        //When
        boolean expected = false;
        boolean actual = CrapsGame.isNatural(rollValue);

        //Then
        Assert.assertEquals(expected,actual);
    }

    private boolean isRollOutOfBounds(int expectedLowerBound, int expectedUpperBound) {
        for (int i = 0; i < 100000; i++) {
            int roll = testGame.getRollValue();
            //System.out.println(roll);
            if (roll < expectedLowerBound || roll > expectedUpperBound) {
                return true;
            }
        }
        return false;
    }


}
