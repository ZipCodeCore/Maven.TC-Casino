package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DieTest {

    private static Die die;

    @Before
    public void setup() {
        this.die = new Die();
        this.die.rollDie();
    }


    @Test
    public void getDieFaceTest() {
        Integer actual = this.die.getDieFace();
        Assert.assertTrue(1 <= actual && actual <= 6);
    }

}
