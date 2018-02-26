package io.zipcoder.casino.GameToolsTests.Util;

import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Util.BlackjackValueUtil;
import org.junit.Assert;
import org.junit.Test;

public class BlackjackValueUtilTest {

    @Test
    public void parseAceTest(){
        int actual = BlackjackValueUtil.rankParse(Rank.ACE);
        int expected = 11;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void parseJackTest(){
        int actual = BlackjackValueUtil.rankParse(Rank.JACK);
        int expected = 10;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void parseSevenTest(){
        int actual = BlackjackValueUtil.rankParse(Rank.SEVEN);
        int expected = 7;
        Assert.assertEquals(actual, expected);
    }

}
