package io.zipcoder.casino;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CrapsPlayerTest {

    @Test
    public void shouldReturnAvalueBetween2AND12WhileRollingDiceTest(){

        CrapsPlayer shooter = new CrapsPlayer();

        Integer actual = shooter.roll2Dice();
        assertTrue(actual <13 && actual > 2);
    }



}