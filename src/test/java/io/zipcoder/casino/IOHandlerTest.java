package io.zipcoder.casino;

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
    public void testWriteToNewFile() {
        String newPathString = "testWriteToNewFile.txt";
        String expected = "It's time to party";
        String writeMessage = expected;
        IOHandler.writeMessageToFile(newPathString, writeMessage);
        String actual = IOHandler.getMessageFromFile(newPathString);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteToExistingFile() {
        String existingPathString = "testWriteExisting.txt";
        String addString = "\nAppend this line";
        String expected = "This line is first\nThis line is second\nAppend this line";
        IOHandler.writeMessageToFile(existingPathString, addString);
        String actual = IOHandler.getMessageFromFile(existingPathString);

        Assert.assertEquals(expected, actual);
    }

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
