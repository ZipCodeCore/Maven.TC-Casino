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
    public void setSpecificDieFaceTest() {
        DiceManager allDice = new DiceManager(3);
        allDice.rollAllDice();
        allDice.setSpecificDie(2, DieFace.ONE);
        DieFace expected = DieFace.ONE;
        DieFace actual = allDice.getAllDieFaces()[2];
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getDiceArrayTest() {
        DiceManager allDice = new DiceManager(3);

        allDice.setSpecificDie(0, DieFace.THREE);
        allDice.setSpecificDie(1,DieFace.SIX);
        allDice.setSpecificDie(2, DieFace.FIVE);

        DieFace[] expected = new DieFace[]{DieFace.THREE, DieFace.SIX, DieFace.FIVE};
        DieFace[] actual = allDice.getAllDieFaces();

        Assert.assertArrayEquals(expected, actual);
    }

    @Test
    public void getTotalValueTest() {
        DiceManager allDice = new DiceManager(2);
        allDice.rollAllDice();
        allDice.setSpecificDie(0, DieFace.TWO);
        allDice.setSpecificDie(1,DieFace.TWO);
        int expected = 4;
        int actual = allDice.getTotalValue();
        Assert.assertEquals(expected, actual);
    }

}
