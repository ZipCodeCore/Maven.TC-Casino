package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardTest {

    Card cardTest;

    @Before
    public void setUO() {
        cardTest = new Card(Suit.HEARTS, 4);
    }

    @Test
    public void getSuit() throws Exception {
        Suit expected = Suit.HEARTS;
        Suit actual = cardTest.getSuit();
        Assert.assertSame(expected, actual);
    }

    @Test
    public void getValue() throws Exception {
        Integer expected = 4;
        Integer actual = cardTest.getValue();
        Assert.assertEquals(expected, actual);
    }

}