package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.AbstractList;
import java.util.ArrayList;

public class GameTest {

    Game game = new Game();

    @Test
    public void addPlayerTest() {

        Player raul = new Player();
        game.addPlayer(raul);
        int expected = 1;
        int actual = game.getPlayers().size();
        Assert.assertEquals(actual, expected);

    }
}
