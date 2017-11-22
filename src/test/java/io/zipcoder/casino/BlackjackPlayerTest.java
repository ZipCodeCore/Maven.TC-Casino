package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class BlackjackPlayerTest {

    BlackjackPlayer blackjackPlayer = new BlackjackPlayer("Josh", 500.00);

    @Test
    public void getNameTest() {
        String expected = "Josh";

        String actual = blackjackPlayer.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkBalanceTest() {
        Double expected = 100.0;
        Double actual = blackjackPlayer.checkBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void wagerTest() {
        Double expected = 10.0;

        Double actual = blackjackPlayer.bet(10.0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkBalanceAfterWagerTest() {

        Double expected = 100.0;

        blackjackPlayer.bet(100.0);

        Double actual = blackjackPlayer.checkBalance();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardToHandAndViewHandTest() {

        Card card = new Card(Suit.DIAMOND, CardValue.Two);
        String expected = card.toString();

        blackjackPlayer.addCardToHand(card);

        String actual = blackjackPlayer.viewHand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandValueTest() {

        Card card = new Card(Suit.SPADE, CardValue.Ace);
        Card card2 = new Card(Suit.HEART, CardValue.Ten);
        blackjackPlayer.addCardToHand(card);

        int expected = 1;

        int actual = blackjackPlayer.getHandValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandValueTestAces() {


        Card card = new Card(Suit.SPADE, CardValue.Two);

        for (int i = 0; i < 5; i++)
            blackjackPlayer.addCardToHand(card);

        blackjackPlayer.addCardToHand(new Card(Suit.DIAMOND, CardValue.Ace));
        blackjackPlayer.addCardToHand(new Card(Suit.DIAMOND, CardValue.Ace));

        int expected = 15;

        int actual = blackjackPlayer.getHandValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getWinningsTest() {
        Double expected = 100.0;

        blackjackPlayer.addWinnings(600.0);
        Double actual = blackjackPlayer.checkBalance();

        Assert.assertEquals(expected, actual);
    }
}

