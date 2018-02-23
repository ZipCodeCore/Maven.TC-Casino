package io.zipcoder.casino.core;

import org.junit.Assert;
import org.junit.Test;

public class CasinoTest {

//    @Test
//    public void CasinoConstructorTest() {
//
//        String expectedPlayer = null;
//        Integer expectedAnswer= 0;
//
//        // When
//        Casino casino = new Casino();
//
//        // Then
//        String actualPlayer = player.get();
//        int actualAnswer = answer.getAnswer();
//
//        Assert.assertEquals(expectedPlayer, actualPlayer);
//        Assert.assertEquals(expectedAnswer, actualAnswer);
//    }

    @Test
    public void getAnswerTest() {
        int expectedAnswer = 0;
        Casino casino = new Casino();

        int actual = casino.getAnswer();

        Assert.assertEquals(expectedAnswer, actual);

    }

    @Test
    public void answerTest() {
    }

    @Test
    public void mainMenuTest() {
        //IO HANDLER!!!
    }

    @Test
    public void enterTest() {

    }


}
