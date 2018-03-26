package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void equals() throws Exception {
        Deck aDeck = new Deck();

        Card cardOne = new Card(Suit.DIAMONDS, 10, Card.suitSymbols[1], "10");
        Card cardTwo = new Card(Suit.CLUBS, 10, Card.suitSymbols[1], "10");

        Assert.assertTrue(cardOne.equals(cardTwo));

    }

}