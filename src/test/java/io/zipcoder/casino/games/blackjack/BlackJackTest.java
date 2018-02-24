package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.games.Rank;
import io.zipcoder.casino.games.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;

public class BlackJackTest {

    Deck playingDeck = new Deck();
    private BlackJack blackJackTest;
    private int playerBet;
    static long playerWallet;
    private ArrayList<Card> playerValue;
    private ArrayList<Card> dealerValue;
    private ArrayList<Card> splitHandLeft;
    private ArrayList<Card> splitHandRight;
    private int splitHandScoreLeft;
    private int splitHandScoreRight;
    private int playerHandScore;
    private int dealerHandScore;
    private int insuranceBet;

    @Before
    public void setUp() {
        blackJackTest = new BlackJack();
        Deck playingDeck = new Deck();
        blackJackTest.beginBeforeGame();
        playerValue = new ArrayList<>();
        dealerValue = new ArrayList<>();
        splitHandLeft = new ArrayList<>();
        splitHandRight = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            playerValue.add(playingDeck.pull(1)[0]);
            dealerValue.add(playingDeck.pull(1)[0]);
        }
    }

    @Test
    public void testGetPlayerCardValue(){
    Integer actual = blackJackTest.getPlayerCardValue();
    assertTrue(0 <= actual && actual <= 21);
    }

    @Test
    public void testGetDealerCardValue(){
    Integer actual = blackJackTest.getDealerCardValue();
    assertTrue(0 <= actual && actual <= 21);
    }
    @Test
    public void testDealTwoCards(){
    Integer expected = 2;
    Integer actual = playerValue.size();
    Assert.assertEquals(expected, actual);
    }
    @Test
    public void testDisplayPlayerHand(){
    String search = "of";
    boolean actual = blackJackTest.displayPlayerHand().contains(search);
    boolean expected = true;
    Assert.assertEquals(expected,actual);
    }
    @Test
    public void testDisplayDealerHand(){
    String search = "of";
    boolean actual = blackJackTest.displayDealerHand().contains(search);
    boolean expected = true;
    Assert.assertEquals(expected, actual);
    }
    @Test
    public void testIsHandSplittableFalse(){
    Card card1 = new Card(Rank.FOUR, Suit.HEARTS);
    Card card2 = new Card(Rank.NINE, Suit.HEARTS);
    Integer expected = -1;
    Integer actual = blackJackTest.comparable(card1, card2);
    Assert.assertEquals(expected, actual);
    }
    @Test
    public void testIsHandSplittableTrue(){
    Card card1 = new Card(Rank.FOUR, Suit.HEARTS);
    Card card2 = new Card(Rank.FOUR, Suit.SPADES);
    Integer expected = 0;
    Integer actual = blackJackTest.comparable(card1, card2);
    Assert.assertEquals(expected, actual);
    }
}
