package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.casino.Card.Suit.*;
import static io.zipcoder.casino.Card.FaceValue.*;

public class GoFishPlayerTest {

    @Test
    public void fishForCardsTest() {
        GoFish game = new GoFish();
        GoFishPlayer player1 = new GoFishPlayer("A");
        GoFishPlayer player2 = new GoFishPlayer("B");
        GoFishPlayer player3 = new GoFishPlayer("C");
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game.addPlayers(players);

        player1.addCardToHand(new Card(NINE, HEARTS));
        player2.addCardToHand(new Card(NINE, CLUBS));
        player3.addCardToHand(new Card(FOUR, HEARTS));

        Assert.assertTrue(player1.fishForCards(player2, NINE));
        Assert.assertFalse(player1.fishForCards(player3, NINE));
    }

    @Test
    public void playPotentialBooksInHand() {
        GoFish game = new GoFish();
        GoFishPlayer player1 = new GoFishPlayer("A");
        GoFishPlayer player2 = new GoFishPlayer("B");
        GoFishPlayer player3 = new GoFishPlayer("C");
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game.addPlayers(players);

        CardPile nines = new CardPile();
        for(Card.Suit suit : Card.Suit.values()) {
            nines.addCardToPile(new Card(NINE, suit));
        }

        player1.addCardsToHand(nines);

        int actualNumBooksPlayed = player1.playPotentialBooksInHand();
        Assert.assertEquals(1, actualNumBooksPlayed);
        Assert.assertEquals(1, player1.getBooks().size());
        Assert.assertEquals(0, player1.getHand().numCards());
    }

    @Test
    public void goFishTest() {
        GoFishPlayer goFishPlayer = new GoFishPlayer("Amber");
        StandardDeck deck = new StandardDeck();
        Card randomCard = deck.getCard(0);

        goFishPlayer.goFish(randomCard);

        Assert.assertTrue(goFishPlayer.getHand().contains(randomCard));
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
