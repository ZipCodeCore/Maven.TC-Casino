package io.zipcoder.casino.Games.Dealer;

import io.zipcoder.casino.GameTools.Deck.BlackjackCard;
import io.zipcoder.casino.GameTools.Deck.BlackjackRank;
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
        BlackjackCard ace = new BlackjackCard(BlackjackRank.ACE, Suit.CLUBS);
        ArrayList<BlackjackCard> expected = new ArrayList<BlackjackCard>();
        expected.add(ace);
        dealer.setHand(expected);
        ArrayList<BlackjackCard> actual = dealer.getHand();
        Assert.assertEquals(expected, actual);
}

    @Test
    public void getHandValueTest() {
        Integer expected = 5;
        BlackjackCard two = new BlackjackCard(BlackjackRank.TWO, Suit.HEARTS);
        BlackjackCard three = new BlackjackCard(BlackjackRank.THREE, Suit.CLUBS);
        ArrayList<BlackjackCard> tempHand = new ArrayList<BlackjackCard>();
        tempHand.add(three);
        tempHand.add(two);
        dealer.setHand(tempHand);
        Integer actual = dealer.getHandValue();
        Assert.assertEquals(expected, actual);
    }
}
