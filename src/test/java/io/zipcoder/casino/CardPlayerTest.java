package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CardPlayerTest {

    @Test
    public void takeCardTest(){
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        Deck deck = new Deck();
        deck.createFullDeck();

        Card cardToTake = deck.giveCard();

        chewy.takeCard(cardToTake);

        int expected = 9;
        int actual = chewy.getHand().size();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void testHandSize(){
        CardPlayer chewy = new CardPlayer("Chewy", 100.00);

        int expected = 9;
        int actual = chewy.getHand().size();

        Assert.assertEquals(expected, actual);
    }



}