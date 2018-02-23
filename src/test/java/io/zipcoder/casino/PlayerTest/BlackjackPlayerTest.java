package io.zipcoder.casino.PlayerTest;

import io.zipcoder.casino.GameTools.Deck.*;
import io.zipcoder.casino.Games.Blackjack;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BlackjackPlayerTest {
    Player sue;
    BlackjackPlayer suebkjk;

    @Before
    public void setup(){
        sue = new Player("sue", 30, 500);
        suebkjk = new BlackjackPlayer(sue);
    }

    @Test
    public void constructorTest(){
        String expected = "sue";
        String actual = suebkjk.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCanHitTest(){
        boolean expected = true;
        boolean actual = suebkjk.isCanHit();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest(){
        BlackjackCard ace = new BlackjackCard(BlackjackRank.ACE, Suit.CLUBS);
        ArrayList<BlackjackCard> expected = new ArrayList<BlackjackCard>();
        expected.add(ace);
        suebkjk.setHand(expected);
        ArrayList<BlackjackCard> actual = suebkjk.getHand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRootPlayerTest(){
        Player expected = sue;
        Player actual = suebkjk.getRootPlayer();
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
        suebkjk.setHand(tempHand);
        Integer actual = suebkjk.getHandValue();
        Assert.assertEquals(expected, actual);
    }

}
