package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CardGameTest {

    @Test
    public void drawFromStockTest() {
        GoFish game = new GoFish();
        Card card = game.drawFromStock();

        Assert.assertTrue(card instanceof Card);
    }
}
