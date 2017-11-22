package io.zipcoder.casino.nuts_n_bolts.cards;

import org.junit.Assert;
import org.junit.Test;

public class HandTest {

    @Test
    public void handShouldBeEmptyTest(){
        Hand hand = new Hand();

        Assert.assertTrue(hand.isHandEmpty());
    }

    @Test
    public void addAndhandShouldNotBeEmptyTest(){
        Hand hand = new Hand();
        hand.addCard(new PlayingCard(PlayingSuit.HEART, PlayingValue.QUEEN));

        Assert.assertFalse(hand.isHandEmpty());
    }

    @Test
    public void addAndRemoveTest(){
        Hand hand = new Hand();
        hand.addCard(new PlayingCard(PlayingSuit.HEART, PlayingValue.QUEEN));
        Assert.assertFalse(hand.isHandEmpty());

        hand.removeCard(hand.getAllCards().get(0));
        Assert.assertTrue(hand.isHandEmpty());
    }

    @Test
    public void addAndGetTest(){
        Hand hand = new Hand();
        PlayingCard expectedCard = new PlayingCard(PlayingSuit.HEART, PlayingValue.QUEEN);
        hand.addCard(expectedCard);

        PlayingCard actualCard = hand.getCard(expectedCard);
        Assert.assertTrue(hand.isHandEmpty());

        Assert.assertEquals(expectedCard, actualCard);
    }

}
