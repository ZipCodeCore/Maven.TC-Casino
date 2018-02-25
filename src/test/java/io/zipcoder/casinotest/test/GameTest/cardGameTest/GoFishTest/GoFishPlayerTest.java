package io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest;

import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFishPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.CardSuit;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GoFishPlayerTest {

    Profile testProfile;
    GoFishPlayer testGoFishPlayer;

    @Before
    public void setUp() {
        testProfile = new Profile("Kibret",5000, 0);
        testGoFishPlayer = new GoFishPlayer(testProfile);
    }


    @Test
    public void testBuildBook1(){
        Hand aHand = new Hand();
        testGoFishPlayer.setHand(aHand);
        Card firstCard = new Card(CardSuit.HEARTS, CardRank.JACK);
        Card secondCard = new Card(CardSuit.DIAMONDS,CardRank.TWO);
        Card thirdCard = new Card(CardSuit.SPADES,CardRank.JACK);
        testGoFishPlayer.getHand().getCards().add(firstCard);
        testGoFishPlayer.getHand().getCards().add(secondCard);
        testGoFishPlayer.getHand().getCards().add(thirdCard);

        int expected = 2;
        testGoFishPlayer.buildBooks(testGoFishPlayer,CardRank.JACK);
        int actual=testGoFishPlayer.getBook().size();

        Assert.assertEquals(expected,actual);


    }

    @Test
    public void testBuildBook2(){
        Hand aHand = new Hand();
        Hand hand2=new Hand();
        Profile profile2 = new Profile("aaa",1000,100);
        GoFishPlayer testGoFishPlayer2 = new GoFishPlayer(profile2);
        testGoFishPlayer2.setHand(hand2);

        testGoFishPlayer.setHand(aHand);
        Card firstCard = new Card(CardSuit.HEARTS, CardRank.JACK);
        Card secondCard = new Card(CardSuit.DIAMONDS,CardRank.TWO);
        Card thirdCard = new Card(CardSuit.SPADES,CardRank.JACK);

        testGoFishPlayer.getHand().getCards().add(firstCard);
        testGoFishPlayer.getHand().getCards().add(secondCard);
        testGoFishPlayer.getHand().getCards().add(thirdCard);


        System.out.println(testGoFishPlayer.getHand().showHand());
        testGoFishPlayer2.buildBooks(testGoFishPlayer,CardRank.JACK);
        for(Card card:testGoFishPlayer2.getBook()){
            testGoFishPlayer2.getHand().addCard(card);
        }
        System.out.println(testGoFishPlayer2.getHand().showHand());

    }

    @Test
    public void setScoreTest(){
        int expected = 10;
        testGoFishPlayer.setScore(10);
        int actual = testGoFishPlayer.getScore();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void getScoreTest(){
        int expected = 25;
        testGoFishPlayer.setScore(15);
        int actual = testGoFishPlayer.getScore();
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void setHandTest() {
        Profile anotherProfile = new Profile("card player", 500, 5);
        GoFishPlayer anotherCardPlayer = new GoFishPlayer(anotherProfile);
        Hand cardPlayerHand = new Hand();
        anotherCardPlayer.setHand(cardPlayerHand);
        Hand expected = cardPlayerHand;
        Hand actual = anotherCardPlayer.getHand();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getHandTest() {
        Assert.assertNotNull(testGoFishPlayer.getHand());

    }



}