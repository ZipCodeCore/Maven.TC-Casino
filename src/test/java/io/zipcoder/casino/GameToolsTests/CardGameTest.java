package io.zipcoder.casino.GameToolsTests;

import io.zipcoder.casino.GameTools.Card;
import io.zipcoder.casino.GameTools.Rank;
import io.zipcoder.casino.GameTools.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class CardGameTest {

    DummyCardGame dummy;

    @Before
    public void setup(){
        dummy = new DummyCardGame();
    }

    @Test
    public void cardConstructorTest(){
        Card temp = new Card(Rank.SEVEN, Suit.CLUBS);
        Rank actual = temp.getRankEnum();
        Rank expected = Rank.SEVEN;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void deckGeneratorTest(){
        dummy.generateDeck();
        Card actual = dummy.deck.get(0);
        Card expected = new Card(Rank.ACE, Suit.HEARTS);
        Assert.assertEquals(expected.getRankEnum(), actual.getRankEnum());
    }

    @Test
    public void deckShuffleTest(){
        dummy.generateDeck();
        Card expected = dummy.deck.get(0);
        dummy.shuffleDeck();
        Card actual = dummy.deck.get(0);
        Assert.assertNotEquals(expected, actual);
    }

}
