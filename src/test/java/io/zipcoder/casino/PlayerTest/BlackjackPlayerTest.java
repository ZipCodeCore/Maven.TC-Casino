package io.zipcoder.casino.PlayerTest;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
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
        ArrayList<Card> expected = new ArrayList<Card>();
        expected.add(ace);
        suebkjk.setHand(expected);
        ArrayList<Card> actual = suebkjk.getHand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getRootPlayerTest(){
        Player expected = sue;
        Player acual = suebkjk.getRootPlayer();
        Assert.assertEquals(expected, acual);
    }

    @Test
    public void getHandValueTest() {
        Integer expected = 5;
        Card two = new Card(Rank.TWO, Suit.HEARTS);
        Card three = new Card(Rank.THREE, Suit.CLUBS);
        ArrayList<Card> tempHand = new ArrayList();
        tempHand.add(three);
        tempHand.add(two);
        suebkjk.setHand(tempHand);
        Integer actual = suebkjk.getHandValue();
        Assert.assertEquals(expected, actual);
    }

}
