package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.*;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class BlackjackTest {

    Player sue = new Player("sue", 30, 1000);
    BlackjackPlayer sueBKJK;
    Blackjack game;

    @Before
    public void setup(){
        sueBKJK = new BlackjackPlayer(sue);
        game = new Blackjack(sue);
    }

    @Test
    public void constructorTest(){
        String actual = game.player.getName();
        String expected = sue.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealTest(){
        Card expected = game.deck.deck.get(0);
        game.deal();
        Card actual = game.player.getHand().get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void initialHandTest(){
        Card expected = game.deck.deck.get(1);
        game.initialHand();
        Card actual = game.player.getHand().get(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void initialHandDealerTest(){
        Card expected = game.deck.deck.get(2);
        game.initialHand();
        Card actual = game.bkjkDealer.getHand().get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void bustCheckPositiveTest(){
        ArrayList<Card> temp = new ArrayList<>();
        temp.add(new Card(Rank.KING, Suit.CLUBS));
        temp.add(new Card(Rank.KING, Suit.CLUBS));
        temp.add(new Card(Rank.KING, Suit.CLUBS));
        sueBKJK.setHand(temp);
        Assert.assertTrue(game.bustCheck(sueBKJK));
    }

    @Test
    public void bustCheckNegativeTest(){
        ArrayList<Card> temp = new ArrayList<>();
        temp.add(new Card(Rank.KING, Suit.CLUBS));
        temp.add(new Card(Rank.KING, Suit.CLUBS));
        sueBKJK.setHand(temp);
        Assert.assertFalse(game.bustCheck(sueBKJK));
    }

    @Test
    public void dealerHitCheck(){
        game.bkjkDealer.addToHand(new Card(Rank.THREE, Suit.CLUBS));
        game.bkjkDealer.addToHand(new Card(Rank.KING, Suit.CLUBS));
        boolean expected = game.dealerHitCheck();
        Assert.assertTrue(expected);
    }

    @Test
    public void dealerTurnTest(){
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(new Card(Rank.TEN, Suit.CLUBS));
        game.bkjkDealer.setHand(tempHand);
        game.dealerTurn();
        int actual = game.bkjkDealer.getHandValue();
        Assert.assertEquals(21, actual);
    }

    @Test
    public void winCheck21Test(){
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(new Card(Rank.ACE, Suit.CLUBS));
        tempHand.add(new Card(Rank.TEN, Suit.CLUBS));
        sueBKJK.setHand(tempHand);
        Assert.assertTrue(game.winCheck(sueBKJK));
    }

    @Test
    public void winCheckBustTest(){
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(new Card(Rank.TEN, Suit.CLUBS));
        tempHand.add(new Card(Rank.TEN, Suit.CLUBS));
        tempHand.add(new Card(Rank.TEN, Suit.CLUBS));
        sueBKJK.setHand(tempHand);
        Assert.assertFalse(game.winCheck(sueBKJK));
    }

    @Test
    public void winCheckDealerWinTest(){
        ArrayList<Card> tempHand = new ArrayList<>();
        tempHand.add(new Card(Rank.TEN, Suit.CLUBS));
        tempHand.add(new Card(Rank.TEN, Suit.CLUBS));
        sueBKJK.setHand(tempHand);
        ArrayList<Card> tempdealerhand = new ArrayList<>();
        tempdealerhand.add(new Card(Rank.TEN, Suit.CLUBS));
        tempdealerhand.add(new Card(Rank.NINE, Suit.CLUBS));
        tempdealerhand.add(new Card(Rank.TWO, Suit.CLUBS));
        game.bkjkDealer.setHand(tempdealerhand);
        Assert.assertFalse(game.winCheck(sueBKJK));
    }

    @Test
    public void payoutTest1(){
        int expected = 1010;
        game.setBetAmount(10);
        game.payoutWin();
        int actual = game.player.getRootPlayer().getBalance();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutTest2(){
        int expected = 990;
        game.setBetAmount(10);
        game.payoutLoss();
        int actual = game.player.getRootPlayer().getBalance();
        Assert.assertEquals(expected, actual);
    }

}
