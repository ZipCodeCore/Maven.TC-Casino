package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.Card.Suit.*;
import static io.zipcoder.casino.Card.FaceValue.*;

public class PlayerTest {

    @Test
    public void addCardToHandTest() {
        Player player = new Player("");
        Card twoOfClubs = new Card(TWO, CLUBS);

        player.addCardToHand(twoOfClubs);

        Assert.assertTrue(player.getHand().contains(twoOfClubs));
    }

    @Test
    public void addCardsToHandTest() {
        Player player = new Player("");
        Card twoOfClubs = new Card(TWO, CLUBS);
        Card threeOfClubs = new Card(THREE, CLUBS);
        CardPile cards = new CardPile();
        cards.addCardToPile(twoOfClubs);
        cards.addCardToPile(threeOfClubs);

        player.addCardsToHand(cards);

        Assert.assertTrue(player.getHand().containsAll(cards));
    }
}
