package io.zipcoder.casinotest.test.GameTest.diceGameTest.CrapsTest;

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
        stinkyPete.bet("Pass Line", 50);
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
        stinkyPete.bet("Pass Line",75);
        double expectedEscrowBalance = 75;
        double actualEscrowBalance = stinkyPete.getProfile().getEscrow("Pass Line");

        //Then
        Assert.assertEquals(expectedEscrowBalance, actualEscrowBalance, 0.01);
    }

    @Test
    public void multipleBetEscrowTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet("Pass Line", 25);
        stinkyPete.bet("Hard Eight", 10);
        double expectedPL = 25;
        double expectedHE = 10;
        double actualPL = stinkyPete.getProfile().getEscrow("Pass Line");
        double actualHE = stinkyPete.getProfile().getEscrow("Hard Eight");

        //Then
        Assert.assertTrue(expectedPL == actualPL && expectedHE == actualHE);
    }

    @Test
    public void multipleBetAccountDebitTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet("Pass Line", 25);
        stinkyPete.bet("Hard Eight", 10);
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
        stinkyPete.bet("Pass Line", 25);
        stinkyPete.bet("Pass Line", 75);
        double expected = 100;
        double actual = stinkyPete.getProfile().getEscrow("Pass Line");

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void placeBetWithoutMoneyTest(){
        //Given
        //CrapsPlayer stinkyPete

        //When
        stinkyPete.bet("Pass Line", 25);
        stinkyPete.bet("Pass Line", 125);
        double expectedBalance = 75;
        double actualBalance = stinkyPete.getProfile().getAccountBalance();
        double expectedEscrow = 25;
        double actualEscrow = stinkyPete.getProfile().getEscrow("Pass Line");

        //Then
        Assert.assertTrue(expectedBalance == actualBalance && expectedEscrow == actualEscrow);

    }



    @Test
    public void winTestOneToOnePayout(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet("Pass Line", 50);

        //When
        double payoutMultiplier = 1;
        stinkyPete.win("Pass Line", payoutMultiplier);
        double expectedAccountBalance = 150;
        double actualAccountBalance = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expectedAccountBalance,actualAccountBalance,0.01);
    }

    @Test
    public void winTestTwoPointFivePayout(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet("Pass Odds", 50);

        //When
        double payoutMultiplier = 2.5;
        stinkyPete.win("Pass Odds", payoutMultiplier);
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
        stinkyPete.bet("Pass Line", 25);
        stinkyPete.bet("Hard Eight", 25);
        stinkyPete.win("Pass Line", 1);
        stinkyPete.win("Hard Eight", 9);
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
        stinkyPete.bet("Pass Line", 25);
        stinkyPete.bet("Hard Eight", 25);
        stinkyPete.win("Pass Line", 1);
        stinkyPete.lose("Hard Eight");
        double expected = 100;
        double actual = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);

    }

    @Test
    public void winTestEmptyEscrowAfter(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet("Pass Line", 50);

        //When
        stinkyPete.win("Pass Line",1);
        double expectedEscrow = 0;
        double actualEscrow = stinkyPete.getProfile().getEscrow("Pass Line");

        //Then
        Assert.assertEquals(expectedEscrow,actualEscrow, 0.01);

    }

    @Test
    public void LoseTestMissingFromAccount(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet("Pass Line", 50);

        //When
        stinkyPete.lose("Pass Line");
        double expected = 50;
        double actual = stinkyPete.getProfile().getAccountBalance();

        //Then
        Assert.assertEquals(expected,actual,0.01);
    }

    @Test
    public void LoseTestEmptyEscrow(){
        //Given
        //CrapsPlayer stinkyPete
        stinkyPete.bet("Pass Line", 50);

        //When
        stinkyPete.lose("Pass Line");
        double expected = 0;
        double actual = stinkyPete.getProfile().getEscrow("Pass Line");

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
