package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class WarTest {

    // psvm for isolated War testing
//    public static void main(String[] args) {
//        Person player = new Person();
//        War war = new War(player);
//        war.start();
//    }

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

    @Test
    public void decideHowManyYaddaYaddaTest_handHasFourCards() {
        Person player = new Person();
        War warGame = new War(player);
        int expected = 4;
        int actual = warGame.decideOnHowManyTimesToIterateBasedOn(4);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decideHowManyYaddaYaddaTest_handHasMoreThanFourCards() {
        Person player = new Person();
        War warGame = new War(player);
        int expected = 4;
        int actual = warGame.decideOnHowManyTimesToIterateBasedOn(7);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void decideHowManyYaddaYaddaTest_handHasLessThanFourCards() {
        Person player = new Person();
        War warGame = new War(player);
        int expected = 2;
        int actual = warGame.decideOnHowManyTimesToIterateBasedOn(2);
        Assert.assertEquals(expected, actual);
    }

}
