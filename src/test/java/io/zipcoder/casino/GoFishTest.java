package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class GoFishTest {

    @Test
    public void testConstructor() {
        GoFish game = new GoFish();

        Assert.assertEquals(52, game.getStockPile().numCards());
    }
}
