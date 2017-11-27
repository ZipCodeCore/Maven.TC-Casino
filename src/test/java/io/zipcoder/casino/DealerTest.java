package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DealerTest {
    Dealer dealer;
    Deck deck;

    @Before
    public void setup() {
        deck = new Deck(1);
        dealer = new Dealer();
    }

    @Test
    public void showOneCardTest() throws Exception {
        Card first = new Card(Card.Rank.JACK, Card.Suit.SPADES);
        dealer.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        dealer.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        String expected = "Dealer: " + first.toString();
        String actual = dealer.showOneCard();
        Assert.assertNotEquals(expected, actual);

    }

    @Test
    public void resetHandTest() throws Exception {

        dealer.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        dealer.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        int before = dealer.getHand().size();
        dealer.resetHand();
        int after = dealer.getHand().size();

        Assert.assertNotEquals(before, after);
    }

}