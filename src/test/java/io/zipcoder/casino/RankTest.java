package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Before;

public class RankTest {

    private Card card;

    @Test
    public void RanktoIntTest() {

        // Given
        int expectedRankValue = 3;
        Card card = new Card(Rank.THREE, Suit.HEARTS);

        // When
        int actualRankValue = card.getRank().toInt();

        // Then
        Assert.assertEquals(expectedRankValue, actualRankValue);
    }

    @Test
    public void RanktoStringTest() {

        // Given
        String expectedRankSymbol = "3";
        Card card = new Card(Rank.THREE, Suit.HEARTS);

        // When
        String actualRankSymbol = card.getRank().toString();

        // Then
        Assert.assertEquals(expectedRankSymbol, actualRankSymbol);
    }



}
