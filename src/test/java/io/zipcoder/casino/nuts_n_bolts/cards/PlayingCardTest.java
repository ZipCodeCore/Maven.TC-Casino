package io.zipcoder.casino.nuts_n_bolts.cards;

import org.junit.Assert;
import org.junit.Test;

public class PlayingCardTest {


    @Test
    public void testCardGetValue(){
        PlayingCard card = new PlayingCard(PlayingSuit.HEART, PlayingValue.SIX);

        PlayingValue expected = PlayingValue.SIX;
        PlayingValue actual = card.getValue();

        Assert.assertTrue(actual.equals(expected));
    }

    @Test
    public void testCardGetSuit(){
        PlayingCard card = new PlayingCard(PlayingSuit.HEART, PlayingValue.SIX);

        PlayingSuit expected = PlayingSuit.HEART;
        PlayingSuit actual = card.getSuit();

        Assert.assertTrue(expected.equals(actual));
    }


}