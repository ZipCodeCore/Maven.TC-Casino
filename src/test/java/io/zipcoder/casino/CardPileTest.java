package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.Card.Suit.*;
import static io.zipcoder.casino.Card.FaceValue.*;

public class CardPileTest {

    @Test
    public void addCardToPileTest() {
        CardPile cardPile = new CardPile();
        Card aceOfSpades = new Card(ACE, SPADES);

        cardPile.addCardToPile(aceOfSpades);
        Assert.assertEquals(aceOfSpades, cardPile.getCard(0));
    }

    @Test
    public void containsTest() {
        CardPile cardPile = new CardPile();
        Card aceOfSpades = new Card(ACE, SPADES);
        Card aceOfSpades2 = new Card(ACE, SPADES);

        cardPile.addCardToPile(aceOfSpades);
        Assert.assertTrue(cardPile.contains(aceOfSpades2));
    }

    @Test
    public void addCardsToPileTest() {
        CardPile cardPile = new CardPile();
        Card aceOfSpades = new Card(ACE, SPADES);
        Card twoOfHearts = new Card(TWO, HEARTS);
        Card sevenOfHearts = new Card(SEVEN, HEARTS);
        cardPile.addCardToPile(aceOfSpades);
        cardPile.addCardToPile(twoOfHearts);
        cardPile.addCardToPile(sevenOfHearts);

        CardPile myHand = new CardPile();
        myHand.addCardsToPile(cardPile);

        for(Card card : cardPile.getCards()) {
            Assert.assertTrue(myHand.contains(card));
        }
    }

    @Test
    public void removeTest() {
        CardPile cardPile = new CardPile();
        Card aceOfSpades = new Card(ACE, SPADES);
        Card twoOfHearts = new Card(TWO, HEARTS);
        Card sevenOfHearts = new Card(SEVEN, HEARTS);
        cardPile.addCardToPile(aceOfSpades);
        cardPile.addCardToPile(twoOfHearts);
        cardPile.addCardToPile(sevenOfHearts);

        cardPile.removeCard(aceOfSpades);

        Assert.assertFalse(cardPile.contains(aceOfSpades));
    }

    @Test
    public void containsAllTest() {
        CardPile cardPile = new CardPile();
        Card aceOfSpades = new Card(ACE, SPADES);
        Card twoOfHearts = new Card(TWO, HEARTS);
        Card sevenOfHearts = new Card(SEVEN, HEARTS);
        cardPile.addCardToPile(aceOfSpades);
        cardPile.addCardToPile(twoOfHearts);
        cardPile.addCardToPile(sevenOfHearts);

        CardPile myHand = new CardPile();
        myHand.addCardsToPile(cardPile);

        Assert.assertTrue(myHand.containsAll(cardPile));
    }

    @Test
    public void numCardsTest() {
        CardPile cardPile = new CardPile();
        Card aceOfSpades = new Card(ACE, SPADES);
        Card twoOfHearts = new Card(TWO, HEARTS);
        Card sevenOfHearts = new Card(SEVEN, HEARTS);
        cardPile.addCardToPile(aceOfSpades);
        cardPile.addCardToPile(twoOfHearts);
        cardPile.addCardToPile(sevenOfHearts);

        Assert.assertEquals(3, cardPile.numCards());
    }

    @Test
    public void shuffleTest() {
        CardPile cardPile = new CardPile();
        Card aceOfSpades = new Card(ACE, SPADES);
        Card twoOfHearts = new Card(TWO, HEARTS);
        Card sevenOfHearts = new Card(SEVEN, HEARTS);
        cardPile.addCardToPile(aceOfSpades);
        cardPile.addCardToPile(twoOfHearts);
        cardPile.addCardToPile(sevenOfHearts);

        CardPile myHand = new CardPile();
        myHand.addCardsToPile(cardPile);

        myHand.shuffle();

        Assert.assertTrue(myHand.containsAll(cardPile));
    }

    @Test
    public void toStringTest() {
        CardPile cardPile = new CardPile();
        Card aceOfSpades = new Card(ACE, SPADES);
        Card twoOfHearts = new Card(TWO, HEARTS);
        Card sevenOfHearts = new Card(SEVEN, HEARTS);
        cardPile.addCardToPile(aceOfSpades);
        cardPile.addCardToPile(twoOfHearts);
        cardPile.addCardToPile(sevenOfHearts);

        String expected = ACE.getIcon() + SPADES.getIcon() + ", " +
                            TWO.getIcon() + HEARTS.getIcon() + ", " +
                            SEVEN.getIcon() + HEARTS.getIcon();
        String actual = cardPile.toString();
        Assert.assertEquals(expected, actual);
    }
}
