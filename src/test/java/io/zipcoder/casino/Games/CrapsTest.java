package io.zipcoder.casino.Games;


import io.zipcoder.casino.Players.Player;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrapsTest {
    Craps game;
    Integer dieValue = 7;
    Player bob = new Player("Bob", 30, 500);


    @Before
    public void setup() {
        game = new Craps(bob);
    }

    @Test
    public void setPlayerBetAmountTest() {
        Integer expected = 500;

        game.setPlayerBetAmount(expected);
        Integer actual = game.getPlayerBetAmount();

        Assert.assertEquals(expected, actual);
    }

}
