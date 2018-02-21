package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DieTest {

    // If the die works properly, one of these tests will fail and the other 5 will pass

    private static Die die;

    @Before
    public void setup() {
        this.die = new Die();
        this.die.rollDie();
    }


    @Test
    public void getDieFace1Test() {
        Integer expected = 1;
        Integer actual = this.die.getDieFace();
        Assert.assertEquals("Some other face, some other place", expected, actual);
    }

    @Test
    public void getDieFace2Test() {
        Integer expected = 2;
        Integer actual = this.die.getDieFace();
        Assert.assertEquals("Some other face, some other place", expected, actual);
    }

    @Test
    public void getDieFace3Test() {
        Integer expected = 3;
        Integer actual = this.die.getDieFace();
        Assert.assertEquals("Some other face, some other place", expected, actual);
    }

    @Test
    public void getDieFace4Test() {
        Integer expected = 4;
        Integer actual = this.die.getDieFace();
        Assert.assertEquals("Some other face, some other place", expected, actual);
    }

    @Test
    public void getDieFace5Test() {
        Integer expected = 5;
        Integer actual = this.die.getDieFace();
        Assert.assertEquals("Some other face, some other place", expected, actual);
    }

    @Test
    public void getDieFace6Test() {
        Integer expected = 6;
        Integer actual = this.die.getDieFace();
        Assert.assertEquals("Some other face, some other place", expected, actual);
    }

}
