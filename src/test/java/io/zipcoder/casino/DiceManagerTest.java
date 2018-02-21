package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class DiceManagerTest {

    @Test
    public void amountOfDiceCreatedTest() {
        DiceManager allDice = new DiceManager(5);
        int expected = 5;
        allDice.rollAllDice();
        int actual = allDice.getAllDieFaces().length;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void rollAllDiceTest() {
        // This test may occasionally fail if the dice rolled all wind up on the same face, but that should be very rare
        DiceManager allDice = new DiceManager(5);
        allDice.rollAllDice();
        int firstDieTotal = allDice.getTotalValue();
        allDice.rollAllDice();
        int secondDieTotal = allDice.getTotalValue();
        Assert.assertNotEquals(firstDieTotal, secondDieTotal);
    }

    @Test
    public void rollSpecificDieTest() {
        // This test should fail about 1/6 of the time, because a number could still be the same after a roll
        DiceManager allDice = new DiceManager(2);
        allDice.rollAllDice();
        int firstDieFace = allDice.getAllDieFaces()[0];
        allDice.rollAllDice();
        int secondDieFace = allDice.getAllDieFaces()[0];
        Assert.assertNotEquals(firstDieFace, secondDieFace);
    }

    @Test
    public void setSpecificDieFaceTest() {
        DiceManager allDice = new DiceManager(3);
        allDice.rollAllDice();
        allDice.setSpecificDie(2, 1);
        int expected = 1;
        int actual = allDice.getAllDieFaces()[2];
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDiceArrayTest() {
        DiceManager allDice = new DiceManager(3);
        allDice.rollAllDice();
        allDice.setSpecificDie(2, 3);
        allDice.setSpecificDie(1,6);
        allDice.setSpecificDie(0, 1);
        int[] expected = new int[]{1, 6, 3};
        int[] actual = allDice.getAllDieFaces();
        System.out.println(allDice.getAllDieFaces()[0]);
        System.out.println(allDice.getAllDieFaces()[1]);
        System.out.println(allDice.getAllDieFaces()[2]);
        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getTotalValueTest() {
        DiceManager allDice = new DiceManager(2);
        allDice.rollAllDice();
        allDice.setSpecificDie(0, 2);
        allDice.setSpecificDie(1,2);
        int expected = 4;
        int actual = allDice.getTotalValue();
        Assert.assertEquals(expected, actual);
    }

}
