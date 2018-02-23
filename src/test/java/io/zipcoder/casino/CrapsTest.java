package io.zipcoder.casino;

import org.junit.Test;

public class CrapsTest {
    Craps crapsTest = new Craps();

    @Test
    public void comeOutRollTest() {
        crapsTest.comeOutRoll();
    }

    @Test
    public void phaseTwoRollsTest() {
        crapsTest.phaseTwoRolls();
    }
}
