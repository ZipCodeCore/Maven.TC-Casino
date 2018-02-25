package io.zipcoder.casino.Games;

import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Players.WarPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WarTest {

    private War war;
    private Deck warDeck;
    private WarPlayer warPlayer1;
    private WarPlayer warPlayer2;

    @Before
    public void setup() {
        war = new War();
        warDeck = new Deck();
        warPlayer1 = new WarPlayer();
        warPlayer2 = new WarPlayer();
    }

    @Test
    public void dealTest() {
        war.deal();
        int actual = warPlayer1.currentHand.size();
        int expected = 26;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void compareTest() {


    }

    @Test
    public void awardPointsToWinner() {

    }

    @Test
    public void compareRankAndSuits() {

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
