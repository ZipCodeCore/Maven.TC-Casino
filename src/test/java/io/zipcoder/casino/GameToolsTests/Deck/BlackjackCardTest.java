package io.zipcoder.casino.GameToolsTests.Deck;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.GameTools.Util.BlackjackValueUtil;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackjackCardTest {

    Card dummy;

    @Before
    public void setup(){
        dummy = new Card(Rank.ACE, Suit.CLUBS);
    }

    @Test
    public void constructorTest(){
        int expected = 11;
        int actual = BlackjackValueUtil.rankParse(dummy.getRankEnum());
        Assert.assertEquals(expected, actual);
    }

}
