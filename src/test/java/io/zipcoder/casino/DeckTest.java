package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class DeckTest {

    @Test
    public void constructorTest(){
        Deck deck = new Deck();

        ArrayList<Card> cards = deck.getCards();

        String expected = "a bunch of cards";
        String actual = "***output***\n";

        for(Card card: cards){
            actual +=(card.getRank() + " of " + card.getSuit()+"s\n");
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleTest() throws Exception {
        Deck deck = new Deck();
        deck.shuffle();
        ArrayList<Card> cards = deck.getCards();

        String expected = "a bunch of cards";

        String actual = "***output***\n";

        for(Card card: cards){
            actual +=(card.getRank() + " of " + card.getSuit()+"s\n");
        }

        Assert.assertEquals(expected, actual);


    }


}