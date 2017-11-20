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
        String actual = tenOfDiamonds.getFaceValue().getIcon() + tenOfDiamonds.getSuit().getIcon();
        Assert.assertEquals(expected, actual);
    }
}
