package io.zipcoder.casino.PlayerTest;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Players.GoFishComputerPlayer;
import io.zipcoder.casino.Players.GoFishHumanPlayer;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.Players.Player;
import org.junit.Assert;
import org.junit.Test;


public class GoFishComputerPlayerTest {

    @Test
    public void constructorTest() {
        GoFishComputerPlayer player1 = new GoFishComputerPlayer("Bob");

        String expected = "Bob";
        String actual = player1.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getNumPairsTest() {
        GoFishComputerPlayer player1 = new GoFishComputerPlayer("Bob");

        int expected = 0;
        int actual = player1.getNumPairs();

        Assert.assertEquals(expected, actual);
    }
}
