package io.zipcoder.casino.GameToolsTests.Deck;


import io.zipcoder.casino.GameTools.Deck.Rank;
import org.junit.Assert;
import org.junit.Test;

public class RankTest {

    @Test
    public void getRankValueTest(){
        int actual = Rank.SIX.getRankValue();
        int expected = 6;
        Assert.assertEquals(expected, actual);
    }

}
