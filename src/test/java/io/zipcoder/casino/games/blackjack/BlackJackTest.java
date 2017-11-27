package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.nuts_n_bolts.MoneyContainer;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BlackJackTest {
    BlackJack blackJack = new BlackJack();

    @Test
    public void takeBet() throws Exception {
        Double expected = 40.50;
        blackJack.takeBet(40.50);
        Double actual = blackJack.showPot();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void settleBetTest() throws Exception {
        blackJack.takeBet(50.00);
        Double expected = 0.0;
        Double actual = blackJack.settleBet(60.00);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void settleBetTest1() throws Exception {

        blackJack.takeBet(50.00);
        Double expected = 20.00;
        Double actual = blackJack.settleBet(20.00);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void emptyPotTest() throws Exception {
        blackJack.takeBet(50.00);
        Double expected = 50.00;
        Double actual = blackJack.emptyPot();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void makeSureItIsAnEmptyPotTest() throws Exception {
        blackJack.takeBet(50.00);
        Double expected = 0.00;
        blackJack.emptyPot();
        Double actual = blackJack.showPot();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playTest() throws Exception {
        boolean expected = true;
        boolean actual =blackJack.play("Y");
        Assert.assertEquals(expected, actual);
    }
}