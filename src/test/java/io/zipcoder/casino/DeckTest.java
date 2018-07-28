package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DeckTest {
    Deck deck = new Deck(1);

    @Test
    public void multiDeckTest() throws Exception {
        deck=new Deck(2);
        String expected="";
        while (deck.getRemainingCards() != 0) {
            expected+=deck.getCard()+"\n";
        }
        expected.concat(expected);

        String actual="";
        deck = new Deck(2);
        while (deck.getRemainingCards() != 0) {
            actual+=deck.getCard().toString()+"\n";
        }

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getCard() throws Exception {
        Card expected = new Card(Card.Rank.TWO, Card.Suit.CLUBS);
        Card actual = deck.getCard();

        Assert.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void shuffleDeck() throws Exception {

        String newDeck="";
        deck = new Deck(1);
        while (deck.getRemainingCards() != 0) {
            newDeck+=deck.getCard()+"\n";
        }


        String shuffledDeck="";
        deck = new Deck(1);
        deck.shuffleDeck();
        while (deck.getRemainingCards() != 0) {
            shuffledDeck+=deck.getCard().toString()+"\n";
        }

        Assert.assertNotEquals(newDeck, shuffledDeck);
    }

}