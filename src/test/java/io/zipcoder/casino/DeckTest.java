package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    Deck deck = new Deck();

    @Test
    public void populateTest() {

        deck.populate();
        String expected = "♤";
        Integer expected2 = CardValue.King.getValue();
        Integer expected3 = 52;

        String actual = deck.getCardByIndex(51).getSuitSymbols();
        Integer actual2 = deck.getCardByIndex(51).getCardsValue();
        Integer actual3 = deck.getDeckSize();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);
        Assert.assertEquals(expected3, actual3);
    }

    @Test
    public void dealOneRandomCardTest() {

        deck.populate();
        Card expected = deck.getCardByIndex(0);

        Card actual = deck.dealOneRandomCard();

        Assert.assertEquals(expected, actual);


    }

    @Test
    public void getDeckSizeTest() {

        deck.populate();
        Integer expected = 52;

        Integer actual = deck.getDeckSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardTest() {

        deck.populate();
        String expected = "♧";
        Integer expected2 = CardValue.Ace.getValue();

        String actual = deck.getCardByIndex(0).getSuitSymbols();
        Integer actual2 = deck.getCardByIndex(0).getCardsValue();


        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected2, actual2);

    }
}
