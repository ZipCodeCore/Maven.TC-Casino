package io.zipcoder.casino.games.roulette;

import io.zipcoder.casino.core.Player;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

public class RouletteTest {
    Player player = new Player();
    Roulette roulette = new Roulette();


    @Test
    public void mainLoopTest1() {
        String input = "q";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        String expected = "\n\n" +
                "\n" +
                "\n" +
                "*******************************************************\n" +
                "*          This is the table for high roller          *\n" +
                "*          Indulgence here at our casino.             *\n" +
                "*           Roulette is a casino game named           *\n" +
                "*          after the French word meaning              *\n" +
                "*          little wheel. In the game, players         *\n" +
                "*          may choose to place bets on either         *\n" +
                "*           a single number, various groupings        *\n" +
                "*           of numbers, the colors red or             *\n" +
                "*           black, whether the number is odd          *\n" +
                "*           or even, or if the numbers are            *\n" +
                "*           high (19–36) or low (1–18).               *\n" +
                "*******************************************************\n" +
                "\n" +
                "*             Press 'y' to place your bets            *\n" +
                "*                  Press 'q' to quit                  *\n" +
                "*                 Press 'r' for rules                 *\n" +
                "*              Press 'b' for betting info             *\n" +
                "\n" +
                "*******************************************************\n" +
                "\n";
        try {
            roulette.mainLoop();
        } catch (InterruptedException e) {
        }
        Assert.assertEquals(expected, outputStream.toString());
    }

    @Test
    public void mainLoopTest2() {
        String input = "r";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = true;
        try {
            try {
                roulette.mainLoop();
            } catch (NoSuchElementException e) {
                actual = false;
            }
        } catch (InterruptedException e) {
        }

        Assert.assertFalse(actual);
    }

    @Test
    public void mainLoopTest3() {
        String input = "b";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = true;
        try {
            try {
                roulette.mainLoop();
            } catch (NoSuchElementException e) {
                actual = false;
            }
        } catch (InterruptedException e) {
        }

        Assert.assertFalse(actual);
    }

    @Test
    public void mainLoopTest4() {
        String input = "x";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = true;
        try {
            try {
                roulette.mainLoop();
            } catch (NoSuchElementException e) {
                actual = false;
            }
        } catch (InterruptedException e) {
        }

        Assert.assertFalse(actual);
    }

    @Test
    public void letsPlayTest1() {
        String input = "16";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = true;
        try {
            try {
                roulette.mainLoop();
            } catch (NoSuchElementException e) {
                actual = false;
            }
        } catch (InterruptedException e) {
        }

        Assert.assertFalse(actual);
    }

    @Test
    public void letsPLayTest2() {
        String input = "17";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = true;
        try {
            try {
                roulette.mainLoop();
            } catch (NoSuchElementException e) {
                actual = false;
            }
        } catch (InterruptedException e) {
        }

        Assert.assertFalse(actual);
    }

    @Test
    public void letsPlayTest3() {
        String input = "18";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = true;
        try {
            try {
                roulette.mainLoop();
            } catch (NoSuchElementException e) {
                actual = false;
            }
        } catch (InterruptedException e) {
        }

        Assert.assertFalse(actual);
    }

    @Test
    public void selectionTest() {
        String input = "18";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int selection = 1;
        boolean actual = true;
        try {
            roulette.selectionOptions(selection);
        } catch (NoSuchElementException e) {
            actual = false;
        }

        Assert.assertTrue(actual);
    }


    @Test
    public void welcomeMessageTest1() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = true;
        try {
            roulette.runWelcome();
        } catch (NoSuchElementException e) {
            actual = false;
        }

        Assert.assertTrue(actual);
    }

    @Test
    public void welcomeMessageTest2() {
        String input = "x";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        boolean actual = true;
        try {
            roulette.runWelcome();
        } catch (NoSuchElementException e) {
            actual = false;
        }

        Assert.assertFalse(actual);
    }


    @Test
    public void calculateWinnersAndEarningsTest() {

        Integer beforeBalance = player.getBalance().intValue();
        try {
            roulette.calculateWinnersAndEarnings();
        } catch (InterruptedException e) {
        }
        Integer afterBalance = player.getBalance().intValue();

        Assert.assertTrue(beforeBalance <= afterBalance);
    }

    @Test
    public void displayBoardTest() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        roulette.displayBoard();

        String expected = "----------------\n" +
                "| 1  | 2  | 3  |\n" +
                "----------------\n" +
                "| 4  | 5  | 6  |\n" +
                "----------------\n" +
                "| 7  | 8  | 9  |\n" +
                "----------------\n" +
                "| 10 | 11 | 12 |\n" +
                "----------------\n" +
                "| 13 | 14 | 15 |\n" +
                "----------------\n" +
                "| 16 | 17 | 18 |\n" +
                "----------------\n" +
                "| 19 | 20 | 21 |\n" +
                "----------------\n" +
                "| 22 | 23 | 24 |\n" +
                "----------------\n" +
                "| 25 | 26 | 27 |\n" +
                "----------------\n" +
                "| 28 | 29 | 30 |\n" +
                "----------------\n" +
                "| 31 | 32 | 33 |\n" +
                "----------------\n" +
                "| 34 | 35 | 36 |\n" +
                "----------------\n\n";

        Assert.assertEquals(expected, outputStream.toString());
    }

    @Test
    public void cTest1() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulette.pressCtoContinue();
        } catch (NoSuchElementException e) {
            actual = false;
        }

        Assert.assertTrue(actual);
    }

    @Test
    public void cTest2() {
        String input = "x";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulette.pressCtoContinue();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }

    @Test
    public void clearTest() {
        String input = "18";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int selection = 1;
        roulette.selectionOptions(selection);

        roulette.clearNumberArraysAndBettingMap();
        Assert.assertTrue(roulette.singleNumberSelection.isEmpty());
        Assert.assertTrue(roulette.bettingMap.isEmpty());
    }
}
