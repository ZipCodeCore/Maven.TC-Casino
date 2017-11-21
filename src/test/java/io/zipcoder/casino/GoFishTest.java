package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.casino.Card.FaceValue.*;
import static io.zipcoder.casino.Card.Suit.*;

public class GoFishTest {

    @Test
    public void testConstructor() {
        GoFish game = new GoFish();

        Assert.assertEquals(52, game.getStockPile().numCards());
    }

    @Test
    public void dealInitialCards() {
        GoFish game = new GoFish();
        GoFishPlayer player1 = new GoFishPlayer("A");
        GoFishPlayer player2 = new GoFishPlayer("B");
        GoFishPlayer player3 = new GoFishPlayer("C");
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game.addPlayers(players);

        game.setNumInitialCards();
        game.dealInitialCards();

        for(GoFishPlayer player : game.getPlayers()) {
            Assert.assertEquals(7, player.getHand().numCards());
        }
    }

    @Test
    public void goFishTest() {
        GoFish game = new GoFish();
        GoFishPlayer player1 = new GoFishPlayer("A");
        GoFishPlayer player2 = new GoFishPlayer("B");
        GoFishPlayer player3 = new GoFishPlayer("C");
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game.addPlayers(players);

        game.setNumInitialCards();
        game.dealInitialCards();

        int numInitialCards = player1.getHand().numCards();
        game.playerGoFish(player1);

        Assert.assertEquals(numInitialCards + 1, player1.getHand().numCards());
    }

    @Test
    public void determineWinnerTest() {
        GoFish game = new GoFish();
        GoFishPlayer player1 = new GoFishPlayer("A");
        GoFishPlayer player2 = new GoFishPlayer("B");
        GoFishPlayer player3 = new GoFishPlayer("C");
        ArrayList<GoFishPlayer> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game.addPlayers(players);

        ArrayList<CardPile> allBooks = new ArrayList<>();

        for(Card.FaceValue faceValue : Card.FaceValue.values()) {
            CardPile book = new CardPile();
            for(Card.Suit suit : Card.Suit.values()) {
                book.addCardToPile(new Card(faceValue, suit));
            }
            allBooks.add(book);
        }

        player1.addCardsToHand(allBooks.get(0));
        player1.addCardsToHand(allBooks.get(1));
        player1.addCardsToHand(allBooks.get(2));

        player2.addCardsToHand(allBooks.get(3));
        player2.addCardsToHand(allBooks.get(4));
        player2.addCardsToHand(allBooks.get(5));
        player2.addCardsToHand(allBooks.get(6));
        player2.addCardsToHand(allBooks.get(7));
        player2.addCardsToHand(allBooks.get(11));
        player2.addCardsToHand(allBooks.get(12));

        player3.addCardsToHand(allBooks.get(8));
        player3.addCardsToHand(allBooks.get(9));
        player3.addCardsToHand(allBooks.get(10));


        player1.playPotentialBooksInHand();
        player2.playPotentialBooksInHand();
        player3.playPotentialBooksInHand();

        GoFishPlayer winner = game.determineWinner();

        Assert.assertTrue(player2.equals(winner));
    }
}
