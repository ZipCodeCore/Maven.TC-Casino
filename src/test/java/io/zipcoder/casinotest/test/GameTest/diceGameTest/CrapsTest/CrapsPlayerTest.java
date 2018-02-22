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
        stinkyPete.bet(50);
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
        stinkyPete.bet(75);
        double expectedEscrowBalance = 75;
        double actualEscrowBalance = stinkyPete.getProfile().getEscrow();

        //Then
        Assert.assertEquals(expectedEscrowBalance, actualEscrowBalance, 0.01);
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
