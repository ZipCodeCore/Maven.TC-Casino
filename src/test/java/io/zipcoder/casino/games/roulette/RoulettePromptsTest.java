package io.zipcoder.casino.games.roulette;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;

public class RoulettePromptsTest {
    RoulettePrompts roulettePrompts = new RoulettePrompts();


    @Test
    public void startMessageTest1() {
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals("y", roulettePrompts.startMessage());
    }

    @Test
    public void startMessageTest2() {
        String input = "r";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals("r", roulettePrompts.startMessage());
    }


    @Test
    public void rulesTest() {
        String actual = roulettePrompts.rules();

        String expected = "************************RULES**********************\n" +
                "\n" +
                "Roulette is a game played with a large wheel that \n" +
                "contains 38 pockets. These stops are numbered \n" +
                "from 0 to 36, while the American roulette wheel also \n" +
                "contains a 00 pocket. All the pockets are all \n" +
                "colored; the zeroes are green, while the other spots \n" +
                "are evenly divided between 18 red and 18 black \n" +
                "pockets.\n" +
                "\n" +
                "The croupier (or dealer) spins a ball on the outer \n" +
                "rim of the wheel, after which it will eventually \n" +
                "fall into one of the numbered spaces. The object for \n" +
                "the player is to guess what number the ball will \n" +
                "land in.\n" +
                "\n" +
                "Before each spin, players have the opportunity to \n" +
                "place bets around the roulette table. Players can \n" +
                "bet on individual numbers or virtually any \n" +
                "combination of numbers – most of the available bets \n" +
                "are outlined below.\n" +
                "\n" +
                "In a live casino each player will have to exchange \n" +
                "cash or casino chips for special roulette chips, \n" +
                "with each player being given a unique color that can \n" +
                "be used to distinguish who made each bet. Of course, \n" +
                "in computer casino (this one), this isn’t necessary.\n" +
                "\n" +
                "Once the ball falls into a pocket and rests there, \n" +
                "the croupier will call out the winning number as \n" +
                "well as the color of the pocket it landed in. \n" +
                "Markers are typically used to protect winning bets, \n" +
                "after which all losing bets are swept off the table. \n" +
                "Then the croupier will pay all winning bets and, \n" +
                "once all of the payouts are completed, players may \n" +
                "place bets for the next spin.\n\n";

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void firstSetOfOptionsPromptTest1() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(1, roulettePrompts.firstSetOfOptionsPrompt(1));
    }

    @Test
    public void firstSetOfOptionsPromptTest2() {
        String input = "11";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(11, roulettePrompts.firstSetOfOptionsPrompt(54));
    }

    @Test
    public void firstSetOfOptionsPromptTest3() {
        String input = "8";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(8, roulettePrompts.firstSetOfOptionsPrompt(31));
    }


    @Test
    public void bettingInfoTest() {
        String actual = roulettePrompts.bettingInfo();
        String expected = "***************** BETTING INFO *********************\n" +
                "- Black, Red, 1-8, 19-36, Odd, and Even spaces payout evenly (1 to 1)\n" +
                "- 1st 12, 2nd 12, and 3rd 12 payout 2 to 1\n" +
                "- column wins pay 2 to 1 as well\n" +
                "- Inside part of board:\n" +
                "\t- single number win pays out 35 to 1\n" +
                "\t- on the line (the two numbers on both sides of the line) wins 17 to 1 \n" +
                "\t- Straight (the whole row of three numbers) wins 11 to 1\n" +
                "\t- Basket (0, 00, and 2) wins 11 to 1\n" +
                "\t- Corner (4 numbers) wins 8 to 1\n" +
                "\t- 5 number bet ( 0, 00, 1, 2, 3) wins 6 to 1\n" +
                "\t- line bet (6 numbers/2 rows) wins 5 to 1\n";

        Assert.assertEquals(expected, actual);
    }


    @Test
    public void singleNumberPromptTest1() {
        String input = "37";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(null, roulettePrompts.singleNumberPrompt());
    }

    @Test
    public void singleNumberPromptTest2() {
        String input = "14";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Integer expected = 14;

        Assert.assertEquals(expected, roulettePrompts.singleNumberPrompt());
    }


    @Test
    public void onTheLineTest1() {
        int input = 2;

        Integer[] expected = {2, 3};

        Assert.assertEquals(expected, roulettePrompts.returnDoubleNumberArray(input));
    }

