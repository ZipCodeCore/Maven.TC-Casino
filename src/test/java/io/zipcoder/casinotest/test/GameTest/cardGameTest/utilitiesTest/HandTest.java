package io.zipcoder.casinotest.test.GameTest.cardGameTest.utilitiesTest;

import io.zipcoder.casino.Game.cardGame.utilities.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HandTest {

    Hand testHand;
    Deck testDeck;


    @Before
    public void setup() {
        testDeck = new Deck();
        testHand = new Hand();
    }

    @Test
    public void addCardTest1() {
        Card trueCard = new Card(CardSuit.HEARTS, CardRank.JACK);
        Card falseCard = new Card(CardSuit.CLUBS, CardRank.FOUR);
        testHand.addCard(trueCard);
        Assert.assertFalse(testHand.hasCard(falseCard));
    }

    @Test
    public void addCardTest2() {
        Card trueCard = new Card(CardSuit.HEARTS, CardRank.JACK);
        testHand.addCard(trueCard);
        Assert.assertTrue(testHand.hasCard(trueCard));
    }

    @Test
    public void removeCardTest1() {
        Card card1 = testDeck.getCard();
        testHand.addCard(card1);
        Card card2 = testDeck.getCard();
        testHand.addCard(card2);
        Card card3 = testDeck.getCard();
        testHand.addCard(card3);
        testHand.removeCard(card2);
        Assert.assertFalse(testHand.hasCard(card2));
    }

    @Test
    public void removeCardTest2() {
        Card card1 = testDeck.getCard();
        testHand.addCard(card1);
        Card card2 = testDeck.getCard();
        testHand.addCard(card2);
        testHand.removeCard(card2);
        Assert.assertTrue(testHand.hasCard(card1));
    }

    @Test
    public void clearTest1() {
        Card card1 = testDeck.getCard();
        testHand.addCard(card1);
        Card card2 = testDeck.getCard();
        testHand.addCard(card2);
        Card card3 = testDeck.getCard();
        testHand.addCard(card3);
        testHand.clear();
        int expected = 0;
        int actual = testHand.getCards().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void clearTest2() {
        Card card1 = testDeck.getCard();
        testHand.addCard(card1);
        Card card2 = testDeck.getCard();
        testHand.addCard(card2);
        testHand.clear();
        Card card3 = testDeck.getCard();
        testHand.addCard(card3);
        int expected = 1;
        int actual = testHand.getCards().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showCardTest1() {
        Card card1 = testDeck.getCard();
        Card card2 = testDeck.getCard();
        testHand.addCard(card1);
        testHand.addCard(card2);
        String expected = "Your Cards: " + card1.toString() + ", " + card2.toString() +", ";
        String actual = testHand.showHand();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void orderCardsTest1() {
        Card card1 = new Card(CardSuit.HEARTS, CardRank.FOUR);
        Card card2 = new Card(CardSuit.CLUBS, CardRank.JACK);
        Card card4 = new Card(CardSuit.DIAMONDS, CardRank.FOUR);
        Card card3 = new Card(CardSuit.DIAMONDS, CardRank.EIGHT);
        testHand.addCard(card1);
        testHand.addCard(card2);
        testHand.addCard(card3);
        testHand.addCard(card4);
        testHand.orderCards();
        Card expected = card4;
        Card actual = testHand.getCards().get(0);
        Assert.assertEquals(expected, actual);
    }


}
