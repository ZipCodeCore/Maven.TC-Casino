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
        CrapsPlayer crapsPlayer = new CrapsPlayer("el Pato");

        CrapsBetType expected = CrapsBetType.PASSLINE;
        craps.setBetType(CrapsBetType.PASSLINE);

        CrapsBetType actual = craps.getBetType();

    }
    @Test
    public void shouldTakePlayerMoneyAndSetBetAmount(){
        Craps craps = new Craps();
        CrapsPlayer crapsPlayer = new CrapsPlayer("el Pato");

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
    public void isLossOnComeOutRoll(){
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
    public void TestPointSetUponNoResultComeoutRoll(){

        Craps craps = new Craps();
        craps.setBetType(CrapsBetType.DONTPASS);
        CrapsBetType dontPass = craps.getBetType();

        boolean flag = craps.isNoResultRoll(4, dontPass);

        Integer expected_point = 4;
        Integer actual_point = craps.getPoint();

        Assert.assertEquals(expected_point,actual_point);

    }

    @Test
    public void determineIfPlayerWinsOrLosesAfterPointHasBeenSet(){
        //given betType, roll
        Craps craps = new Craps();
        craps.setBetType(CrapsBetType.DONTPASS);
        CrapsBetType dontPass = craps.getBetType();

        boolean flag = craps.isNoResultRoll(4, dontPass);

        Assert.assertTrue(craps.isBetWin(7, CrapsBetType.DONTPASS));
        Assert.assertTrue(craps.isBetLoss(4, CrapsBetType.DONTPASS));
        Assert.assertTrue(craps.isBetLoss(5, CrapsBetType.DONTPASS));
        Assert.assertTrue(craps.isBetLoss(6, CrapsBetType.DONTPASS));

        Assert.assertTrue(craps.isBetLoss(7, CrapsBetType.PASSLINE));
        Assert.assertTrue(craps.isBetWin(4, CrapsBetType.PASSLINE));
    }



    @Test
    public void paysOutPlayerThatHasWon(){
        //given
        Craps craps = new Craps();
        CrapsPlayer crapsPlayer = new CrapsPlayer("el pato");
        crapsPlayer.setWallet(500.0);
        //when
        crapsPlayer.makeBet(100.0, craps);
        boolean wins = craps.isBetWinComeOut(7, CrapsBetType.PASSLINE);

        //then
        double expected = 600;
        double actual = craps.resolveBet(crapsPlayer, true);

        Assert.assertTrue(expected ==actual);

    }

    @Test
    public void takeMoneyFromPlayerThatHasLost(){
        //given
        Craps craps = new Craps();
        CrapsPlayer crapsPlayer = new CrapsPlayer("el pato");
        crapsPlayer.setWallet(500.0);
        //when
        crapsPlayer.makeBet(100.0, craps);
        boolean flag = craps.isBetWinComeOut(7, CrapsBetType.PASSLINE);
        double expected = 600;
        double actual = craps.resolveBet(crapsPlayer,flag);

        //then
        Assert.assertTrue(expected ==actual);

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