package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
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
        String actual = game.playerList.get(0).getName();
        String expected = sue.getName();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealTest(){
        Card expected = game.deck.deck.get(0);
        game.deal(sueBKJK);
        Card actual = sueBKJK.getHand().get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void initialHandTest(){
        Card expected = game.deck.deck.get(1);
        game.initialHand(sueBKJK);
        Card actual = sueBKJK.getHand().get(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void initialHandWithMultiplePlayersTest(){
        Player jim = new Player("jim", 38, 300);
        BlackjackPlayer jimBKJK = new BlackjackPlayer(jim);
        Card expected = game.deck.deck.get(3);
        game.initialHand(sueBKJK, jimBKJK);
        Card actual = jimBKJK.getHand().get(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void startTest() {

    }

    @Test
    public void getValueTest() {

    }

    @Test
    public void setAceTest() {

    }

    @Test
    public void startRoundTest() {

    }

    @Test
    public void generateDeckTest() {

    }

    @Test
    public void shuffleDeckTest() {

    }

    @Test
    public void buildPlayerHandTest() {

    }

    @Test
    public void startTurnTest() {

    }

    @Test
    public void hitOrStandTest() {

    }

    @Test
    public void dealerTakesTurnTest() {

    }

    @Test
    public void compareValueTest() {

    }

    @Test
    public void payoutTest() {

    }

}
