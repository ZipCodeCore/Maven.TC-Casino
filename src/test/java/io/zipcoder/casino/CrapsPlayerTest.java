package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CrapsPlayerTest {

    @Test
    public void shouldReturnAValueBetween2AND12WhileRollingDiceTest(){

        CrapsPlayer shooter = new CrapsPlayer("el pato");

        Integer actual = shooter.roll2Dice();
        assertTrue(actual <13 && actual > 2);
    }

    @Test
    public void shouldIncreasePlayerWalletByBetWhenIsWin(){
        //given
        Craps craps = new Craps();
        CrapsPlayer crapsPlayer = new CrapsPlayer("el pato");
        crapsPlayer.setWallet(500.0);
        //when
        crapsPlayer.makeBet(100.0);
        boolean wins = craps.isBetWinComeOut(7, CrapsBetType.PASSLINE);

        craps.resolveBet(crapsPlayer, false);
        crapsPlayer.collectWinnings(wins, craps);

        Double expected = 600.0;
        Double actual = crapsPlayer.getWallet();

        Assert.assertEquals(expected,actual);

    }



}