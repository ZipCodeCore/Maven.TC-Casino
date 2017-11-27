package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;

public class CompPlayTest {

    GoFishPlayer p1;
    GoFishPlayer p2;
    GoFishPlayer p3;
    BlackJackGambler p4;
    Dealer dealer;

    @Before
    public void Setup() {


        p1 = new GoFishPlayer(new Player("joe", 100, false));
        p2 = new GoFishPlayer(new Player("james", 100, false));
        p3 = new GoFishPlayer(new Player("dave", 100, false));
        p4 = new BlackJackGambler(new Player("dave", 100, false),1000);

        dealer = new Dealer();

        ArrayList<GoFishPlayer> players = new ArrayList<>();
        Collections.addAll(players, p1, p2, p3);
        CompPlay.setUpPlayerCards(p1);
        CompPlay.setUpPlayerCards(p2);
        CompPlay.setUpPlayerCards(p3);
    }

    @Test
    public void basicHitOrStayTest() throws Exception {
        p4.addCardToHand(new Card(Card.Rank.THREE, Card.Suit.HEARTS));
        p4.addCardToHand(new Card(Card.Rank.FIVE, Card.Suit.DIAMONDS));

        String expected="Hit";
        String actual=CompPlay.hitOrStay(p4);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void basicHitOrStayTest2() throws Exception {
        p4.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.HEARTS));
        p4.addCardToHand(new Card(Card.Rank.NINE, Card.Suit.DIAMONDS));

        String expected="Stay";
        String actual=CompPlay.hitOrStay(p4);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void dealerHitOrStayTest() throws Exception {
        dealer.addCardToHand(new Card(Card.Rank.THREE, Card.Suit.HEARTS));
        dealer.addCardToHand(new Card(Card.Rank.SIX, Card.Suit.DIAMONDS));

        String expected="Hit";
        String actual=CompPlay.hitOrStay(dealer);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void dealerHitOrStayTest2() throws Exception {
        dealer.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.HEARTS));
        dealer.addCardToHand(new Card(Card.Rank.EIGHT, Card.Suit.DIAMONDS));

        String expected="Stay";
        String actual=CompPlay.hitOrStay(dealer);

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void makeBetTest() throws Exception {
         Integer expected=250;
         Integer actual =CompPlay.makeBet(p4);
         Assert.assertEquals(expected,actual);
    }


    @Test
    public void addRankToPlayer() throws Exception {

        String before = CompPlay.getPlayerCards();

        CompPlay.addRankToPlayer(p1, Card.Rank.THREE);
        CompPlay.addRankToPlayer(p1, Card.Rank.FIVE);
        CompPlay.addRankToPlayer(p2, Card.Rank.FIVE);
        CompPlay.addRankToPlayer(p3, Card.Rank.SIX);
        CompPlay.addRankToPlayer(p3, Card.Rank.SEVEN);

        String after = CompPlay.getPlayerCards();

        Assert.assertNotEquals(before, after);
    }

    @Test
    public void removeRankFromPlayer() throws Exception {


        CompPlay.addRankToPlayer(p1, Card.Rank.THREE);
        CompPlay.addRankToPlayer(p1, Card.Rank.FIVE);
        CompPlay.addRankToPlayer(p1, Card.Rank.TEN);

        String expected = "[THREE, FIVE]\n[]\n[]\n";

        CompPlay.removeRankFromPlayer(p1, Card.Rank.TEN);

        String actual = CompPlay.getPlayerCards();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void chooseRank() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.FIVE, Card.Suit.HEARTS));
        p1.addCardToHand(new Card(Card.Rank.THREE, Card.Suit.HEARTS));
        CompPlay.addRankToPlayer(p1, Card.Rank.THREE);
        CompPlay.addRankToPlayer(p1, Card.Rank.FIVE);
        CompPlay.addRankToPlayer(p2, Card.Rank.FIVE);
        CompPlay.addRankToPlayer(p3, Card.Rank.SIX);
        CompPlay.addRankToPlayer(p3, Card.Rank.SEVEN);


        Card.Rank expected = Card.Rank.FIVE;

        Card.Rank actual = CompPlay.chooseRank(p1);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void choosePlayer() throws Exception {
        CompPlay.addRankToPlayer(p1, Card.Rank.THREE);
        CompPlay.addRankToPlayer(p1, Card.Rank.FIVE);
        CompPlay.addRankToPlayer(p2, Card.Rank.FIVE);
        CompPlay.addRankToPlayer(p3, Card.Rank.SIX);
        CompPlay.addRankToPlayer(p3, Card.Rank.SEVEN);

        String expected = p2.getName();

        String actual = CompPlay.choosePlayer(p1, Card.Rank.FIVE).getName();

        Assert.assertEquals(expected, actual);
    }

}