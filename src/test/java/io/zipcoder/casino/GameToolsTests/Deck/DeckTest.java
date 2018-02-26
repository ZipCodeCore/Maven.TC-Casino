package io.zipcoder.casino.GameToolsTests.Deck;
import io.zipcoder.casino.Factories.CardFactory;
import io.zipcoder.casino.GameTools.Deck.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DeckTest {

    CardFactory cardFactory;

    @Before
    public void setup() {
        cardFactory = new CardFactory();
    }

    @Test
    public void deckGeneratorTest() {
        Deck deck = new Deck();
        Card actual = deck.deck.get(0);
        Card expected = cardFactory.createCard(Rank.ACE, Suit.HEARTS);
        Assert.assertEquals(expected.getRankEnum(), actual.getRankEnum());
    }

    @Test
    public void deckShuffleTest() {
        Deck deck = new Deck();
        Card expected = deck.deck.get(0);
        deck.shuffleDeck();
        Card actual = deck.deck.get(0);
        Assert.assertNotEquals(expected, actual);
    }
}
