package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static io.zipcoder.casino.Card.FaceValue.ACE;
import static io.zipcoder.casino.Card.FaceValue.FIVE;
import static io.zipcoder.casino.Card.FaceValue.JACK;
import static io.zipcoder.casino.Card.Suit.CLUBS;
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
        Card fiveOfClubs = new Card(FIVE, CLUBS);

        player1.addCardToHand(aceOfSpades);
        player1.addCardToHand(jackOfDiamonds);

        Assert.assertEquals(Integer.valueOf(21), game.calculatePlayerScore(player1));

        player2.addCardToHand(aceOfSpades);
        player2.addCardToHand(jackOfDiamonds);
        player2.addCardToHand(jackOfDiamonds);
        player2.addCardToHand(fiveOfClubs);

        Assert.assertEquals(Integer.valueOf(26), game.calculatePlayerScore(player2));
    }

    @Test
    public void playerHasBustTest() {
        BlackJack game = new BlackJack(4);

        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        BlackJackPlayer player1 = new BlackJackPlayer("Apple");
        BlackJackPlayer player2 = new BlackJackPlayer("Banana");
        players.add(player1);
        players.add(player2);
        game.addPlayers(players);

        Card aceOfSpades = new Card(ACE, SPADES);
        Card jackOfDiamonds = new Card(JACK, DIAMONDS);
        Card fiveOfClubs = new Card(FIVE, CLUBS);

        player1.addCardToHand(jackOfDiamonds);
        player1.addCardToHand(jackOfDiamonds);
        player1.addCardToHand(fiveOfClubs);

        Assert.assertTrue(game.playerHasBust(player1));
    }

    @Test
    public void determineWinnersTest() {
        BlackJack game = new BlackJack(4);

        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        BlackJackPlayer player1 = new BlackJackPlayer("Apple");
        BlackJackPlayer player2 = new BlackJackPlayer("Banana");
        BlackJackPlayer player3 = new BlackJackPlayer("Crouton");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game.addPlayers(players);

        player1.setMoney(100.0);
        player2.setMoney(100.0);
        player3.setMoney(100.0);
        game.takeBet(player1, 100.0);
        game.takeBet(player2, 100.0);
        game.takeBet(player3, 100.0);

        Card aceOfSpades = new Card(ACE, SPADES);
        Card jackOfDiamonds = new Card(JACK, DIAMONDS);
        Card fiveOfClubs = new Card(FIVE, CLUBS);

        game.getDealer().addCardToHand(jackOfDiamonds);
        game.getDealer().addCardToHand(jackOfDiamonds);

        player1.addCardToHand(aceOfSpades);
        player1.addCardToHand(jackOfDiamonds);

        player2.addCardToHand(aceOfSpades);
        player2.addCardToHand(jackOfDiamonds);
        player2.addCardToHand(jackOfDiamonds);
        player2.addCardToHand(fiveOfClubs);

        player3.addCardToHand(fiveOfClubs);
        player3.addCardToHand(fiveOfClubs);
        player3.addCardToHand(fiveOfClubs);
        player3.addCardToHand(fiveOfClubs);

        game.determineWinners();

        Assert.assertEquals(player1, game.getWinners().get(0));
        Assert.assertEquals(player3, game.getPush().get(0));
    }

    @Test
    public void payOutBetsTest() {
        BlackJack game = new BlackJack(4);

        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        BlackJackPlayer player1 = new BlackJackPlayer("Apple");
        BlackJackPlayer player2 = new BlackJackPlayer("Banana");
        BlackJackPlayer player3 = new BlackJackPlayer("Crouton");
        players.add(player1);
        players.add(player2);
        players.add(player3);
        game.addPlayers(players);

        player1.setMoney(100.0);
        player2.setMoney(100.0);
        player3.setMoney(100.0);
        game.takeBet(player1, 100.0);
        game.takeBet(player2, 100.0);
        game.takeBet(player3, 100.0);

        Card aceOfSpades = new Card(ACE, SPADES);
        Card jackOfDiamonds = new Card(JACK, DIAMONDS);
        Card fiveOfClubs = new Card(FIVE, CLUBS);

        game.getDealer().addCardToHand(jackOfDiamonds);
        game.getDealer().addCardToHand(jackOfDiamonds);

        player1.addCardToHand(aceOfSpades);
        player1.addCardToHand(jackOfDiamonds);

        player2.addCardToHand(aceOfSpades);
        player2.addCardToHand(jackOfDiamonds);
        player2.addCardToHand(jackOfDiamonds);
        player2.addCardToHand(fiveOfClubs);

        player3.addCardToHand(fiveOfClubs);
        player3.addCardToHand(fiveOfClubs);
        player3.addCardToHand(fiveOfClubs);
        player3.addCardToHand(fiveOfClubs);

        game.determineWinners();

        game.payOutBets();

        Assert.assertEquals(Double.valueOf(200), player1.getMoney());
        Assert.assertEquals(Double.valueOf(0), player2.getMoney());
        Assert.assertEquals(Double.valueOf(100), player3.getMoney());
    }
}
