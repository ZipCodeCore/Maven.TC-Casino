package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Test;

public class CrapsTest {
    Craps crapsTest = new Craps();
    Person personTest = new Person("Steve");


    @Test
    public void checkPhaseTwoRollsTest1() {// Checks Pass Line
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setPassLineBet(5);
        crapsTest.setPoint(8);
        crapsTest.checkPhaseTwoRolls();
        int expected = 5;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkPhaseTwoRollsTest2() { //Checks Don't Pass Line
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setDontPassLineBet(5);
        crapsTest.setPoint(8);
        crapsTest.checkPhaseTwoRolls();
        int expected = 5;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkPhaseTwoRollsTest3() { //Checks Come Bet
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setDontPassLineBet(5);
        crapsTest.setPoint(8);
        crapsTest.setComeBet(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 11;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkPhaseTwoRollsTest4() { // Checks Don't Come Bet
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setDontPassLineBet(5);
        crapsTest.setPoint(8);
        crapsTest.setDontComeBet(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 11;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkPhaseTwoRollsTest5() { // Checks Field Double Bet
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.ONE);
        crapsTest.setFieldBet(10);
        crapsTest.checkPhaseTwoRolls();
        int expected = 20;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest6() { // Checks Field Bet
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.ONE);
        crapsTest.setFieldBet(10);
        crapsTest.checkPhaseTwoRolls();
        int expected = 10;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest7() { // Checks Pass Odds bet
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.TWO);
        crapsTest.setPassOddsBet(10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 20;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }
}