    @Test
    public void onTheLineTest2() {
        int input = 19;

        Integer[] expected = {19, 20};

        Assert.assertEquals(expected, roulettePrompts.returnDoubleNumberArray(input));
    }

    @Test
    public void onTheLineTest3() {
        String input = "36";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.onTheLine();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }
    @Test
    public void onTheLineTest4() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.onTheLine();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void cornerTest1() {
        String input = "17";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] expected = {17, 18, 20, 21};

        Assert.assertEquals(expected, roulettePrompts.corner());
    }

    @Test
    public void cornerTest2() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] expected = {4, 5, 7, 8};

        Assert.assertEquals(expected, roulettePrompts.corner());
    }
    @Test
    public void cornerTest3() {
        String input = "36";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.corner();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }
    @Test
    public void cornerTest4() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.corner();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void straightTest1() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] expected = {1, 2, 3};

        Assert.assertEquals(expected, roulettePrompts.straight());
    }

    @Test
    public void straightTest2() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] expected = {4, 5, 6};

        Assert.assertEquals(expected, roulettePrompts.straight());
    }
    @Test
    public void straightTest3() {
        String input = "36";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.straight();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }
    @Test
    public void straightTest4() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.straight();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }
    @Test
    public void straightTest5() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.straight();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void basketTest() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] basket = {0, 00, 2};

        Assert.assertEquals(basket, roulettePrompts.basket());
    }


    @Test
    public void fiveNumberBetTest() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] basket = {0, 00, 1, 2, 3};

        Assert.assertEquals(basket, roulettePrompts.fiveNumberBet());
    }


    @Test
    public void lineBetTest1() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.lineBet();
        Integer[] expected = {4, 5, 6, 7, 8, 9};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void lineBetTest2() {
        String input = "13";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.lineBet();
        Integer[] expected = {13, 14, 15, 16, 17, 18};

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void lineTest3() {
        String input = "36";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.lineBet();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }
    @Test
    public void lineTest4() {
        String input = "2";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.lineBet();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }
    @Test
    public void lineTest5() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.lineBet();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }



    @Test
    public void columnBetTest1() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.columnBet();
        Integer[] expected = {1, 4, 7, 10, 13, 16, 19, 22, 25, 28, 31, 34};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void columnBetTest2() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.columnBet();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void twelveBetTest1() {
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.twelveNumberBet();
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void twelveBetTest2() {
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.twelveNumberBet();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void numbers1Thru18BetTest1() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.numbers1Thru18();
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numbers1Thru18BetTest2() {
        String input = "f";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.numbers1Thru18();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void numbers19Thru36BetTest1() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.numbers19thru36();
        Integer[] expected = {19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void numbers19Thru36BetTest2() {
        String input = "f";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.numbers19thru36();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void evenNumbersTest1() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.evenNumbers();
        Integer[] expected = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void evenNumbersTest2() {
        String input = "f";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.evenNumbers();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void oddNumbersTest1() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.oddNumbers();
        Integer[] expected = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void oddNumbersTest2() {
        String input = "f";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.oddNumbers();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void blackNumbersTest1() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.blackNumbers();
        Integer[] expected = {2, 4, 6, 8, 10, 11, 13, 15, 17, 20, 22, 24, 26, 28, 29, 31, 33, 35};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void blackNumbersTest2() {
        String input = "f";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.blackNumbers();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }

    @Test
    public void redNumbersTest1() {
        String input = "c";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] actual = roulettePrompts.redNumbers();
        Integer[] expected = {1, 3, 5, 7, 9, 12, 14, 16, 18, 19, 21, 23, 25, 27, 30, 32, 34, 36};

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void redNumbersTest2() {
        String input = "f";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        boolean actual = true;
        try {
            roulettePrompts.redNumbers();
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }


    @Test
    public void cTest1() {
        boolean actual = true;
        try {
            roulettePrompts.whereYouGetStuckForJustNotPressingC("c", "hi");
        } catch (NoSuchElementException e) {
            actual = false;
        }

        Assert.assertTrue(actual);
    }

    @Test
    public void cTest2() {
        boolean actual = true;
        try {
            roulettePrompts.whereYouGetStuckForJustNotPressingC("f", "hi");
        } catch (NoSuchElementException e) {
            actual = false;
        }


        Assert.assertFalse(actual);
    }
}
