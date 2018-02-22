package io.zipcoder.casino.GameToolsTests.Deck;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import org.junit.Assert;
import org.junit.Test;

public class DeckTest {

    Deck dummy = new Deck();

    @Test
    public void cardConstructorTest(){
        Card temp = new Card(Rank.SEVEN, Suit.CLUBS);
        Rank actual = temp.getRankEnum();
        Rank expected = Rank.SEVEN;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deckGeneratorTest(){
        Card actual = dummy.deck.get(0);
        Card expected = new Card(Rank.ACE, Suit.HEARTS);
        Assert.assertEquals(expected.getRankEnum(), actual.getRankEnum());
    }

    @Test
    public void deckShuffleTest(){
        Card expected = dummy.deck.get(0);
        dummy.shuffleDeck();
        Card actual = dummy.deck.get(0);
        Assert.assertNotEquals(expected, actual);
    }



}
