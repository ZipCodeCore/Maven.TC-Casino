package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {

    private Deck deckTest;
    private Card cardTest;

    @Test
    public void DeckTest() {
        //Given
        Deck deckTest = new Deck();

        //When
        ArrayList<Card> expected = deckTest.getDeckOfCards();
        ArrayList<Card> actual = deckTest.getDeckOfCards();

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ShuffleDeckTest(){
        //Given
        Deck deckTest = new Deck();
        deckTest.shuffleDeck();

        //When
        String expected = "";
        System.out.println(expected);

        ArrayList<Card> actual = deckTest.getDeckOfCards();
        System.out.println(actual);

        //Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void DrawCardTest(){
        //Given
        Deck deckTest = new Deck();

        //When
        Card expected = deckTest.drawCard();
        ArrayList<Card> actual = deckTest.getDeckOfCards();


        //Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void EmptyDeck(){
        //Given
        Deck deckTest = new Deck();
        deckTest.emptyDeck();
        //When
        ArrayList<Card> expected = deckTest.();
        System.out.println(expected);
        ArrayList<Card> actual = deckTest.getDeckOfCards();
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

}
