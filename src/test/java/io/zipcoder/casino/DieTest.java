package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DieTest {

    Die d6;

    @Before
    public void setup() {
        d6 = new Die();
    }

    @Test
    public void getValue() throws Exception {
        int expected = 0;
        int actual = d6.getValue();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollDie() throws Exception {

        d6.rollDie();
        double expected = 3d;
        double actual = d6.getValue();

        Assert.assertEquals(expected, actual, 3);
    }
}