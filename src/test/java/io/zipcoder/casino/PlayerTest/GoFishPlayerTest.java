package io.zipcoder.casino.PlayerTest;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
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
        GoFishPlayer goFishPlayer1 = new GoFishPlayer(player1);

        String actualName = goFishPlayer1.getName();

        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void constructorTestAge() {
        int expectedAge = 78;

        Player player1 = new Player("Phoebe", expectedAge);
        Player goFishPlayer1 = new GoFishPlayer(player1);

        int actualAge = goFishPlayer1.getAge();

        Assert.assertEquals(expectedAge, actualAge);
    }

    @Test
    public void getNumPairsTest() {
        Player player1 = new Player("Phoebe", 24);
        GoFishPlayer goFishPlayer1 = new GoFishPlayer(player1);

        int expected = 0;
        int actual = goFishPlayer1.getNumPairs();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void hasCardTest(){
        Player player1 = new Player("Sue", 89);
        GoFishPlayer goFishPlayer1 = new GoFishPlayer(player1);

        Card temp1 = new Card(Rank.ACE, Suit.HEARTS);
        goFishPlayer1.cardHand.add(temp1);

        Assert.assertTrue(goFishPlayer1.cardHand.contains(temp1));
    }
}
