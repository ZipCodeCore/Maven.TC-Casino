package io.zipcoder.casino.GameToolsTests.Deck;


import io.zipcoder.casino.GameTools.Deck.Suit;
import org.junit.Assert;
import org.junit.Test;

public class SuitTest {
    @Test
    public void getSuitValueTest(){
        String expected = "Clubs";
        String actual = Suit.CLUBS.getSuitValue();
        Assert.assertEquals(expected, actual);
    }

}
