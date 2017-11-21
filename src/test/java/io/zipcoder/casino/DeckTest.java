package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class DeckTest {

    Deck deckTest;
    @Before
    public void setUp() {
        deckTest = new Deck();
    }

    @Test
    public void getAllCards() throws Exception {
        ArrayList<Card> cards = deckTest.getAllCards();
        Assert.assertNotNull(cards);
    }

    @Test
    public void getCard() throws Exception {
        Assert.assertTrue(this.deckTest.getCard() != null);
    }

    @Test
    public void shuffle() throws Exception {
        Card[] cardArray1 = new Card[52];
        Card[] cardArray2 = new Card[52];
        Card[] initialArray = this.deckTest.getAllCards().toArray(cardArray1);
        this.deckTest.shuffle();
        Card[] shuffledArray = this.deckTest.getAllCards().toArray(cardArray2);
        Assert.assertFalse(Arrays.equals(initialArray, shuffledArray));
    }

    @Test
    public void isDeckEmpty() throws Exception {
        Assert.assertFalse(deckTest.isDeckEmpty());
        deckTest.getAllCards().clear();
        Assert.assertTrue(deckTest.isDeckEmpty());
    }
}