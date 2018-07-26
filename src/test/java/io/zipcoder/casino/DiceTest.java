package io.zipcoder.casino;

import org.junit.Test;
import  org.junit.Assert;

import static org.junit.Assert.*;

public class DiceTest {
    @Test

    public void rollDiceTest() {

        Integer actual = Dice.rollDice(2);
       // System.out.println(actual);

        Assert.assertTrue(actual <13 && actual > 0);
    }


}