package io.zipcoder.casino.Games.Dealer;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class DealerTest {

    Dealer dealer;

    @Before
    public void setup(){
        dealer = new Dealer();
    }

    @Test
    public void getHandTest(){
        Card ace = new Card(Rank.ACE, Suit.CLUBS);
        ArrayList<Card> expected = new ArrayList<>();
        expected.add(ace);
        dealer.setHand(expected);
        ArrayList<Card> actual = dealer.getHand();
        Assert.assertEquals(expected, actual);
}

    @Test
    public void getHandValueTest() {
        Integer expected = 5;
        Card two = new Card(Rank.TWO, Suit.HEARTS);
        Card three = new Card(Rank.THREE, Suit.CLUBS);
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(three);
        tempHand.add(two);
        dealer.setHand(tempHand);
        Integer actual = dealer.getHandValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void canHitPositiveTest(){
        Card two = new Card(Rank.TWO, Suit.HEARTS);
        Card three = new Card(Rank.THREE, Suit.CLUBS);
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(three);
        tempHand.add(two);
        dealer.setHand(tempHand);
        boolean actual = dealer.canHit();
        Assert.assertTrue(actual);
    }

    @Test
    public void canHitNegativeTest(){
        Card first = new Card(Rank.KING, Suit.HEARTS);
        Card second = new Card(Rank.KING, Suit.CLUBS);
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(first);
        tempHand.add(second);
        dealer.setHand(tempHand);
        boolean actual = dealer.canHit();
        Assert.assertFalse(actual);
    }

}
