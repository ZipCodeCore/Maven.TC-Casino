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
        Card ace = new Card(Rank.ACE, Suit.CLUBS);
        ArrayList<Card> expected = new ArrayList<>();
        expected.add(ace);
        suebkjk.setHand(expected);
        ArrayList<Card> actual = suebkjk.getHand();
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
        Card two = new Card(Rank.TWO, Suit.HEARTS);
        Card three = new Card(Rank.THREE, Suit.CLUBS);
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(three);
        tempHand.add(two);
        suebkjk.setHand(tempHand);
        Integer actual = suebkjk.getHandValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setCanHitNegativeTest(){
        suebkjk.setCanHit(false);
        Assert.assertFalse(suebkjk.isCanHit());
    }

    @Test
    public void setCanHitPositiveTest(){
        suebkjk.setCanHit(false);
        suebkjk.setCanHit(true);
        Assert.assertTrue(suebkjk.isCanHit());
    }

    @Test
    public void getHandValueAceTest(){
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(new Card(Rank.ACE, Suit.CLUBS));
        tempHand.add(new Card(Rank.KING, Suit.CLUBS));
        tempHand.add(new Card(Rank.THREE, Suit.CLUBS));
        suebkjk.setHand(tempHand);
        int expected = 14;
        int actual = suebkjk.getHandValue();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutWinTest(){
        suebkjk.payoutWin(500);
        int expected = 1000;
        int actual = suebkjk.getRootPlayer().getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutLossTest(){
        suebkjk.payoutLoss(500);
        int expected = 0;
        int actual = suebkjk.getRootPlayer().getBalance();
        Assert.assertEquals(expected, actual);
    }

}
