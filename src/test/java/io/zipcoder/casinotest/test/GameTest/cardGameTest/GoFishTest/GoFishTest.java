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
    public void countMatchesInHandTest1() {
        Card newCard = testGame.getDeck().getCard();
        testGame.getUser().getHand().addCard(newCard);
        CardRank testCardRank = newCard.getRank();
        int expected = 1;
        int actual = testGame.countMatchesInHand(testGame.getUser(), testCardRank);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countMatchesInHandTest2() {
        Card newCard = testGame.getDeck().getCard();
        testGame.getUser().getHand().addCard(newCard);
        CardRank testCardRank = newCard.getRank();
        Card anotherCard = new Card(CardSuit.SPADES, newCard.getRank());
        testGame.getUser().getHand().addCard(anotherCard);
        int expected = 2;
        int actual = testGame.countMatchesInHand(testGame.getUser(), testCardRank);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void countMatchesInHandTest3() {
        Card newCard = new Card(CardSuit.HEARTS, CardRank.JACK);
        testGame.getUser().getHand().addCard(newCard);
        Card secondCard = new Card(CardSuit.DIAMONDS, CardRank.JACK);
        testGame.getUser().getHand().addCard(secondCard);
        Card thirdCard = new Card(CardSuit.DIAMONDS, CardRank.EIGHT);
        testGame.getUser().getHand().addCard(thirdCard);

        CardRank newCardRank = newCard.getRank();
        int expected = 2;
        int actual = testGame.countMatchesInHand(testGame.getUser(), newCardRank);
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void fishTest1() {
        testGame.fish(testGame.getUser());
        int expected = 1;
        int actual = testGame.getUser().getHand().getCards().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fishTest2() {
        Card expected = testGame.getDeck().peek();
        testGame.fish(testGame.getUser());
        Card actual = testGame.getUser().getHand().getCards().get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void transferCardTest1() {
        Card newCard = new Card(CardSuit.HEARTS, CardRank.JACK);
        testGame.getUser().getHand().addCard(newCard);
        Card secondCard = new Card(CardSuit.DIAMONDS, CardRank.FIVE);
        testGame.getUser().getHand().addCard(secondCard);

        CardRank newCardRank = newCard.getRank();
        testGame.transfer(newCardRank, testGame.getUser(), testGame.getDealer());

        Assert.assertTrue(testGame.getDealer().getHand().hasCard(newCard));
    }

    @Test
    public void transferCardTest2() {
        Card newCard = new Card(CardSuit.HEARTS, CardRank.FIVE);
        testGame.getUser().getHand().addCard(newCard);
        Card secondCard = new Card(CardSuit.DIAMONDS, CardRank.FIVE);
        testGame.getUser().getHand().addCard(secondCard);

        CardRank newCardRank = newCard.getRank();
        testGame.transfer(newCardRank, testGame.getUser(), testGame.getDealer());

        int expected = 2;
        int actual = testGame.getDealer().getHand().getCards().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askTest1() {
        Card newCard = new Card(CardSuit.SPADES, CardRank.THREE);
        Card anotherCard = new Card(CardSuit.HEARTS, CardRank.QUEEN);
        testGame.getUser().getHand().addCard(newCard);
        testGame.getDealer().getHand().addCard(anotherCard);
        testGame.playerAsk(CardRank.QUEEN, testGame.getDealer(), testGame.getUser());

        Card expected = anotherCard;
        Card actual = testGame.getDealer().getHand().getCards().get(0);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askTest2() {
        Card newCard = new Card(CardSuit.SPADES, CardRank.THREE);
        Card anotherCard = new Card(CardSuit.HEARTS, CardRank.QUEEN);
        testGame.getUser().getHand().addCard(newCard);
        testGame.getDealer().getHand().addCard(anotherCard);
        testGame.playerAsk(anotherCard.getRank(), testGame.getUser(), testGame.getDealer());
        int expected = 2;
        int actual = testGame.getDealer().getHand().getCards().size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void askTest3() {
        Card newCard = new Card(CardSuit.SPADES, CardRank.QUEEN);
        Card anotherCard = new Card(CardSuit.HEARTS, CardRank.QUEEN);
        testGame.getUser().getHand().addCard(newCard);
        testGame.getDealer().getHand().addCard(anotherCard);
        testGame.playerAsk(anotherCard.getRank(), testGame.getUser(), testGame.getDealer());
        Assert.assertTrue(testGame.getDealer().getHand().hasCard(newCard));
    }

    @Test
    public void askTest4() {
        Card newCard = new Card(CardSuit.SPADES, CardRank.JACK);
        Card anotherCard = new Card(CardSuit.HEARTS, CardRank.JACK);
        Card aThirdCard = new Card(CardSuit.CLUBS, CardRank.JACK);
        testGame.getUser().getHand().addCard(newCard);
        testGame.getDealer().getHand().addCard(anotherCard);
        testGame.getDealer().getHand().addCard(aThirdCard);
        testGame.playerAsk(anotherCard.getRank(), testGame.getDealer(), testGame.getUser());
        int expected = 3;
        int actual = testGame.getUser().getHand().getCards().size();
        Assert.assertEquals(expected, actual);
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


