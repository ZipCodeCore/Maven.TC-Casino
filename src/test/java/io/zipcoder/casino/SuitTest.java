package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class SuitTest {

    private Card card;

    @Test
    public void SuitToStringTest() {

        // Given
        String expectedSuitWord = "clubs";
        Card card = new Card(Rank.NINE, Suit.CLUBS);

        // When
        String actualSuitWord = card.getSuit().toString();

        // Then
        Assert.assertEquals(expectedSuitWord, actualSuitWord);
    }

    @Test
    public void SuitToSymbolTest() {

        // Given
        String expectedSuitSymbol = "\u2663";
        Card card = new Card(Rank.NINE, Suit.CLUBS);

        // When
        String actualSuitSymbol = card.getSuit().toSymbol();

        // Then
        Assert.assertEquals(expectedSuitSymbol, actualSuitSymbol);
    }
}