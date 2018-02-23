package io.zipcoder.casino.GameToolsTests.Deck;

import io.zipcoder.casino.GameTools.Deck.BlackjackRank;
import io.zipcoder.casino.Games.Blackjack;
import org.junit.Assert;
import org.junit.Test;

public class BlackjackRankTest {
    @Test
    public void getRankValueTest(){
        int expected = 8;
        int actual = BlackjackRank.EIGHT.getRankValue();
        Assert.assertEquals(expected, actual);
    }
}
