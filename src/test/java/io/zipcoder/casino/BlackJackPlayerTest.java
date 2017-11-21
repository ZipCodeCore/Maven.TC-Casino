package io.zipcoder.casino;


// -As a blackjack player I want to place a bet on a blackjack hand.

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)


public class BlackJackPlayerTest {

    BlackJack blackJack = new BlackJack();

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateExceptionWhenDeckIsNull() {
        BlackJackPlayer blackJackPlayer = new BlackJackPlayer("el pato");
        Deck deck = null;
        blackJackPlayer.startGame(deck);
        Assert.assertNull(deck);
    }

    @Test
    public void placeBetTest() {

        BlackJackPlayer blackJackPlayer = new BlackJackPlayer("el pato");
        blackJackPlayer.setBet(10);
        double actual = 10;
        double expected = blackJack.betReceiveFromPlayers();// 10
        Assert.assertEquals(actual, expected, 0);

    }

}
