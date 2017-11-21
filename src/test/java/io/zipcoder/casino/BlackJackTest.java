package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BlackJackTest {

    BlackJack blackJack = new BlackJack();

    @Test
    public void playersAddTest(){
        Player abrar = new Player("el pato");
        Player greg = new Player("el pato");
        blackJack.addPlayer(abrar);
        blackJack.addPlayer(greg);
        int expected = 2;
        int actual = blackJack.getPlayers().size();
        Assert.assertEquals(expected, actual);
    }




}
