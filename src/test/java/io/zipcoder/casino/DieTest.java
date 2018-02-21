package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DieTest {

    private static Die die;

    @Before
    public void setup() {
        this.die = new Die();
        die.rollDie();
    }

    @Test
    public void getDieFaceTest() {
        Integer actual = this.die.getDieFace().toInt();
        Assert.assertTrue(1 <= actual && actual <= 6);
    }

    @Test
    public void setDieFaceTest() {
        this.die.setDieFace(1);
        int expected = 1;
        int actual = this.die.getDieFace().toInt();
        Assert.assertEquals(expected, actual);
    }

}
