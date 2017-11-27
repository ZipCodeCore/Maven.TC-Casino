package io.zipcoder.casino.nuts_n_bolts.cards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class PlayingDeckTest {

    PlayingDeck deck;

    @Before
    public void setUp() {
        deck = new PlayingDeck();
    }

    @Test
    public void getAllCardsTest(){
        ArrayList<PlayingCard> cards;
        cards = deck.getAllCards();

        Assert.assertTrue((cards!=null)&&(cards.size()==52));
    }

    @Test
    public void getCardTest(){
        Integer expectedRemaining = 51;

        Assert.assertTrue(deck.getAndRemoveCard() != null);

        Integer actualRemaining = deck.countLeft();

        Assert.assertEquals(expectedRemaining, actualRemaining);
    }

    @Test
    public void populateTest() {
        Integer expectedCount = 52;
        Integer actualCount = deck.getAllCards().size();

        Assert.assertEquals( expectedCount, actualCount);
        Assert.assertTrue(deck.getAndRemoveCard() != null);
    }

    @Test
    public void shuffleTest(){
        PlayingCard[] cardArray1 = new PlayingCard[52];
        PlayingCard[] cardArray2 = new PlayingCard[52];

        PlayingCard[] initialArray = deck.getAllCards().toArray(cardArray1);
        deck.shuffle();

        PlayingCard[] shuffledArray = deck.getAllCards().toArray(cardArray2);

        Assert.assertFalse(Arrays.equals(initialArray, shuffledArray));
    }

}
