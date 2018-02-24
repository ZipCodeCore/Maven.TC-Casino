package io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest;

import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFish;

import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.CardSuit;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class GoFishTest {

    private Profile testUserProfile;
    private GoFish testGame;


    @Before
    public void setup() {
        testUserProfile = new Profile("Kibret", 100000, 2);
        testGame = new GoFish(testUserProfile);
    }

    @Test
    public void dealTest1() {
        testGame.deal();
        int expected = 38;
        int actual = testGame.getDeck().countRemainingCards();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkHandForCardTest1() {
        Card newCard = testGame.getDeck().getCard();
        testGame.getUser().getHand().addCard(newCard);
        CardRank testCardRank = newCard.getRank();
        int expected = 1;
        int actual = testGame.checkHandForCard(testGame.getUser(), testCardRank);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkHandForCardTest2() {
        Card newCard = testGame.getDeck().getCard();
        testGame.getUser().getHand().addCard(newCard);
        CardRank testCardRank = newCard.getRank();
        Card anotherCard = new Card(CardSuit.SPADES, newCard.getRank());
        testGame.getUser().getHand().addCard(anotherCard);
        int expected = 2;
        int actual = testGame.checkHandForCard(testGame.getUser(), testCardRank);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkHandForCardTest3() {
        Card newCard = new Card(CardSuit.HEARTS, CardRank.JACK);
        Card secondCard = new Card(CardSuit.DIAMONDS, CardRank.JACK);
        Card thirdCard = new Card(CardSuit.DIAMONDS, CardRank.EIGHT);

        CardRank newCardRank = newCard.getRank();

        testGame.getUser().getHand().addCard(newCard);
        testGame.getUser().getHand().addCard(secondCard);
        testGame.getUser().getHand().addCard(thirdCard);

        int expected = 2;
        int actual = testGame.checkHandForCard(testGame.getUser(), newCardRank);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askTest1() {

    }


    @Test
    public void testGetDeck(){


    }

    @Test
    public void calculateScore(){


    }

    @Test
    public void testDecideWinner( ){


    }

    @Test
    public void testAddPlayer() {

    }

    @Test
    public void testRemovePlayer() {

    }

    @Test
    public void testStartGame() {

    }

    @Test
    public void testEndGame() {

    }

    @Test
    public void testGetRules() {


    }


}


