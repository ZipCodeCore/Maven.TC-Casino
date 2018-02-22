package io.zipcoder.casinotest.test.GameTest.cardGameTest.utilitiesTest;

import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.CardSuit;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DeckTest {

    Deck testDeck;

    @Before
    public void setup () {
        testDeck = new Deck();
    }

    @Test
    public void fillDeckTest() {
        int expected = 52;
        int actual = testDeck.countRemainingCards();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCardTest1() {
        Card card = testDeck.getCard();
        Assert.assertNotNull(card);
    }

    @Test
    public void getCardTest2() {
        testDeck.getCard();
        int expected = 51;
        int actual = testDeck.countRemainingCards();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countRemainingCardsTest1() {
        testDeck.getCard();
        testDeck.getCard();
        testDeck.getCard();
        int expected = 49;
        int actual = testDeck.countRemainingCards();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countRemainingCardsTest2() {
        Card card = testDeck.getCard();
        testDeck.addCard(card);
        int expected = 52;
        int actual = testDeck.countRemainingCards();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardTest1() {
        Card card = new Card(CardSuit.HEARTS, CardRank.NINE);
        testDeck.addCard(card);
        int expected = 53;
        int actual = testDeck.countRemainingCards();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addCardTest2() {
        Card card = new Card(CardSuit.DIAMONDS, CardRank.KING);
        testDeck.addCard(card);
        Card expected = card;
        Card actual = testDeck.peek();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void peekTest1() {
        Assert.assertNotNull(testDeck.peek());
    }

    @Test
    public void peekTest2() {

    }



}
