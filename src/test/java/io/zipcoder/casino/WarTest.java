package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class WarTest {

    @Test
    public void checkNumberOfCards() {
        Person player = new Person();
        War warGame = new War(player);
        Hand hand = new Hand();
        hand.getHandArrayList().add(new Card(Rank.DEUCE, Suit.CLUBS));
        hand.getHandArrayList().add(new Card(Rank.NINE, Suit.HEARTS));
        int expected = 2;
        int actual = warGame.checkNumberOfCards(hand);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareCardsTest() {
        Person player = new Person();
        War warGame = new War(player);
        Card smallCard = new Card(Rank.THREE, Suit.DIAMONDS);
        Card bigCard = new Card(Rank.SEVEN, Suit.DIAMONDS);
        int expected = 2;
        int actual = warGame.compareCards(smallCard, bigCard);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareCardsTest2() {
        Person player = new Person();
        War warGame = new War(player);
        Card smallCard = new Card(Rank.EIGHT, Suit.DIAMONDS);
        Card bigCard = new Card(Rank.DEUCE, Suit.DIAMONDS);
        int expected = 1;
        int actual = warGame.compareCards(smallCard, bigCard);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dealCardsTest() {
        Person player = new Person();
        War warGame = new War(player);
        warGame.dealCards();
    }

    @Test
    public void iDeclareWarTest() {
        Person player = new Person();
        War warGame = new War(player);
    }

}
