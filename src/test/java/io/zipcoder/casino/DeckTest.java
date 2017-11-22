package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    Deck deck = new Deck();


    @Test
    void getCardsTest() {

        deck.populate();
        Card expected = new Card(Suit.CLUB, CardValue.Ace);

        Card actual = deck.getCardByIndex(0);

        Assert.assertEquals(expected, actual);
    }

    @Test
    void getDeckSizeTest() {

        deck.populate();
        Integer expected = 52;

        Integer actual = deck.getDeckSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    void giveCardTest() {

        deck.populate();
        Card expected = deck.getCardByIndex(0);

        Card actual = deck.dealOneRandomCard();

        Assert.assertEquals(expected, actual);


    }

    @Test
    void getCardTest() {

        deck.populate();
        Suit expected_suit = Suit.CLUB;
        Integer expected_rank = CardValue.Ace.getValue();

        String actual = deck.getCardByIndex(0).getSuitSymbols();
        Integer actual2 = deck.getCardByIndex(0).getCardsValue();


        Assert.assertEquals(expected_suit, actual);
        Assert.assertEquals(expected_rank, actual2);

    }

    @Test
    void populateTest() {

        deck.populate();
        Suit expected_suit = Suit.SPADE;
        Integer expected_rank = CardValue.King.getValue();
        Integer expected_size = 52;

        String actual = deck.getCardByIndex(51).getSuitSymbols();
        Integer actual2 = deck.getCardByIndex(51).getCardsValue();
        Integer actual3 = deck.getDeckSize();

        Assert.assertEquals(expected_suit, actual);
        Assert.assertEquals(expected_rank, actual2);
        Assert.assertEquals(expected_size, actual3);
    }

}
