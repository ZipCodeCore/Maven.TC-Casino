package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class DeckTest {

    private Deck deckTest;

    @Test
    public void DeckTest() {
        //Given
        Deck deckTest = new Deck();
        deckTest.getDeckOfCards().add("Ace of Spades");

        //When
        String expected = "Ace of Spades";
        System.out.println(expected);
        String actual = deckTest.getDeckOfCards().get(0);
        System.out.println(actual);

        //Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void ShuffleDeckTest(){
        //Given
        Deck deckTest = new Deck();
        deckTest.getDeckOfCards().add("Three of Spades");
        deckTest.getDeckOfCards().add("Ace of Spades");
        deckTest.getDeckOfCards().add("Three of Hearts");
        deckTest.getDeckOfCards().add("Ten of Diamonds");

        deckTest.shuffleDeck();

        //When
        String expected = "";
        System.out.println(expected);
        ArrayList<String> actual = deckTest.getDeckOfCards();
        System.out.println(actual);

        //Then
        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void DrawCardTest(){
        //Given
        Deck deckTest = new Deck();
        deckTest.getDeckOfCards().add("Three of Spades");
        deckTest.getDeckOfCards().add("Ace of Spades");
        deckTest.getDeckOfCards().add("Three of Hearts");
        deckTest.getDeckOfCards().add("Ten of Diamonds");
        //When
        //
        //Then
        String expected = deckTest.drawCard();
        System.out.println(expected);
        ArrayList<String> actual = deckTest.getDeckOfCards();
        System.out.println(actual);

        Assert.assertNotEquals(expected, actual);
    }

    @Test
    public void DrawCardTest2(){
        //Given
        Deck deckTest = new Deck();

        //When

        //Then
        String expected = deckTest.drawCard();
        System.out.println(expected);
        ArrayList<String> actual = deckTest.getDeckOfCards();
        System.out.println(actual);

        Assert.assertNotEquals(expected, actual);
    }

}
