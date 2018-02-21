package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class CardTest {

    private Card card;

    @Test
    public void CardConstructorRankPositiveTest() {

        // Given
        Rank expectedRank = Rank.DEUCE;
        Suit expectedSuit = Suit.CLUBS;
        Card card = new Card(Rank.DEUCE, Suit.CLUBS);

        // When
        Rank actualRank = card.getRank();
        Suit actualSuit = card.getSuit();

        // Then
        Assert.assertEquals(expectedRank, actualRank);
        Assert.assertEquals(expectedSuit, actualSuit);
    }

    @Test
    public void getRankPositiveTest() {

        // Given
        Rank expectedRank = Rank.SEVEN;
        Card card = new Card(Rank.SEVEN, Suit.SPADES);

        // When
        Rank actualRank = card.getRank();

        // Then
        Assert.assertEquals(expectedRank, actualRank);
    }

    @Test
    public void getSuitPositiveTest() {

        // Given
        Suit expectedSuit = Suit.DIAMONDS;
        Card card = new Card(Rank.EIGHT, Suit.DIAMONDS);

        // When
        Suit actualSuit = card.getSuit();

        // Then
        Assert.assertEquals(expectedSuit, actualSuit);

    }

    @Test
    public void toStringPositiveTest() {

        // Given
        String expectedString = "J of hearts";
        Card card = new Card(Rank.JACK, Suit.HEARTS);

        // When
        String actualString = card.toString();

        // Then
        Assert.assertEquals(expectedString, actualString);
    }

}