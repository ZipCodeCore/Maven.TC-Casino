package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InputOutputTest {
    InputOutput inputOutput;

    @Before
    public void setup(){
        inputOutput = new InputOutput();
    }

    @Test
    public void scanForStringTest(){
        String actual = inputOutput.scanForString();
        String expected = "f";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void scanForIntTest(){
        Integer actual = inputOutput.scanForInt();
        Integer expected = 5;
        Assert.assertEquals(expected, actual);
    }
}
