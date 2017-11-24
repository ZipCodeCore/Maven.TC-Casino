package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValueTest {

    @Test
    public void toStringTest(){
        String expected = "";
        String actual = Value.EIGHT.toString();

        Assert.assertEquals(expected, actual);
    }

}