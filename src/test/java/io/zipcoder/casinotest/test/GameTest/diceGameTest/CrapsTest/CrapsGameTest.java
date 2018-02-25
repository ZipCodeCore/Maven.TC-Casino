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
    public void passLineOddsPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.PASS_LINE_ODDS, 50);
        testGame.getCurrentPlayer().setPassLine(true);

        //When
        testGame.passLineOddsPayout(3);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual &&
                testGame.getCurrentPlayer().getEscrowBet(CrapsBet.PASS_LINE_ODDS) == 0);

    }

    @Test
    public void passLineOddsPayoutWin4Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.PASS_LINE_ODDS, 50);
        testGame.getCurrentPlayer().setPassLine(true);

        //When
        testGame.passLineOddsPayout(4);
        double expected = 200;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void passLineOddsPayoutWin5Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.PASS_LINE_ODDS, 50);
        testGame.getCurrentPlayer().setPassLine(true);

        //When
        testGame.passLineOddsPayout(5);
        double expected = 175;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void passLineOddsPayoutWin6Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.PASS_LINE_ODDS, 50);
        testGame.getCurrentPlayer().setPassLine(true);

        //When
        testGame.passLineOddsPayout(6);
        double expected = 160;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void doNotPassOddsPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS_ODDS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.doNotPassOddsPayout(3);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual &&
                testGame.getCurrentPlayer().getEscrowBet(CrapsBet.DO_NOT_PASS_ODDS) == 0);

    }

    @Test
    public void doNotPassOddsPayoutWin4Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS_ODDS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.doNotPassOddsPayout(4);
        double expected = 125;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void doNotPassOddsPayoutWin5Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS_ODDS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.doNotPassOddsPayout(5);
        double expected = 133;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void doNotPassOddsPayoutWin6Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_PASS_ODDS, 50);
        testGame.getCurrentPlayer().setPassLine(false);

        //When
        testGame.doNotPassOddsPayout(6);
        double expected = 141.5;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

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
    public void comeNaturalPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.COME, 50);
        testGame.getCurrentPlayer().setCome(true);

        //When
        testGame.comeNaturalPayout(7);
        double expected = 150;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void comeNaturalPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 50);
        testGame.getCurrentPlayer().setDontCome(true);

        //When
        testGame.comeNaturalPayout(7);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual &&
                testGame.getCurrentPlayer().getEscrowBet(CrapsBet.DO_NOT_COME) == 0);

    }

    @Test
    public void doNotComeCrapsPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 50);
        testGame.getCurrentPlayer().setDontCome(true);

        //When
        testGame.doNotComeCrapsPayout(3);
        double expected = 150;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void doNotComeCrapsPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.COME, 50);
        testGame.getCurrentPlayer().setCome(true);

        //When
        testGame.doNotComeCrapsPayout(2);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual &&
                testGame.getCurrentPlayer().getEscrowBet(CrapsBet.COME) == 0);

    }

    @Test
    public void doNotComeCrapsPayoutPushTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 50);
        testGame.getCurrentPlayer().setDontCome(true);

        //When
        testGame.doNotComeCrapsPayout(12);
        double expected = 100;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual &&
                testGame.getCurrentPlayer().getEscrowBet(CrapsBet.DO_NOT_COME) == 0);

    }

    @Test
    public void changeComeBetTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.COME, 50);
        testGame.getCurrentPlayer().setCome(true);

        //When
        int roll = 4;
        double expected = 50;
        testGame.changeComeBet(roll);
        double actual = testGame.getCurrentPlayer().getEscrowBet(CrapsBet.COME_FOUR);

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void changeComeBetTest2(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.COME, 50);
        testGame.getCurrentPlayer().setCome(true);

        //When
        int roll = 8;
        double expected = 50;
        testGame.changeComeBet(roll);
        double actual = testGame.getCurrentPlayer().getEscrowBet(CrapsBet.COME_EIGHT);

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void setComePointTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.COME, 50);
        testGame.getCurrentPlayer().setCome(true);

        //When
        int roll = 4;
        testGame.setComePoint(roll);
        int expected = 4;
        boolean actual = testGame.getCurrentPlayer().getComePoints().contains(expected);

        //Then
        Assert.assertTrue(actual);
    }

    @Test
    public void changeDontComeBetTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 50);
        testGame.getCurrentPlayer().setDontCome(true);

        //When
        int roll = 4;
        double expected = 50;
        testGame.changeDontComeBet(roll);
        double actual = testGame.getCurrentPlayer().getEscrowBet(CrapsBet.DO_NOT_COME_FOUR);

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void changeDontComeBetTest2(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 50);
        testGame.getCurrentPlayer().setDontCome(true);

        //When
        int roll = 8;
        double expected = 50;
        testGame.changeDontComeBet(roll);
        double actual = testGame.getCurrentPlayer().getEscrowBet(CrapsBet.DO_NOT_COME_EIGHT);

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void setDontComePointTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 50);
        testGame.getCurrentPlayer().setDontCome(true);

        //When
        int roll = 4;
        testGame.setDontComePoint(roll);
        int expected = 4;
        boolean actual = testGame.getCurrentPlayer().getDontComePoints().contains(expected);

        //Then
        Assert.assertTrue(actual);
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
