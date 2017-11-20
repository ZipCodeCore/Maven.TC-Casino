package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static io.zipcoder.casino.Card.Suit.*;
import static io.zipcoder.casino.Card.FaceValue.*;

public class GoFishPlayerTest {

    @Test
    public void goFishTest() {
        GoFishPlayer goFishPlayer = new GoFishPlayer("Amber");
        StandardDeck deck = new StandardDeck();
        Card randomCard = deck.getCard(0);

        goFishPlayer.goFish(randomCard);

        Assert.assertTrue(goFishPlayer.getHand().contains(randomCard));
    }

    @Test
    public void hasCardsOfRankTest() {
        GoFishPlayer goFishPlayer = new GoFishPlayer("Billy");
        Card nineOfDiamonds = new Card(NINE, DIAMONDS);
        Card eightOfClubs = new Card(EIGHT, CLUBS);
        goFishPlayer.addCardToHand(nineOfDiamonds);
        goFishPlayer.addCardToHand(eightOfClubs);

        Assert.assertTrue(goFishPlayer.hasCardsOfRank(NINE));
    }

    @Test
    public void doesNotHaveCardsOfRankTest() {
        GoFishPlayer goFishPlayer = new GoFishPlayer("Carol");
        Card nineOfDiamonds = new Card(NINE, DIAMONDS);
        Card eightOfClubs = new Card(EIGHT, CLUBS);
        goFishPlayer.addCardToHand(nineOfDiamonds);
        goFishPlayer.addCardToHand(eightOfClubs);

        Assert.assertFalse(goFishPlayer.hasCardsOfRank(SEVEN));
    }

    @Test
    public void handOverAllCardsRequestedTest() {
        GoFishPlayer goFishPlayer = new GoFishPlayer("David");
        Card nineOfDiamonds = new Card(NINE, DIAMONDS);
        Card eightOfClubs = new Card(EIGHT, CLUBS);
        Card nineOfHearts = new Card(NINE, HEARTS);
        goFishPlayer.addCardToHand(nineOfDiamonds);
        goFishPlayer.addCardToHand(eightOfClubs);
        goFishPlayer.addCardToHand(nineOfHearts);

        CardPile expected = new CardPile();
        expected.addCardToPile(nineOfDiamonds);
        expected.addCardToPile(nineOfHearts);

        boolean handedCardsExpected = goFishPlayer.handOverAllCardsRequested(NINE).containsAll(expected);
        boolean handStillHasTheOldCards = goFishPlayer.getHand().containsAll(expected);

        Assert.assertTrue(handedCardsExpected && !handStillHasTheOldCards);
    }
}
