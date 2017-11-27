package io.zipcoder.casino;

import org.junit.Test;

import static io.zipcoder.casino.MathUtils.isInRange;
import static org.junit.Assert.assertTrue;

public class DiceTest {

    @Test
    public void rollResultShouldBeBetween1and6test() throws Exception {
        int min = 1;
        int max = 6;
        Dice dice1 = new Dice(min, max);
        assertTrue(isInRange(dice1.roll(), min, max));
    }
}