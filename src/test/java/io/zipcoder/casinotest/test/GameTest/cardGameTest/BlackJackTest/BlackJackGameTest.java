package io.zipcoder.casinotest.test.GameTest.cardGameTest.BlackJackTest;

import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackGame;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BlackJackGameTest {
    private Deck testDeck;
    private Hand testHand;
    private Profile testPlayerProfile;
    private BlackJackPlayer testPlayer;
    private BlackJackPlayer testDealer;
    private BlackJackGame testBlackJackGAme;

    @Before
    public void setUp() throws Exception {
        testDeck = new Deck();
        testHand = new Hand();

        testPlayerProfile = new Profile("name", 1000.0, 1);
        testBlackJackGAme = new BlackJackGame(testPlayerProfile);
        testPlayer = new BlackJackPlayer(testPlayerProfile);
        testDealer = new BlackJackPlayer(null);
        testDeck = testBlackJackGAme.getDeck();
    }

    @Test
    public void dealTest() {
        testBlackJackGAme.deal();
        int expected = 48;
        int actual = testBlackJackGAme.getDeck().countRemainingCards();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void hitTest() {
        // Card card1 = testDeck.getCard();
        //testPlayer.getHand().addCard(card1);
        //int score =   testPlayer.getScore();
        testBlackJackGAme.hit(testPlayer);
        int expected = 1;
        int actual = testPlayer.getHand().getCards().size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void currentScoreTest() {
        Card cardToScore = testDeck.getCard();
        Card card1 = testDeck.getCard();
        testPlayer.getHand().addCard(card1);

        testBlackJackGAme.hit(testPlayer);

        int expected = card1.getRank().getCardValue() + cardToScore.getRank().getCardValue();
        int actual = testBlackJackGAme.currentScore(cardToScore, testPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void standTest() {

    }

    @Test
    public void roundTest() {

    }

    @Test
    public void dealerBehavior() {

    }

    // need to get find way to fill expected String
    @Test
    public void showDealerTopCardTEst() {
        testBlackJackGAme.deal();


        String expected = ""; //testDealer.getHand().getCards().get(1).toString();
        String actual = testBlackJackGAme.ShowDealersFaceCard();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showListOfPlayerActionsTest() {
        String expected = "Choose Action: [Bet], [Hit], [Stand], [Spilt]";
        String actual = testBlackJackGAme.showListOfPlayerActions();

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void startGame() {

    }

    @Test
    public void endGame() {

    }

    @Test
    public void getRulesTest() {

    }


}
