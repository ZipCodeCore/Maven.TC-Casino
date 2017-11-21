package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.Card.Suit.*;
import static io.zipcoder.casino.Card.FaceValue.*;

public class CardPlayerTest {

    @Test
    public void addCardToHandTest() {
        CardPlayer player = new CardPlayer("");
        Card twoOfClubs = new Card(TWO, CLUBS);

        player.addCardToHand(twoOfClubs);

        Assert.assertTrue(player.getHand().contains(twoOfClubs));
    }

    @Test
    public void addCardsToHandTest() {
        CardPlayer player = new CardPlayer("");
        Card twoOfClubs = new Card(TWO, CLUBS);
        Card threeOfClubs = new Card(THREE, CLUBS);
        CardPile cards = new CardPile();
        cards.addCardToPile(twoOfClubs);
        cards.addCardToPile(threeOfClubs);

        player.addCardsToHand(cards);

        Assert.assertTrue(player.getHand().containsAll(cards));
    }
}
