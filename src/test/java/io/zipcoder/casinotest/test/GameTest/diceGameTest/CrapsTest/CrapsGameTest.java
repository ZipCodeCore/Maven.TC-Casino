package io.zipcoder.casinotest.test.GameTest.diceGameTest.CrapsTest;

import io.zipcoder.casino.CrapsBet;
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
    Profile stinkyProfile = new Profile("Stinky Pete", 100, 1);
    Player stinkyPete = new Player(stinkyProfile);


    @Before
    public void setup(){
        testGame = new CrapsGame(stinkyProfile);
        testGame.startGame();
    }


    @Test
    public void chooseBetStopTest(){
        //Given
        //testGame
        String textBet = "stop";

        //When
        boolean expected = false;
        boolean actual = testGame.chooseBet(textBet);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void rollIsNaturalPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.PASS_LINE, 50);
        testGame.getCurrentPlayer().setPassLine(true);

        //When
        testGame.rollIsNaturalPayout();
        double expected = 150;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void rollIsNaturalPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.rollIsNaturalPayout();
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void rollIsCrapsPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.rollIsCrapsPayout(2);
        double expected = 150;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void rollIsCrapsPayoutPushTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.rollIsCrapsPayout(12);
        double expected = 100;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void rollIsCrapsPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.PASS_LINE, 50);
        testGame.getCurrentPlayer().setPassLine(true);

        //When
        testGame.rollIsCrapsPayout(3);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual &&
                testGame.getCurrentPlayer().getEscrowBet(CrapsBet.PASS_LINE) == 0);
    }

    @Test
    public void passLinePayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.PASS_LINE, 50);
        testGame.getCurrentPlayer().setPassLine(true);

        //When
        testGame.passLinePayout();
        double expected = 150;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void passLinePayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.passLinePayout();
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual &&
                testGame.getCurrentPlayer().getEscrowBet(CrapsBet.DO_NOT_PASS) == 0);

    }

    @Test
    public void doNotPassPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.doNotPassPayout();
        double expected = 150;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void doNotPassPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.PASS_LINE, 50);
        testGame.getCurrentPlayer().setPassLine(true);

        //When
        testGame.doNotPassPayout();
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual &&
                testGame.getCurrentPlayer().getEscrowBet(CrapsBet.PASS_LINE) == 0);

    }


    @Test
    public void invalidBetTest(){
        //Given
        boolean betCondition = true;

        //When
        boolean expected = true;
        boolean actual = testGame.isInvalidBet(betCondition);

        //Then
        Assert.assertEquals(expected,actual);


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
