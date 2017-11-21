package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.Card.Suit.*;
import static io.zipcoder.casino.Card.FaceValue.*;

public class CardTest {

    @Test
    public void testConstructor() {
        Card kingOfSpades = new Card(KING, SPADES);
        String expected = "KING of SPADES";
        String actual = kingOfSpades.getFaceValue() + " of " + kingOfSpades.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIcons() {
        Card tenOfDiamonds = new Card(TEN, DIAMONDS);
        String expected = "10\u2666";
        String actual = tenOfDiamonds.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void matchesTest() {
        Card tenOfDiamonds = new Card(TEN, DIAMONDS);
        Card tenOfDiamonds2 = new Card(TEN, DIAMONDS);
        Card tenOfHearts = new Card(TEN, HEARTS);

        Assert.assertTrue(tenOfDiamonds.matches(tenOfDiamonds2));
        Assert.assertFalse(tenOfDiamonds.matches(tenOfHearts));
    }
}
