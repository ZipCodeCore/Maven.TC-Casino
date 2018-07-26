package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void getCardsValueTest() {

        Card card = new Card(Suit.CLUB, CardValue.Ace);
        int expected = 11;

        int actual = card.getCardsValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuitSymbolTest() {

        Card card = new Card(Suit.HEART, CardValue.Ace);
        String expected = "♡";

        String actual = card.getSuitSymbols();

        Assert.assertEquals(expected, actual);

    }
}
