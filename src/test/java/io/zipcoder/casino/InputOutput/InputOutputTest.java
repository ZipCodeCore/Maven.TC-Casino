package io.zipcoder.casino.InputOutput;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

//these hang on runtime, dont work. kris says dont test so :/
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
