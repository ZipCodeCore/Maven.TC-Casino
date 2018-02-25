package io.zipcoder.casino.core;

import io.zipcoder.casino.utils.IOHandler;

import org.junit.Assert;
import org.junit.Test;

public class CasinoTest {

    @Test
    public void gameLobbyMenu(){

        String expected = "**** WELCOME TO HIGH ROLLERS CLUB ****\n" +
                "*                                    *\n" +
                "**************************************\n" +
                "*                                    *\n" +
                "*       Please choose a game:        *\n" +
                "*       1. Black Jack                *\n" +
                "*       2. Crazy Eights              *\n" +
                "*       3. CeeLo                     *\n" +
                "*       4. Roulette                  *\n" +
                "*                                    *\n" +
                "*       PRESS 5 TO EXIT              *\n" +
                "*                                    *\n" +
                "**************************************\n";

        String actual = IOHandler.getMessageFromFile("CasinoWelcomeMenu.txt");

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void enterTest() {
        Casino casino = new Casino();
    }

    @Test
    public void handleInputTestBJ() {
        //Given
        Casino casino = new Casino();

        int actual = 1;
        int expected = casino.handleInput(1);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void handleInputTestCrazy8() {
        //Given
        Casino casino = new Casino();

        int actual = 2;
        int expected = casino.handleInput(2);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void handleInputTestCeeLo() {
        //Given
        Casino casino = new Casino();

        int actual = 3;
        int expected = casino.handleInput(3);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void handleInputTestRoulette() {
        //Given
        Casino casino = new Casino();

        int actual = 4;
        int expected = casino.handleInput(4);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void handleInputTestExit() {
        //Given
        Casino casino = new Casino();

        int actual = 5;
        int expected = casino.handleInput(5);

        Assert.assertEquals(actual, expected);
    }

    @Test
    public void changeGameStateTest() {
        Casino casino = new Casino();
    }
    @Test
    public void welcomeScreenTest() {

        String expected = "**** WELCOME TO HIGH ROLLERS CLUB ****\n" +
                "*                                    *\n" +
                "**************************************\n" +
                "*                                    *\n" +
                "*       Please choose a game:        *\n" +
                "*       1. Black Jack                *\n" +
                "*       2. Crazy Eights              *\n" +
                "*       3. CeeLo                     *\n" +
                "*       4. Roulette                  *\n" +
                "*                                    *\n" +
                "*       PRESS 5 TO EXIT              *\n" +
                "*                                    *\n" +
                "**************************************\n";

        String actual = IOHandler.getMessageFromFile("CasinoWelcomeMenu.txt");

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void goodByeTest(){
        Casino casino = new Casino();

        String expected = "******** THANKS FOR PLAYING!! ********\n" +
                "*************  GOODBYE!  *************\n";
        String actual = IOHandler.getMessageFromFile("GoodBye.txt");

        Assert.assertEquals(expected, actual);
    }
}
