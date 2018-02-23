package io.zipcoder.casino.GameToolsTests.Deck;

import io.zipcoder.casino.GameTools.Deck.BlackjackCard;
import io.zipcoder.casino.GameTools.Deck.BlackjackRank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackjackCardTest {

    BlackjackCard dummy;

    @Before
    public void setup(){
        dummy = new BlackjackCard(BlackjackRank.ACE, Suit.CLUBS);
    }

    @Test
    public void constructorTest(){
        int expected = 11;
        int actual = dummy.getBlackjackRankEnum().getRankValue();
        Assert.assertEquals(expected, actual);
    }

}
