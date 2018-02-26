package io.zipcoder.casinotest.test.GameTest.cardGameTest.utilitiesTest;

import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.CardSuit;
import org.junit.Assert;
import org.junit.Test;

public class CardTest {

    Card testCard;

    @Test
    public void getSuitTest1() {
        testCard = new Card(CardSuit.CLUBS, CardRank.FOUR);
        CardSuit expected = CardSuit.CLUBS;
        CardSuit actual = testCard.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSuitTest2() {
        testCard = new Card(CardSuit.DIAMONDS, CardRank.JACK);
        CardSuit expected = CardSuit.DIAMONDS;
        CardSuit actual = testCard.getSuit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRankTest1() {
        testCard = new Card(CardSuit.HEARTS, CardRank.ACE);
        CardRank expected = CardRank.ACE;
        CardRank actual = testCard.getRank();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRankTest2() {
        testCard = new Card(CardSuit.SPADES, CardRank.NINE);
        CardRank expected = CardRank.NINE;
        CardRank actual = testCard.getRank();
        Assert.assertEquals(expected, actual);
    }


}
