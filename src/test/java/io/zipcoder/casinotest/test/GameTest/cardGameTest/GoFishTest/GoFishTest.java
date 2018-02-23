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
    public void testAsk(){


    }
    @Test
    public void testTransfer(){

        ArrayList<Card>testTo = new ArrayList<>();
        ArrayList<Card>testFrom=new ArrayList<>();
        Card card = new Card(CardSuit.DIAMONDS,CardRank.TWO);
        testFrom.add(card);
        int expected = 1;

        //GoFish testGoFish = new GoFish();
        //testGoFish.transfer(card,testTo,testFrom);

        int actual = testTo.size();
        Assert.assertEquals(expected,actual);


    }
    @Test
    public void testDrawCard(Player player){


    }
    @Test
    public void testPassTurn(Player player1,Player player2){

    }

}
