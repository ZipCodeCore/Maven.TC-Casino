package io.zipcoder.casino.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/22/18
 */
public class IOHandlerTest {

    @Test
    public void testReadFromNonExistentFile() {
        String expected = "[file not found]";
        String pathString = "pathToNothing.txt";
        String actual = IOHandler.getMessageFromFile(pathString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testReadFromExistingFile() {
        String expected = "This file exists, I created it in vim";
        String pathString = "testReadExisting.txt";
        String actual = IOHandler.getMessageFromFile(pathString);

        Assert.assertEquals(expected, actual);
    }
}
