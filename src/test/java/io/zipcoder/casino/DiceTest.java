package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

    @Test
    public void testConstructor() {
        Dice dice = new Dice(2);

        for(Dice.Die die : dice.getDice()) {
            Assert.assertTrue(die.getValue() >= 1 && die.getValue() <= 6);
        }
    }
}
