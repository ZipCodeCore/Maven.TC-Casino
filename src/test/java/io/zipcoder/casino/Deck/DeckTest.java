package io.zipcoder.casino.Deck;

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

}