package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Players.GoFishComputerPlayer;
import io.zipcoder.casino.Players.GoFishHumanPlayer;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Test;

public class GoFishTest {

    @Test
    public void dealTest() {
        Player player1 = new Player("Sally", 89);
        GoFishHumanPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        GoFish testGame = new GoFish(goFishPlayer1);
        testGame.deal();

        int expected = 5;
        int actual = goFishPlayer1.getCardHandSize();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void gameIsNotOverTest() {
        Player player1 = new Player("Sally", 89);
        GoFishHumanPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);
        GoFish testGame = new GoFish(goFishPlayer1);

        goFishPlayer1.addPair();
        goFishPlayer1.addPair();

        Boolean actual = testGame.gameIsNotOver();
        Assert.assertTrue(actual);
    }

    @Test
    public void getCurrentPlayerTest() {
        Player player1 = new Player("Sally", 89);
        GoFishHumanPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);
        GoFish testGame = new GoFish(goFishPlayer1);

        GoFishPlayer expected = goFishPlayer1;
        GoFishPlayer actual = testGame.getCurrentPlayer();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void fillPlayerHandsTest() {
        Player player1 = new Player("Sally", 89);
        GoFishHumanPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);
        GoFish testGame = new GoFish(goFishPlayer1);

        testGame.fillPlayerHands();
        int expected = 1;
        int actual = goFishPlayer1.getCardHandSize();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void determineWinnerTest() {
        Player player1 = new Player("Sally", 89);
        GoFishHumanPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);
        GoFishComputerPlayer goFishPlayer2 = new GoFishComputerPlayer("Bob");
        GoFish testGame = new GoFish(goFishPlayer1);

        goFishPlayer1.addPair();
        goFishPlayer1.addPair();
        goFishPlayer2.addPair();

        GoFishPlayer winner = testGame.determineWinner();

        String expected = "Sally";
        String actual = winner.getName();
    }
}
