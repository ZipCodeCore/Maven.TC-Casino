package io.zipcoder.casinotest.test.GameTest.diceGameTest.CrapsTest;

import io.zipcoder.casino.Game.diceGame.Craps.CrapsBet;
import io.zipcoder.casino.Game.diceGame.Craps.CrapsGame;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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
    public void comePointPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.COME, 50);
        testGame.getCurrentPlayer().setCome(true);
        testGame.newComePoint(5);

        //When
        double expected = 150;
        testGame.comePointPayout(5);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void comePointPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.COME, 50);
        testGame.getCurrentPlayer().setCome(true);
        testGame.newComePoint(5);
        testGame.getCurrentPlayer().bet(CrapsBet.COME, 50);
        testGame.getCurrentPlayer().setCome(true);
        testGame.newComePoint(10);

        //When
        double expected = 0;
        testGame.comePointPayout(7);
        double actual1 = testGame.getCurrentPlayer().getEscrowBet(CrapsBet.COME_FIVE);
        double actual2 = testGame.getCurrentPlayer().getEscrowBet(CrapsBet.COME_TEN);
        double actual3 = testGame.getCurrentPlayer().getProfile().getAccountBalance();
        double actual4 = testGame.getCurrentPlayer().getComePoints().size();

        //Then
        Assert.assertTrue(expected == actual1 && expected == actual2 && expected == actual3 && expected == actual4);
    }

    @Test
    public void dontComePointPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 50);
        testGame.getCurrentPlayer().setDontCome(true);
        testGame.newDontComePoint(6);
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 50);
        testGame.getCurrentPlayer().setDontCome(true);
        testGame.newDontComePoint(8);

        //When
        double expected = 200;
        testGame.dontComePointPayout(7);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void dontComePointPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.DO_NOT_COME, 100);
        testGame.getCurrentPlayer().setDontCome(true);
        testGame.newDontComePoint(6);

        //When
        double expected = 0;
        testGame.dontComePointPayout(6);
        double actual1 = testGame.getCurrentPlayer().getProfile().getAccountBalance();
        double actual2 = testGame.getCurrentPlayer().getEscrowBet(CrapsBet.DO_NOT_COME_SIX);

        //Then
        Assert.assertTrue(expected == actual1 && expected == actual2);

    }

    @Test
    public void bigSixPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.BIG_SIX, 50);
        testGame.getCurrentPlayer().setBigSix(true);

        //When
        double expected = 150;
        testGame.bigSixPayout(6);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void bigSixPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.BIG_SIX, 50);
        testGame.getCurrentPlayer().setBigSix(true);

        //When
        double expected = 50;
        testGame.bigSixPayout(7);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual && testGame.getCurrentPlayer().getEscrowBet(CrapsBet.BIG_SIX) == 0);

    }

    @Test
    public void bigEightPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.BIG_EIGHT, 50);
        testGame.getCurrentPlayer().setBigEight(true);

        //When
        double expected = 150;
        testGame.bigEightPayout(8);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void bigEightPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.BIG_EIGHT, 50);
        testGame.getCurrentPlayer().setBigEight(true);

        //When
        double expected = 50;
        testGame.bigEightPayout(7);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual && testGame.getCurrentPlayer().getEscrowBet(CrapsBet.BIG_EIGHT) == 0);

    }

    @Test
    public void fieldPayoutWin2Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.FIELD, 50);
        testGame.getCurrentPlayer().setField(true);

        //When
        double expected = 200;
        testGame.fieldPayout(2);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void fieldPayoutWin3Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.FIELD, 50);
        testGame.getCurrentPlayer().setField(true);

        //When
        double expected = 150;
        testGame.fieldPayout(3);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void fieldPayoutWin12Test(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.FIELD, 50);
        testGame.getCurrentPlayer().setField(true);

        //When
        double expected = 250;
        testGame.fieldPayout(12);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void fieldPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.FIELD, 50);
        testGame.getCurrentPlayer().setField(true);

        //When
        double expected = 50;
        testGame.fieldPayout(7);
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual && testGame.getCurrentPlayer().getEscrowBet(CrapsBet.FIELD)==0);
    }

    @Test
    public void hardFourPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.HARD_FOUR,50);
        testGame.getCurrentPlayer().setHardFour(true);

        //When
        testGame.setHardRoll(true);
        testGame.hardFourPayout(4);
        double expected = 450;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void hardFourPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.HARD_FOUR,50);
        testGame.getCurrentPlayer().setHardFour(true);

        //When
        testGame.setHardRoll(false);
        testGame.hardFourPayout(4);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual && testGame.getCurrentPlayer().getEscrowBet(CrapsBet.HARD_FOUR) == 0);
    }

    @Test
    public void hardSixPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.HARD_SIX,50);
        testGame.getCurrentPlayer().setHardSix(true);

        //When
        testGame.setHardRoll(true);
        testGame.hardSixPayout(6);
        double expected = 550;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void hardSixPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.HARD_SIX,50);
        testGame.getCurrentPlayer().setHardSix(true);

        //When
        testGame.setHardRoll(false);
        testGame.hardSixPayout(7);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual && testGame.getCurrentPlayer().getEscrowBet(CrapsBet.HARD_SIX) == 0);
    }

    @Test
    public void hardEightPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.HARD_EIGHT,50);
        testGame.getCurrentPlayer().setHardEight(true);

        //When
        testGame.setHardRoll(true);
        testGame.hardEightPayout(8);
        double expected = 550;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void hardEightPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.HARD_EIGHT,50);
        testGame.getCurrentPlayer().setHardEight(true);

        //When
        testGame.setHardRoll(false);
        testGame.hardEightPayout(8);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual && testGame.getCurrentPlayer().getEscrowBet(CrapsBet.HARD_EIGHT) == 0);
    }

    @Test
    public void hardTenPayoutWinTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.HARD_TEN,50);
        testGame.getCurrentPlayer().setHardTen(true);

        //When
        testGame.setHardRoll(true);
        testGame.hardTenPayout(10);
        double expected = 450;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void hardTenPayoutLoseTest(){
        //Given
        //testGame
        testGame.getCurrentPlayer().bet(CrapsBet.HARD_TEN,50);
        testGame.getCurrentPlayer().setHardTen(true);

        //When
        testGame.setHardRoll(false);
        testGame.hardTenPayout(7);
        double expected = 50;
        double actual = testGame.getCurrentPlayer().getProfile().getAccountBalance();

        //Then
        Assert.assertTrue(expected == actual && testGame.getCurrentPlayer().getEscrowBet(CrapsBet.HARD_TEN) == 0);
    }

    @Test
    public void intToComePointTest(){
        //Given
        //testGame

        //When
        CrapsBet expected = CrapsBet.COME_EIGHT;
        CrapsBet actual = testGame.intToComePoint(8);

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void intToDontComePointTest(){
        //Given
        //testGame

        //When
        CrapsBet expected = CrapsBet.DO_NOT_COME_TEN;
        CrapsBet actual = testGame.intToDontComePoint(10);

        //Then
        Assert.assertEquals(expected,actual);
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
