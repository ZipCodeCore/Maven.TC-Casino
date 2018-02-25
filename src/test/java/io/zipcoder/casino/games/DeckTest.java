package io.zipcoder.casino.games;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/21/18
 */
public class DeckTest {
    private Deck deck;

    @Before
    public void setup() {
        deck = new Deck();
    }

    @Test
    public void testPullFewerThanRemaining() {
        int expected = 9;
        int actual = deck.pullMany(expected).length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPullMoreThanRemaining() {
        int expected = 52;
        int desiredDraws = 53;
        int actual = deck.pullMany(desiredDraws).length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testPullFromFreshDeck() {
        int removeCards = 50;
        deck.pullMany(removeCards);
        int expected = 7;
        int actual = deck.pullFromFreshDeck(expected).length;

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testGetCardsLeft() {
        int removeCards = 50;
        deck.pullMany(removeCards);
        int expected = 2;
        int actual = deck.getCardsLeft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        int removeCards = 52;
        deck.pullMany(removeCards);

        Assert.assertTrue(deck.isEmpty());
    }

    @Test
    public void testShuffle() {
        int removeCards = 52;
        int expected = 52;

        deck.pullMany(removeCards);
        Assert.assertTrue(deck.isEmpty());

        deck.shuffle();
        int actual = deck.getCardsLeft();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRemoveFromDeck() {
        Card card = deck.pull();
        Assert.assertFalse(deck.searchForCard(card));
    }
}
