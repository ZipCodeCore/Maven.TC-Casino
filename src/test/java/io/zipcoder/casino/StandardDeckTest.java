package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class StandardDeckTest {

    @Test
    public void fiftyTwoCardsInDeckTest() {
        StandardDeck deck = new StandardDeck();

        Assert.assertEquals(52, deck.numCards());
    }

    @Test
    public void allCardsDifferentTest() {
        StandardDeck deck = new StandardDeck();

        while(deck.numCards() > 0) {
            Card nextCard = deck.getCard(0);
            deck.removeCard(nextCard);
            Assert.assertFalse(deck.contains(nextCard));
        }
    }
}
