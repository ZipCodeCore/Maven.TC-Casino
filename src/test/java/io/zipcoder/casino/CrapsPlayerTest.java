package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CrapsPlayerTest {

    @Test
    public void roll2DiceTest(){

        CrapsPlayer shooter = new CrapsPlayer();

        Integer actual = shooter.roll2Dice();
        Assert.assertTrue(actual <13 && actual > 0);

        for(int i =0; i < 1000000; i++){
            actual = shooter.roll2Dice();
            Assert.assertTrue(actual <13 && actual > 0);
        }
    }

}