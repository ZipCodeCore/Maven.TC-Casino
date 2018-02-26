package io.zipcoder.casino.PlayerTest;

import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Rank;
import io.zipcoder.casino.GameTools.Deck.Suit;
import io.zipcoder.casino.Games.War;
import io.zipcoder.casino.Players.Player;
import io.zipcoder.casino.Players.WarPlayer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WarPlayerTest {
    War war;
    Player player;

    @Before
    public void setup(){
        player = new Player();
        war = new War(player);
    }

    @Test
    public void addToHandTest() {
        Card card1 = new Card(Rank.KING, Suit.DIAMOND);
        war.player1.currentHand.add(card1);

        Integer expected = 1;
        Integer actual = war.player1.currentHand.size();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setNameTest(){
        WarPlayer player = new WarPlayer();
        player.setName("Brian");

        String expected = "Brian";
        String actual = player.getName();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void setAge(){
        WarPlayer player = new WarPlayer();
        player.setAge(25);

        Integer expected = 25;
        Integer actual = player.getAge();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPointsTest() {
        WarPlayer player = new WarPlayer();
        player.addPoint(5);

        Integer expected = 5;
        Integer actual = player.getPoints();

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void addPointTest() {
        WarPlayer player = new WarPlayer();
        player.addPoint(100);
        Integer expected = 100;
        Integer actual = player.getPoints();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void resetPointsTest() {
        WarPlayer player = new WarPlayer();
        player.addPoint(100);

        player.resetPoints();
        Integer expected = 0;
        Integer actual = player.getPoints();

        Assert.assertEquals(expected, actual);


    }
}
