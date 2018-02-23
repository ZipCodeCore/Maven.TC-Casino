package io.zipcoder.casinotest.test.GameTest.cardGameTest.GoFishTest;

import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFish;
import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFishPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Card;
import io.zipcoder.casino.Game.cardGame.utilities.CardRank;
import io.zipcoder.casino.Game.cardGame.utilities.CardSuit;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class GoFishTest {
    Player player1;
    Player dealer;
    Deck testDeck = new Deck();




    @Test
    public void testDeal() {
        Map<Player, ArrayList<Card>>testCardsAtHand = new HashMap<>();
        ArrayList<Card> testDealerCards= new ArrayList<Card>();
        ArrayList<Card>testPlayerCards= new ArrayList<Card>();
        Deck testDeck = new Deck();
        GoFish testGoFish= new GoFish();

        System.out.println(testDeck.countRemainingCards());

        Profile testProfilePlayer = new Profile("John",5000,0);
        Profile testProfileDealer= new Profile("Mark",5000,1);
        Player testPlayer = new GoFishPlayer(testProfilePlayer);
        Player testDealer = new GoFishPlayer(testProfileDealer);

        testCardsAtHand.put(testPlayer,testPlayerCards);
        testCardsAtHand.put(testDealer,testDealerCards);
        testGoFish.deal(testDeck,testPlayer,testDealer);
        Integer expected = 7;
        Integer actual = testCardsAtHand.get(testPlayer).size();

        Assert.assertEquals(expected,actual);






    }

    @Test
    public void testAsk(){

        boolean


    }
    @Test
    public void testTransfer(){

        ArrayList<Card>testTo = new ArrayList<>();
        ArrayList<Card>testFrom=new ArrayList<>();
        Card card = new Card(CardSuit.DIAMONDS,CardRank.TWO);
        testFrom.add(card);
        int expected = 1;

        GoFish testGoFish = new GoFish();
        //testGoFish.transfer(card,testTo,testFrom);

        int actual = testTo.size();
        Assert.assertEquals(expected,actual);


    }
   /* @Test
    public void testDrawCard(Player player){


    }
    @Test
    public void testPassTurn(Player player1,Player player2){

    }*/

}
