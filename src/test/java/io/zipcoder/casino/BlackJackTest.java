package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

public class BlackJackTest {

    BlackJackGambler p1;
    BlackJackGambler p2;
    BlackJackGambler p3;
    BlackJack blackJack;
    Dealer dealer;
    ArrayList<BlackJackGambler> players;

    @Before
    public void setup() {
        blackJack = new BlackJack();
        players = new ArrayList<BlackJackGambler>();

        p1 = new BlackJackGambler(new Player("Samwise", 10000, false),1000 );
        p2 = new BlackJackGambler(new Player("Frodo", 10000, false),1000 );
        p3 = new BlackJackGambler(new Player("Smeagol", 10, false),1000 );
        dealer= new Dealer();
        blackJack.addPlayer(p1);
        blackJack.addPlayer(p2);
        blackJack.addPlayer(p3);

        blackJack.gameSetUp(p2);
    }

    @Test
    public void isBustTest() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMONDS));

        System.out.println(p1.getHandTotal());
        boolean expected = false;
//        boolean actual = blackJack.isBust(p1);

//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isBustTest2() throws Exception {
//        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADE));
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.KING, Card.Suit.SPADES));

        System.out.println(p1.getHandTotal());
        boolean expected = true;
//        boolean actual = blackJack.isBust(p1);

//        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resetHandsTest() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        p2.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        p2.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        p3.addCardToHand(new Card(Card.Rank.KING, Card.Suit.SPADES));
        p3.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));

        HashMap<Player, Integer> expected = new HashMap<Player, Integer>();
        HashMap<Player, Integer> actual = new HashMap<Player, Integer>();

        for (Player p : players) {
            expected.put(p, 0);
        }


//        blackJack.resetHands();

        for (BlackJackGambler p : players) {
            actual.put(p, p.getHand().size());
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutWinningsTest1() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        blackJack.gameSetUp(p1);
//        blackJack.playerBet(p1, 250);

        Integer expected = p1.getChipCount()+500;
//        blackJack.payoutWinnings(p1,2);
        Integer actual = p1.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutWinningsTest2() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.TEN, Card.Suit.DIAMONDS));
        blackJack.gameSetUp(p1);
//        blackJack.playerBet(p1, 250);

        Integer expected = p1.getChipCount();
//        blackJack.payoutWinnings(p1,0);
        Integer actual = p1.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void payoutWinningsTest3() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.QUEEN, Card.Suit.DIAMONDS));
        blackJack.gameSetUp(p1);
//        blackJack.playerBet(p1, 250);

        Integer expected = p1.getChipCount()+625;
//        blackJack.payoutWinnings(p1,2);
        Integer actual = p1.getChipCount();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void playerBetTest() throws Exception {

        int bet = 5;

//        blackJack.playerBet(p3, bet);

        int expected = p3.getChipCount() + bet;

//        blackJack.payoutWinnings(p3, 1);

        int actual = p3.getChipCount();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void takeBetTest() throws Exception {
        Integer expected = 250;
        Integer chipsBefore = p1.getChipCount()-250;

        Integer actual = blackJack.takeBet(p1);
        Integer chipsAfter = p1.getChipCount();

        Assert.assertEquals(expected, actual);
        Assert.assertEquals(chipsBefore, chipsAfter);
    }

    @Test
    public void checkForBlackJackTest() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.ACE, Card.Suit.SPADES));
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));

        boolean expected=true;
//        boolean actual =blackJack.checkForBlackJack(p1);

//        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkForBlackJackTest2() throws Exception {
        p1.addCardToHand(new Card(Card.Rank.SEVEN, Card.Suit.SPADES));
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        p1.addCardToHand(new Card(Card.Rank.FOUR, Card.Suit.DIAMONDS));

        boolean expected=false;
//        boolean actual =blackJack.checkForBlackJack(p1);
//
//        Assert.assertEquals(expected,actual);
    }

    @Test
    public void addAIPlayers() throws Exception {
        int  expected=blackJack.getPlayers().size()+3;
        blackJack.addAIPlayers(3);
        int actual = blackJack.getPlayers().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeZeroChipPlayers() throws Exception {
        BlackJackGambler p4 = new BlackJackGambler(new Player("Frodo", 10000, false),0 );
        BlackJackGambler p5 = new BlackJackGambler(new Player("Smeagol", 10, false),0 );

        blackJack.addPlayer(p4);
        blackJack.addPlayer(p5);

        int expected=blackJack.getPlayers().size()-2;
//        blackJack.removeZeroChipPlayers();
        int actual=blackJack.getPlayers().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void  payoutMultiplierTest(){
        p1.addCardToHand(new Card(Card.Rank.JACK, Card.Suit.DIAMONDS));
        Integer expected=2;
//        Integer actual=blackJack.payoutMultiplier(p1);
//        Assert.assertEquals(expected,actual);
    }

    @Test
    public void payoutMultiplierTest2(){
        Integer expected=1;
//        Integer actual=blackJack.payoutMultiplier(dealer);
//        Assert.assertEquals(expected,actual);
    }
}