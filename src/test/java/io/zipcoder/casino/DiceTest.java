package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {
    Dice dice = new Dice();
    @Test
    public void testRollDice(){
        int actual = dice.rollDice();
        Assert.assertNotEquals(0,actual);
    }
}
