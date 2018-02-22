package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DieFaceTest {

    @Test
    public void equalsFaceValueTest1() {
        DieFace one = DieFace.ONE;
        Assert.assertTrue(one.equalsFaceValue(1));
    }

    @Test
    public void equalsFaceValueTest2() {
        DieFace two = DieFace.TWO;
        Assert.assertTrue(two.equalsFaceValue(2));
    }

    @Test
    public void toIntTest1() {
        DieFace one = DieFace.ONE;
        int expected = 1;
        int actual = one.toInt();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void toIntTest2() {
        DieFace two = DieFace.TWO;
        int expected = 2;
        int actual = two.toInt();
        Assert.assertEquals(expected, actual);
    }

}
