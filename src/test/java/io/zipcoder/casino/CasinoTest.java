package io.zipcoder.casino;


import org.junit.Assert;
import org.junit.Test;

public class CasinoTest {

    @Test
    public void CasinoConstructorTest() {
    }

    @Test
    public void getAnswerTest() {
        int expectedAnswer = 0;
        Casino casino = new Casino();

        int actual = casino.getAnswer();

        Assert.assertEquals(expectedAnswer, actual);
    }

    @Test
    public void mainMenuTest() {
    }

    @Test
    public void enterTest() {

        Casino casino = new Casino();

        String expected = ";Ceelo.start() = running;";

        String actual = casino.enter();

        Assert.assertEquals(expected, actual);
    }


}
