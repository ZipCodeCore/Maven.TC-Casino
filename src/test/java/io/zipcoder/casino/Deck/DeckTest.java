package io.zipcoder.casino.Deck;

import io.zipcoder.casino.Blackjack;
import io.zipcoder.casino.Player;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeckTest {

    Deck testDeck = new Deck();

    @Test
    public void getCard(){
        int expected = 51;
        testDeck.getCard();
        int actual = testDeck.getAllCards().size();

        Assert.assertEquals(expected,actual);
    }

    @Test
    public void getAllCards(){
        int expected = 52;
        int actual = testDeck.getAllCards().size();

        Assert.assertEquals(expected,actual);

    }
    @Test
    public void populateTest(){

        int expected = 52;
        int actual = testDeck.getAllCards().size();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void shuffle() {
        Card expected = testDeck.getCard();
        System.out.println(expected);
        testDeck.shuffle();
        Card actual = testDeck.getCard();
        System.out.println(actual);

        Assert.assertFalse(expected == actual);
    }

    @Test
    public void goFistValueTest(){
        Player testPlayer = new Player("wes",21,1000);
        Blackjack testGame = new Blackjack(testPlayer);
        testGame.deal(testGame.getPlayer(),testGame.getDealer(),5);
        for(Card card:testGame.getPlayer().getHand()){
            System.out.println(card.getGoFishValue());
        }
    }

}