package io.zipcoder.casino;

import org.junit.Test;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.Arrays;


public class HandTest {

    private Hand hand;
    private ArrayList<Card> handArrayList;
    //        System.out.println("\u270B" + " my hand " + "\u270B");
    //        System.out.println("\u2660" + "\u2663" + "\u2665" + "\u2666");

    @Test
    public void handConstructorArrayList() {

        // Given
        // I receive an empty arraylist from cardDeck
        int expectedHandSize = 0;
        // When
        Hand hand = new Hand();
        int actualHandSize = hand.getHandArrayList().size();

        // Then
        Assert.assertEquals(expectedHandSize, actualHandSize);

    }

    @Test
    public void getHandArrayList() {

        //return currentarraylist

        // Given
        Hand hand = new Hand();
        Card expectedCard = new Card(Rank.SEVEN, Suit.SPADES);
        String expectedCardString = expectedCard.toString();
        //System.out.println(hand.getHandArrayList());

        // When
        hand.getHandArrayList().add(expectedCard);
        Card actualCard = hand.getHandArrayList().get(0);
        String actualCardString = actualCard.toString();

        // Then
        Assert.assertEquals(expectedCardString, actualCardString);

    }

    @Test
    public void receiveCardsFromDealerTest() { // This is like getHand

        // Given
        Hand hand = new Hand();
        hand.receiveCards(new Card(Rank.DEUCE, Suit.CLUBS));
        Card expectedCard0 = new Card(Rank.DEUCE, Suit.CLUBS);
        String expectedString = expectedCard0.toString();


        // When
        Card actualCard0 = hand.getHandArrayList().get(0);
        String actualString = actualCard0.toString();

        // Then
        Assert.assertEquals(expectedString, actualString);

    }

    @Test
    public void drawCardFromHandTest() {

        // Return last item in ArrayList and then delete it
        // Given
        Hand hand = new Hand();
        Card expectedToStay = new Card(Rank.DEUCE, Suit.CLUBS);
        Card expectedToDelete = new Card(Rank.THREE, Suit.CLUBS);
        hand.receiveCards(expectedToStay, expectedToDelete);

        int expectedArraySizeAfterDeletion = 1;

        // When
        hand.drawCardfromHand();
        int actualArraySizeAfterDeletion = hand.getHandArrayList().size();

        // Then
        Assert.assertEquals(expectedArraySizeAfterDeletion, actualArraySizeAfterDeletion);
    }

    // REMOVESPECIFIC CARD
    @Test
    public void getSpecificCardsArrayListTest() {

        // Return specificCardsArrayList
        /**
         * I'll receive specific var args of cards to give
         * I'll remove them from my handArrayList
         * - loop through handArrayList, remove card/index, then i-- to go back one before next loop
         * I'll add them to a new array called specificCardsArrayList and return that array
         */

        // Given
        Hand hand = new Hand();
        Card cardToStay1 = new Card(Rank.DEUCE, Suit.CLUBS);
        Card cardTostay2 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card cardToSend1 = new Card(Rank.FOUR, Suit.HEARTS);
        Card cardToSend2 = new Card(Rank.FIVE, Suit.SPADES);
        hand.receiveCards(cardToStay1, cardTostay2, cardToSend1, cardToSend2);

        String expectedCardToSend1 = cardToSend1.toString();
        String expectedCardToSend2 = cardToSend2.toString();

        System.out.println(Arrays.toString(hand.getHandArrayList().toArray()));

        // When
        hand.getSpecificCardsArrayList(cardToSend1, cardToSend2);
        System.out.println(Arrays.toString(hand.getHandArrayList().toArray()));
        System.out.println(Arrays.toString(hand.getSpecificCardsArrayList().toArray()));


        String actualCardToSend1 = hand.getSpecificCardsArrayList().get(0).toString();
        String actualCardToSend2 = hand.getSpecificCardsArrayList().get(1).toString();

        // Then
        Assert.assertEquals(expectedCardToSend1, actualCardToSend1);
        Assert.assertEquals(expectedCardToSend2, actualCardToSend2);
    }

    @Test
    public void clearHandTest() {
        // reset array size to zero

        // Given
        Hand hand = new Hand();

        int expectedArraySize = 0;
        Card expectedToDelete = new Card(Rank.THREE, Suit.CLUBS);
        hand.receiveCards(expectedToDelete);

        // When
        hand.getHandArrayList().clear();
        int actualArraySize = hand.getHandArrayList().size();

        // Then
        Assert.assertEquals(expectedArraySize, actualArraySize);

    }

    @Test
    public void shuffleHandTest(){

        // Given
        Hand hand = new Hand();
        Card notShuffled0 = new Card(Rank.DEUCE, Suit.CLUBS);
        Card notShuffled1 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card notShuffled2 = new Card(Rank.FOUR, Suit.HEARTS);
        Card notShuffled3 = new Card(Rank.FIVE, Suit.SPADES);
        hand.receiveCards(notShuffled0, notShuffled1, notShuffled2, notShuffled3);
        //System.out.println(hand.getHandArrayList());

        // When
        hand.shuffleHand();
        Card cardAtIndex0 = hand.getHandArrayList().get(0);
        //System.out.println(hand.getHandArrayList());

        // Then
        Assert.assertNotEquals(notShuffled0, cardAtIndex0);

    }


    @Test
    public void toStringTest() {

        // Given
        Hand hand = new Hand();
        Card notShuffled0 = new Card(Rank.DEUCE, Suit.CLUBS);
        Card notShuffled1 = new Card(Rank.THREE, Suit.DIAMONDS);
        Card notShuffled2 = new Card(Rank.FOUR, Suit.HEARTS);
        Card notShuffled3 = new Card(Rank.FIVE, Suit.SPADES);
        hand.receiveCards(notShuffled0, notShuffled1, notShuffled2, notShuffled3);

        // Print
        System.out.println("My hand: " + "\u270B" + Arrays.toString(hand.getHandArrayList().toArray()) + "\u270B");
        System.out.println("\u2660" + "\u2663" + "\u2665" + "\u2666");

        // Then

    }




}
