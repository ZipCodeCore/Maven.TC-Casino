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

    @Test
    public void hasCardsOfRankTest() {
        CardPlayer player = new CardPlayer("");
        Card nineOfDiamonds = new Card(NINE, DIAMONDS);
        Card eightOfClubs = new Card(EIGHT, CLUBS);
        player.addCardToHand(nineOfDiamonds);
        player.addCardToHand(eightOfClubs);

        Assert.assertTrue(player.hasCardsOfRank(NINE));
    }

    @Test
    public void doesNotHaveCardsOfRankTest() {
        CardPlayer player = new CardPlayer("");
        Card nineOfDiamonds = new Card(NINE, DIAMONDS);
        Card eightOfClubs = new Card(EIGHT, CLUBS);
        player.addCardToHand(nineOfDiamonds);
        player.addCardToHand(eightOfClubs);

        Assert.assertFalse(player.hasCardsOfRank(SEVEN));
    }
}
