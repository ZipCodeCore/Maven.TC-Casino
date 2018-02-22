package io.zipcoder.casino.GameToolsTests;

import io.zipcoder.casino.GameTools.Rank;
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
