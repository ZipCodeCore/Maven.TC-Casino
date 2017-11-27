package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BlackjackPlayerTest {

    BlackjackPlayer blackjackPlayer = new BlackjackPlayer("Josh", 500.00);

    @Test
    public void checkBalanceTest() {
        Double expected = 500.0;
        Double actual = blackjackPlayer.checkBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void betTest() {
        Double expected = 10.0;

        Double actual = blackjackPlayer.bet(10.0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardToHandAndViewHandTest() {

        Card card = new Card(Suit.DIAMOND, CardValue.Two);
        int expected = card.getCardsValue();

        blackjackPlayer.addCardToHand(card);

        int actual = blackjackPlayer.viewHand(blackjackPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkBalanceAfterBetTest() {

        Double expected = 400.0;

        blackjackPlayer.bet(100.0);

        Double actual = blackjackPlayer.checkBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandValueTest() {


        Card card = new Card(Suit.HEART, CardValue.Ten);
        blackjackPlayer.addCardToHand(card);

        int expected = 10;

        int actual = blackjackPlayer.getHandValue();


        Assert.assertEquals(expected, actual);

    }

    @Test
    public void getWinningsTest() {
        Double expected = 1100.0;

        blackjackPlayer.addWinnings(600.0);
        Double actual = blackjackPlayer.checkBalance();

        Assert.assertEquals(expected, actual);
    }
}

