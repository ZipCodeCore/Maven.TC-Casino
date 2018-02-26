package io.zipcoder.casino.PlayerTest;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Players.GoFishHumanPlayer;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static io.zipcoder.casino.GameTools.Deck.Rank.ACE;
import static io.zipcoder.casino.GameTools.Deck.Suit.HEARTS;


public class GoFishPlayerTest {

    @Test
    public void constructorTestName() {
        String expectedName = "Bob";

        Player player1 = new Player(expectedName, 34);
        GoFishPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        String actualName = goFishPlayer1.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void constructorTestAge() {
        int expectedAge = 78;

        Player player1 = new Player("Phoebe", expectedAge);
        Player goFishPlayer1 = new GoFishHumanPlayer(player1);

        int actualAge = goFishPlayer1.getAge();

        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void addPairTest() {
        Player player1 = new Player("Phoebe", 24);
        GoFishPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        int expected = 1;
        goFishPlayer1.addPair();
        int actual = goFishPlayer1.getNumPairs();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showCardsTest() {
        Player player1 = new Player("Sue", 89);
        GoFishPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        Card temp1 = new Card(Rank.ACE, Suit.HEARTS);
        goFishPlayer1.addCardToHand(temp1);

        String expected = "\n1: ACE of HEARTS\n";
        String actual = goFishPlayer1.showCards();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void showOpponentsTest() {
        List<GoFishPlayer> opponents = new ArrayList<>();

        Player player1 = new Player("Sue", 89);
        GoFishPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        GoFishPlayer goFishPlayer2 = new GoFishHumanPlayer(new Player("Bob", 45));

        opponents.add(goFishPlayer1);
        opponents.add(goFishPlayer2);

        String expected = "1: Sue\n2: Bob\n";
        String actual = goFishPlayer1.showOpponents(opponents);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeCardTest() {
        Player player1 = new Player("Sue", 89);
        GoFishPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        Card temp1 = new Card(Rank.ACE, Suit.HEARTS);
        goFishPlayer1.removeCard(temp1);

        int expected = 0;
        int actual = goFishPlayer1.getCardHandSize();

        Assert.assertEquals(expected, actual);
    }



    @Test
    public void getNumPairsTest() {
        Player player1 = new Player("Phoebe", 24);
        GoFishPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        int expected = 0;
        int actual = goFishPlayer1.getNumPairs();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasCardTest(){
        Player player1 = new Player("Sue", 89);
        GoFishPlayer goFishPlayer1 = new GoFishHumanPlayer(player1);

        Card temp1 = new Card(Rank.ACE, Suit.HEARTS);
        goFishPlayer1.addCardToHand(temp1);

        Assert.assertTrue(goFishPlayer1.hasCard(temp1));
    }
}
