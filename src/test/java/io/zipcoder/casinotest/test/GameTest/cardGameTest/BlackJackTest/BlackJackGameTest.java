package io.zipcoder.casinotest.test.GameTest.cardGameTest.BlackJackTest;

import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackBet;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackGame;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
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
        testBlackJackGAme.deal(testPlayer);
        int expected = 46;
        int actual = testBlackJackGAme.getDeck().countRemainingCards();
        Assert.assertEquals(expected, actual);
    }

    //How can I write this test to not have if else statements?
    //create a cleaner method retrieve cardValues;
    @Test
    public void countAcesInHandTest(){
        Card card1 = testDeck.getCard();
        Card card2 = testDeck.getCard();
        testPlayer.getHand().addCard(card1);
        testPlayer.getHand().addCard(card2);
        int expected = 0;
        if(card1.getRank() == CardRank.ACE){
            expected++;
        }
        else if(card2.getRank() == CardRank.ACE){
            expected++;
        }
      int actual = testBlackJackGAme.countAcesInHand(testPlayer);

      Assert.assertEquals(expected, actual);
    }

    @Test
    public void turnChoice1Test() {
        testPlayer.bet(BlackJackBet.INTIAL_BET, 500);
        double expectecd = 500;
        double actual = testPlayer.getProfile().getAccountBalance();

        Assert.assertEquals(expectecd, actual, .001);
    }


    @Test
    public void hitTest() {
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

        //updates score of first card addeded
        testBlackJackGAme.updateScore(card1, testPlayer);
        // adds another card to hand
        testPlayer.getHand().addCard(cardToScore);


        int expected = card1.getRank().getCardValue() + cardToScore.getRank().getCardValue();
        // updates score to reflect second card added
        int actual = Integer.valueOf(testBlackJackGAme.updateScore(cardToScore, testPlayer));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void standTest() {
        //isStood changes to true;
        //currentPlayer changes to dealer
        boolean expected = true;
        boolean actual = testBlackJackGAme.stand(testPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void splitTest() {
        // if both cards delt are same then player can choose to split
        //
    }

    @Test
    public void bustedTest() {
        testBlackJackGAme.dealACard(testPlayer);
        testBlackJackGAme.dealACard(testPlayer);
        testBlackJackGAme.dealACard(testPlayer);
        boolean expected;
        if (testPlayer.getScore() > 21) {
            expected = true;
        } else {
            expected = false;
        }
        boolean actual = testBlackJackGAme.isBusted(testPlayer);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealACardTest() {
        int actual = testBlackJackGAme.dealACard(testPlayer);
        int expected = testPlayer.getScore();
        Assert.assertEquals(expected, actual);
    }

/*
    @Test
    public void roundTest() {

    }*/
/*
    @Test
    public void dealerBehaviorTest() {
        // if dealer score  is less than 17 a dealer must be dealt a card
        Card cardToScore = testDeck.getCard();
        Card card1 = testDeck.getCard();
        testDealer.getHand().addCard(card1);
        //updates score of first card addeded
        testBlackJackGAme.updateScore(card1, testDealer);
        testBlackJackGAme.updateScore(cardToScore, testDealer);

        boolean expected = true;
        //boolean actual = testBlackJackGAme.dealerBehavior();

        //Assert.assertEquals(expected, actual);
    }*/



    // need to get find way to fill expected String
    /*@Test
    public void showDealerTopCardTEst() {
        testBlackJackGAme.deal(testPlayer);


        String expected = "";
        String actual = testBlackJackGAme.showDealersFaceCard();

        Assert.assertEquals(expected, actual);
    }*/

    @Test
    public void showListOfPlayerActionsTest() {
        String expected = "Choose Action: [Bet], [Hit], [Stand]";
        String actual = testBlackJackGAme.showListOfPlayerActions();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void isBlackJackIntialHandTest(){
        testBlackJackGAme.dealACard(testPlayer);
        testBlackJackGAme.dealACard(testPlayer);
        boolean expected = false;
        if(testPlayer.getScore() == 21){
            expected = true;
        }
        boolean actual = testBlackJackGAme.isBlackJack(testPlayer);

        Assert.assertEquals(expected, actual);
    }


}
