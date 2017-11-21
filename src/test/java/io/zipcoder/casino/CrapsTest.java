package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class CrapsTest {

    @Test
    public void shouldAskPlayerTypeOfBet(){
        Craps craps = new Craps();
        CrapsPlayer crapsPlayer = new CrapsPlayer();

        CrapsBetType expected = CrapsBetType.PASSLINE;
        craps.setBetType(CrapsBetType.PASSLINE);

        CrapsBetType actual = craps.getBetType();

    }
    @Test
    public void shouldTakePlayerMoneyAndSetBetAmount(){
        Craps craps = new Craps();
        CrapsPlayer crapsPlayer = new CrapsPlayer();

        Double expected = 50.0;
        craps.takeBet(expected);

        Double actual = craps.getPlayerBet();

        Assert.assertEquals(expected,actual, 0);
    }

    @Test
    public void isWinOnComeRoll(){
        //given betType
        Craps craps = new Craps();
        craps.setBetType(CrapsBetType.PASSLINE);
        CrapsBetType passBet = craps.getBetType();

        Assert.assertTrue(craps.isBetWinComeOut(7, passBet));
        Assert.assertTrue(craps.isBetWinComeOut(11, passBet));

        craps.setBetType(CrapsBetType.DONTPASS);
        CrapsBetType dontPassBet = craps.getBetType();

        Assert.assertTrue(craps.isBetWinComeOut(2, dontPassBet));
        Assert.assertTrue(craps.isBetWinComeOut(3, dontPassBet));


    }

    @Test
    public void isLossOnComeRoll(){
        //given betType
        Craps craps = new Craps();
        craps.setBetType(CrapsBetType.DONTPASS);
        CrapsBetType dontPass = craps.getBetType();

        Assert.assertTrue(craps.isBetLossComeOut(7, dontPass));
        Assert.assertTrue(craps.isBetLossComeOut(11, dontPass));

        craps.setBetType(CrapsBetType.PASSLINE);
        CrapsBetType passBet = craps.getBetType();

        Assert.assertTrue(craps.isBetLossComeOut(2, passBet));
        Assert.assertTrue(craps.isBetLossComeOut(3, passBet));
        Assert.assertTrue(craps.isBetLossComeOut(12,passBet));


    }

    @Test
    public void isNeitherWinNorLossOnComeOut(){
        //given betType
        Craps craps = new Craps();
        craps.setBetType(CrapsBetType.DONTPASS);
        CrapsBetType dontPass = craps.getBetType();

        Assert.assertTrue(craps.isNoResultRoll(4, dontPass));
        Assert.assertTrue(craps.isNoResultRoll(5, dontPass));
        Assert.assertTrue(craps.isNoResultRoll(6, dontPass));
        Assert.assertTrue(craps.isNoResultRoll(8, dontPass));
        Assert.assertTrue(craps.isNoResultRoll(9, dontPass));
        Assert.assertTrue(craps.isNoResultRoll(10, dontPass));
        Assert.assertTrue(craps.isNoResultRoll(12, dontPass));

        craps.setBetType(CrapsBetType.PASSLINE);
        CrapsBetType passBet = craps.getBetType();

        Assert.assertTrue(craps.isNoResultRoll(4, passBet));
        Assert.assertTrue(craps.isNoResultRoll(5, passBet));
        Assert.assertTrue(craps.isNoResultRoll(6, passBet));
        Assert.assertTrue(craps.isNoResultRoll(8, passBet));
        Assert.assertTrue(craps.isNoResultRoll(9, passBet));
        Assert.assertTrue(craps.isNoResultRoll(10, passBet));
      

    }



    @Test
    public void shouldDetermineIfPlayerWinsLosesOrSetsPointUponRoll(){
        //given betType, roll

        // when each of three diff scenarios are rolled

        // then Win/Lose/PointSet
    }

    @Test
    public void determineIfPlayerWinsOrLosesAfterPointHasBeenSet(){
        //given betType, roll
    }



    @Test
    public void paysOutPlayerThatHasWon(){

    }

    @Test
    public void shouldReturnTrueIfDicesAreSevenOrEleven(){
        Craps craps = new Craps();
        craps.setBetType(CrapsBetType.PASSLINE);
        CrapsBetType passBet = craps.getBetType();

        assertEquals(true, craps.isBetWinComeOut(7, passBet));
    }


    @Test
    // as a craps player I would like to roll again if I my roll
    // doesn't win or lose
    public void rollAgainTest(){
        Craps craps = new Craps();
        Integer roll = 5;

        craps.setBetType(CrapsBetType.PASSLINE);
        CrapsBetType passBet = craps.getBetType();
//        boolean flag = crapsGame.passBetLosesComeOut(roll);
        boolean flag2 = craps.isBetWinComeOut(roll, passBet);

     //   Assert.assertFalse();

    }


    //as a craps player would like to

 /*   @Test
    public void passBetWinsTest() throws Exception {
        Craps game = new Craps();
        game.setComeOut(true);
        Assert.assertTrue(game.passBetWinsComeOut(7));
        Assert.assertTrue(game.passBetWinsComeOut(11));

        game.setPoint(9);;
        Assert.assertTrue(game.passBetWins(9));


    }

    @Test
    public void passBetLosesTest() throws Exception {
        Craps game = new Craps();
        game.setComeOut(true);
        Assert.assertTrue(game.passBetLosesComeOut(2));
        Assert.assertTrue(game.passBetLosesComeOut(3));
        Assert.assertTrue(game.passBetLosesComeOut(12));

        game.setComeOut(false);
        game.setPoint(4);
        Assert.assertTrue(game.passBetLoses(7));
    }*/

    @Test
    public void dontPassWins() throws Exception {
    }

    @Test
    public void setBetType() throws Exception {
    }

    @Test
    public void placeBet() throws Exception {
    }

    @Test
    public void rollAgain() throws Exception {
    }

    @Test
    public void resolveBets() throws Exception {
    }

}