package io.zipcoder.casino.GameToolsTests.Deck;


import io.zipcoder.casino.Factories.CardFactory;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CardTest {

    CardFactory cardFactory = new CardFactory();
    Card tester;

    @Before
    public void setup(){
        tester = CardFactory.createCard(Rank.SEVEN, Suit.CLUBS);
    }

    @Test
    public void cardConstructorTest(){
        Card temp = CardFactory.createCard(Rank.SEVEN, Suit.CLUBS);
        Rank actual = temp.getRankEnum();
        Rank expected = Rank.SEVEN;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getSuitTest(){
        Suit expected = tester.getSuitEnum();
        Suit actual = Suit.CLUBS;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRankTest(){
        Rank expected = tester.getRankEnum();
        Rank actual = Rank.SEVEN;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setSuitTest(){
        tester.setSuitEnum(Suit.DIAMOND);
        Suit expected = Suit.DIAMOND;
        Suit actual = tester.getSuitEnum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setRankTest(){
        tester.setRankEnum(Rank.ACE);
        Rank expected = Rank.ACE;
        Rank actual = tester.getRankEnum();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toCardArtTest() {
        tester.setAsciiEnum(Rank.EIGHT);
        String expected = "  _________\n" +
                " |8 +   +  |\n" +
                " |+        |\n" +
                " |  +   +  |\n" +
                " |         |\n" +
                " |  +   +  |\n" +
                " |        +|\n" +
                " |  +   + 8|\n" +
                "  ~~~~~~~~~";
        String actual = Rank.EIGHT.getAsciiValue();
        Assert.assertEquals(expected, actual);
    }
}
