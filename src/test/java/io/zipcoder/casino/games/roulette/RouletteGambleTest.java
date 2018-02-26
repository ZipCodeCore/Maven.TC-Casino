package io.zipcoder.casino.games.roulette;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RouletteGambleTest {
    RouletteGamble rouletteGamble = new RouletteGamble();
    protected HashMap<String, ArrayList<Integer>> bettingMap = new HashMap<>();
    protected ArrayList<Integer> singleNumberSelection = new ArrayList<>();
    protected ArrayList<Integer> doubleNumberSelection = new ArrayList<>();

    @Test
    public void winTest1(){
        Integer[] input = {1,10,11};
        singleNumberSelection.addAll(Arrays.asList(input));
        bettingMap.put("Single Number", singleNumberSelection);
        Integer actual = rouletteGamble.win(bettingMap, 10);
        Integer expected = 360;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void winTest2(){
        Integer[] input = {1,10,11};
        singleNumberSelection.addAll(Arrays.asList(input));
        bettingMap.put("Single Number", singleNumberSelection);
        Integer actual = rouletteGamble.win(bettingMap, 12);
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }






    @Test
    public void loseTest1(){
        Integer actual = rouletteGamble.lose(40, 40);
        Integer expected = 0;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void loseTest2(){
        Integer actual = rouletteGamble.lose(40, 80);
        Integer expected = 40;
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void loseTest3(){
        Integer actual = rouletteGamble.lose(80, 40);
        Integer expected = -40;
        Assert.assertEquals(expected, actual);
    }




    @Test
    public void printStats1(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        rouletteGamble.printStats(500,480,40,20,20);
        String expected = "\n***HERE ARE YOUR STATS!***\n" +
                "You bet 40 chips.\n" +
                "You won 20 chips. \n" +
                "Net total: 20\n" +
                "Your chip balance at the start of the game: 500\n" +
                "Your current balance: 480\n\n\n\n";
        Assert.assertEquals(expected, outputStream.toString());
    }
    @Test
    public void printStats2(){
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        rouletteGamble.printStats(500,560,40,100,100);
        String expected = "\n***HERE ARE YOUR STATS!***\n" +
                "You bet 40 chips.\n" +
                "You won 100 chips. \n" +
                "Net total: 100\n" +
                "Your chip balance at the start of the game: 500\n" +
                "Your current balance: 560\n\n\n\n";
        Assert.assertEquals(expected, outputStream.toString());
    }
}
