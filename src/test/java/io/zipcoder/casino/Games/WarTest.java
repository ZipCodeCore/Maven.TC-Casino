package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.Players.WarPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WarTest {

    Player player = new Player("Brian", 30, 1000);
    WarPlayer warPlayer;
    WarPlayer warPlayer2;
    War war;

    @Before
    public void setup() {
        warPlayer = new WarPlayer(player);
        warPlayer2 = new WarPlayer("Computer", 25);
        war = new War(player);
    }

    @Test
    public void dealTest() {
        war.deal();
        Integer actual = war.player1.currentHand.size();
        Integer expected = 26;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTest() {
        Card card1 = new Card(Rank.SEVEN, Suit.CLUBS);
        Card card2 = new Card(Rank.FIVE, Suit.DIAMOND);

        war.player1.currentHand.add(card1);
        war.compareCards(war.player1.currentHand.get(0), card2);

        Integer expected = 2;
        Integer actual = war.player1.getPoints();
        Assert.assertEquals(expected, actual);

    }

    @Test
    public void awardPointsToWinnerTest() {
        war.player1.addPoint(1);
        Integer expected = 1;
        Integer actual = war.player1.getPoints();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayWinnerTest() {
        war.player1.addPoint(100);
        war.player2.resetPoints();

        String expected = "Winner is " + war.player1.getName();
        String actual = war.highestPoints();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void displayLogo() {
        String expected = ("\n\nWELCOME TO" + "\n" +
                "\n" +
                "                          \n" +
                "██╗    ██╗ █████╗ ██████╗ \n" +
                "██║    ██║██╔══██╗██╔══██╗\n" +
                "██║ █╗ ██║███████║██████╔╝\n" +
                "██║███╗██║██╔══██║██╔══██╗\n" +
                "╚███╔███╔╝██║  ██║██║  ██║\n" +
                " ╚══╝╚══╝ ╚═╝  ╚═╝╚═╝  ╚═╝\n" +
                "                          \n");
        String actual = war.displayLogo();
        Assert.assertEquals(expected, actual);
    }

}
