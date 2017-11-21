package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {
    Deck deck = new Deck();


    @Test
    public void constructorTest(){
        ArrayList<Card> cards = deck.getCards();
        String expected = "a bunch of cards";
        String actual = "***output***\n ";
        for(Card card: cards){
            actual +=(card.getRank() + " of " + card.getSuit()+"s\n");
        }
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleTest() throws Exception {
        deck.shuffle();
        ArrayList<Card> cards = deck.getCards();

        String expected = "a bunch of cards";

        String actual = "***output***\n";

        for(Card card: cards){
            actual +=(card.getRank() + " of " + card.getSuit()+"s\n");
        }

        Assert.assertEquals(expected, actual);

    }

    public void testPop(){

    }


}