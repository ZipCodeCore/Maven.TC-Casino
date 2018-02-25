package io.zipcoder.casino.games.roulette;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class RoulettePromptsTest {
    RoulettePrompts roulettePrompts = new RoulettePrompts();





    @Test
    public void startMessageTest1(){
        String input = "y";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals("y", roulettePrompts.startMessage());
    }

    @Test
    public void startMessageTest2(){
        String input = "r";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals("r", roulettePrompts.startMessage());
    }









    @Test
    public void rulesTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        roulettePrompts.rules();

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
                "place bets for the next spin.\n\n\n";

        Assert.assertEquals(expected, outputStream.toString());
    }












    @Test
    public void firstSetOfOptionsPromptTest1(){
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(1, roulettePrompts.firstSetOfOptionsPrompt(1));
    }

    @Test
    public void firstSetOfOptionsPromptTest2(){
        String input = "11";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(11, roulettePrompts.firstSetOfOptionsPrompt(54));
    }

    @Test
    public void firstSetOfOptionsPromptTest3(){
        String input = "8";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Assert.assertEquals(8, roulettePrompts.firstSetOfOptionsPrompt(31));
    }









    @Test
    public void bettingInfoTest(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        roulettePrompts.bettingInfo();

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
                "\t- line bet (6 numbers/2 rows) wins 5 to 1\n\n";

        Assert.assertEquals(expected, outputStream.toString());
    }











    @Test
    public void singleNumberPromptTest1(){
        String input = "37";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ArrayList<Integer> expected = new ArrayList<Integer>(){};

        Assert.assertEquals(expected, roulettePrompts.singleNumberPrompt());
    }

    @Test
    public void singleNumberPromptTest2(){
        Integer expected = 1;

        Assert.assertEquals(expected, roulettePrompts.singleNumberPromptAddArrayListEntry(1));
    }












    @Test
    public void onTheLineTest1(){
        int input = 2;

        Integer[] expected = {2,3};

        Assert.assertEquals(expected, roulettePrompts.returnDoubleNumberArray(input));
    }

    @Test
    public void onTheLineTest2(){
        int input = 19;

        Integer[] expected = {19,20};

        Assert.assertEquals(expected, roulettePrompts.returnDoubleNumberArray(input));
    }
    @Test
    public void onTheLineTest3(){
        String input = "16";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] expected = {16, 17};

        Assert.assertEquals(expected, roulettePrompts.onTheLine());
    }










    @Test
    public void cornerTest1(){
        String input = "17";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] expected = {17, 18, 20, 21};

        Assert.assertEquals(expected, roulettePrompts.corner());
    }

    @Test
    public void cornerTest2(){
        String input = "4";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] expected = {4, 5, 7, 8};

        Assert.assertEquals(expected, roulettePrompts.corner());
    }







    @Test
    public void straightTest1(){
        String input = "1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Integer[] expected = {1, 2, 3};

        Assert.assertEquals(expected, roulettePrompts.straight());
    }
}
