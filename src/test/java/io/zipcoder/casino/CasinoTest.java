package io.zipcoder.casino;


import org.junit.Assert;
import org.junit.Test;

public class CasinoTest {

    @Test
    public void createFullDeckTest(){
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();

        String expected = "";
        String actual = playingDeck.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getSizeTest(){
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();

        int expected = 52;
        int actual = playingDeck.getSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shuffleTest(){
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        String expected = "";
        String actual = playingDeck.toString();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void giveCardTest(){
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();

        Card expected = new Card(Suit.SPADE, Value.ACE);
        Card actual = playingDeck.giveCard();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void sizeAfterGiveCard(){
        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();

        playingDeck.giveCard();

        int expected = 51;
        int actual = playingDeck.getSize();

        Assert.assertEquals(expected, actual);
    }

}
