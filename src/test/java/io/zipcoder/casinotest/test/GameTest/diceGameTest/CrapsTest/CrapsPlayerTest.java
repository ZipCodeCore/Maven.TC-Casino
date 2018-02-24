package io.zipcoder.casinotest.test.GameTest.diceGameTest.CrapsTest;

import io.zipcoder.casino.CrapsBet;
import io.zipcoder.casino.Game.diceGame.Craps.CrapsPlayer;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Test;

public class CrapsPlayerTest {

    Profile stinkyProfile = new Profile("Stinky Pete", 100, 1);
    CrapsPlayer stinkyPete = new CrapsPlayer(stinkyProfile);

    @Test
    public void betAccountBalanceTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet(CrapsBet.PASS_LINE, 50);
        double expectedAccountBalance = 50;
        double actualAccountBalance = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expectedAccountBalance, actualAccountBalance, 0.01);
    }

    @Test
    public void betEscrowTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet(CrapsBet.PASS_LINE,75);
        double expectedEscrowBalance = 75;
        double actualEscrowBalance = stinkyPete.getEscrowBet(CrapsBet.PASS_LINE);

        //Then
        Assert.assertEquals(expectedEscrowBalance, actualEscrowBalance, 0.01);
    }

    @Test
    public void multipleBetEscrowTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet(CrapsBet.PASS_LINE, 25);
        stinkyPete.bet(CrapsBet.HARD_EIGHT, 10);
        double expectedPL = 25;
        double expectedHE = 10;
        double actualPL = stinkyPete.getEscrowBet(CrapsBet.PASS_LINE);
        double actualHE = stinkyPete.getEscrowBet(CrapsBet.HARD_EIGHT);

        //Then
        Assert.assertTrue(expectedPL == actualPL && expectedHE == actualHE);
    }

    @Test
    public void multipleBetAccountDebitTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet(CrapsBet.PASS_LINE, 25);
        stinkyPete.bet(CrapsBet.HARD_EIGHT, 10);
        double expected = 65;
        double actual = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void addToExistingBetTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet(CrapsBet.PASS_LINE, 25);
        stinkyPete.bet(CrapsBet.PASS_LINE, 75);
        double expected = 100;
        double actual = stinkyPete.getEscrowBet(CrapsBet.PASS_LINE);

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void placeBetWithoutMoneyTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet(CrapsBet.PASS_LINE, 25);
        stinkyPete.bet(CrapsBet.PASS_LINE, 125);
        double expectedBalance = 75;
        double actualBalance = stinkyPete.getProfile().getAccountBalance();
        double expectedEscrow = 25;
        double actualEscrow = stinkyPete.getEscrowBet(CrapsBet.PASS_LINE);

        //Then
        Assert.assertTrue(expectedBalance == actualBalance && expectedEscrow == actualEscrow);

    }



    @Test
    public void winTestOneToOnePayout(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet(CrapsBet.PASS_LINE, 50);

        //When
        double payoutMultiplier = 1;
        stinkyPete.win(CrapsBet.PASS_LINE, payoutMultiplier);
        double expectedAccountBalance = 150;
        double actualAccountBalance = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expectedAccountBalance,actualAccountBalance,0.01);
    }

    @Test
    public void winTestTwoPointFivePayout(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet(CrapsBet.ODDS, 50);

        //When
        double payoutMultiplier = 2.5;
        stinkyPete.win(CrapsBet.ODDS, payoutMultiplier);
        double expectedAccountBalance = 225;
        double actualAccountBalance = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expectedAccountBalance,actualAccountBalance,0.01);
    }

    @Test
    public void multipleBetWinTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet(CrapsBet.PASS_LINE, 25);
        stinkyPete.bet(CrapsBet.HARD_EIGHT, 25);
        stinkyPete.win(CrapsBet.PASS_LINE, 1);
        stinkyPete.win(CrapsBet.HARD_EIGHT, 9);
        double expected = 350;
        double actual = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void multipleBetSplitWinLossTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet(CrapsBet.PASS_LINE, 25);
        stinkyPete.bet(CrapsBet.HARD_EIGHT, 25);
        stinkyPete.win(CrapsBet.PASS_LINE, 1);
        stinkyPete.lose(CrapsBet.HARD_EIGHT);
        double expected = 100;
        double actual = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void winTestEmptyEscrowAfter(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet(CrapsBet.PASS_LINE, 50);

        //When
        stinkyPete.win(CrapsBet.PASS_LINE,1);
        double expectedEscrow = 0;
        double actualEscrow = stinkyPete.getEscrowBet(CrapsBet.PASS_LINE);

        //Then
        Assert.assertEquals(expectedEscrow,actualEscrow, 0.01);

    }

    @Test
    public void LoseTestMissingFromAccount(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet(CrapsBet.PASS_LINE, 50);

        //When
        stinkyPete.lose(CrapsBet.PASS_LINE);
        double expected = 50;
        double actual = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void LoseTestEmptyEscrow(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet(CrapsBet.PASS_LINE, 50);

        //When
        stinkyPete.lose(CrapsBet.PASS_LINE);
        double expected = 0;
        double actual = stinkyPete.getEscrowBet(CrapsBet.PASS_LINE);

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }


    @Test
    public void passLineTest(){
        //Given
        stinkyPete.setPassLine(false);

        //When
        boolean expected = false;
        boolean actual = stinkyPete.isPassLine();

        //Then
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void passLineTest2() {
        //Given
        stinkyPete.setPassLine(true);

        //When
        boolean expected = true;
        boolean actual = stinkyPete.isPassLine();

        //Then
        Assert.assertEquals(expected, actual);
    }


}
