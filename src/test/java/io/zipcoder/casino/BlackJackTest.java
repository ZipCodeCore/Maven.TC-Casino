package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.casino.Card.FaceValue.ACE;
import static io.zipcoder.casino.Card.FaceValue.JACK;
import static io.zipcoder.casino.Card.Suit.DIAMONDS;
import static io.zipcoder.casino.Card.Suit.SPADES;

public class BlackJackTest {

    @Test
    public void testConstructor() {
        BlackJack game = new BlackJack(4);

        Assert.assertEquals(208, game.getStockPile().numCards());
    }

    @Test
    public void dealInitialCards() {
        BlackJack game = new BlackJack(4);

        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        BlackJackPlayer player1 = new BlackJackPlayer("Apple");
        BlackJackPlayer player2 = new BlackJackPlayer("Banana");
        players.add(player1);
        players.add(player2);
        game.addPlayers(players);
        player1.setMoney(100.0);
        player2.setMoney(100.0);
        game.takeBet(player1, 100.0);
        game.takeBet(player2, 100.0);

        game.dealInitialCards();

        for(BlackJackPlayer player : game.getPlayers()) {
            Assert.assertEquals(2, player.getHand().numCards());
        }
        Assert.assertEquals(2, game.getDealer().getHand().numCards());
    }

    @Test
    public void dealCardToHandTest() {
        BlackJack game = new BlackJack(4);

        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        BlackJackPlayer player1 = new BlackJackPlayer("Apple");
        BlackJackPlayer player2 = new BlackJackPlayer("Banana");
        players.add(player1);
        players.add(player2);
        game.addPlayers(players);
        player1.setMoney(100.0);
        player2.setMoney(100.0);
        game.takeBet(player1, 100.0);
        game.takeBet(player2, 100.0);
        game.dealInitialCards();

        int numInitialCards = player1.getHand().numCards();
        game.dealCardToHand(player1);

        Assert.assertEquals(numInitialCards + 1, player1.getHand().numCards());

    }

    @Test
    public void putCardsInDiscardPileTest() {
        BlackJack game = new BlackJack(4);

        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        BlackJackPlayer player1 = new BlackJackPlayer("Apple");
        BlackJackPlayer player2 = new BlackJackPlayer("Banana");
        players.add(player1);
        players.add(player2);
        game.addPlayers(players);
        player1.setMoney(100.0);
        player2.setMoney(100.0);
        game.takeBet(player1, 100.0);
        game.takeBet(player2, 100.0);
        game.dealInitialCards();

        int numCards = player1.getHand().numCards() + player2.getHand().numCards() + game.getDealer().getHand().numCards();

        game.putCardsInDiscardPile();

        for(BlackJackPlayer player : game.getPlayers()) {
            Assert.assertEquals(0, player.getHand().numCards());
        }
        Assert.assertEquals(0, game.getDealer().getHand().numCards());

        Assert.assertEquals(numCards, game.getDiscardPile().numCards());
    }

    @Test
    public void shuffleCardsWhenStockIsEmptyTest() {
        BlackJack game = new BlackJack(4);

        game.discardCards(game.getStockPile());

        Assert.assertEquals(0, game.getStockPile().numCards());
        game.shuffleCardsWhenStockIsEmpty();
        Assert.assertEquals(208, game.getStockPile().numCards());
    }

    @Test
    public void calculatePlayerScoreTest() {
        BlackJack game = new BlackJack(4);

        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        BlackJackPlayer player1 = new BlackJackPlayer("Apple");
        BlackJackPlayer player2 = new BlackJackPlayer("Banana");
        players.add(player1);
        players.add(player2);
        game.addPlayers(players);

        Card aceOfSpades = new Card(ACE, SPADES);
        Card jackOfDiamonds = new Card(JACK, DIAMONDS);

        player1.addCardToHand(aceOfSpades);
        player1.addCardToHand(jackOfDiamonds);
    }
}
