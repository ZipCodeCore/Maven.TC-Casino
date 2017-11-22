package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    @Test
    public void Card() {

        Card card = new Card(Suit.CLUB, CardValue.Ace);
        int expected = 11;

        int actual = CardValue.getValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void CardSuit() {

        Card card = new Card(Suit.HEART, CardValue.Ace);
        Suit expected = Suit.HEART;

        Suit actual = Suit.getSuit();

        Assert.assertEquals(expected, actual);

    }
}
