package io.zipcoder.casino;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CrapsTest {
    Person personTest = new Person("Steve");
    Craps crapsTest = new Craps(personTest);

    @Before public void addMoney() {
            personTest.getWallet().addChipsToAmount(500);
        }


    @Test
    public void checkPhaseTwoRollsTest1() {// Checks Pass Line
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setPassLineBet(5);
        crapsTest.setPoint(8);
        crapsTest.checkPhaseTwoRolls();
        int expected = 505;
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
        int expected = 505;
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
        int expected = 511;
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
        int expected = 511;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkPhaseTwoRollsTest5() { // Checks Field Double Bet
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.ONE);
        crapsTest.setFieldBet(10);
        crapsTest.createFieldValues();
        crapsTest.checkPhaseTwoRolls();
        int expected = 520;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest6() { // Checks Field Bet
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.ONE);
        crapsTest.setFieldBet(10);
        crapsTest.createFieldValues();
        crapsTest.checkPhaseTwoRolls();
        int expected = 510;
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
        int expected = 520;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest8() { // Checks Don't Pass Odds bet
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FIVE);
        crapsTest.setDontPassOddsBet(10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 515;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest9() { // Checks Come Point bet
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.THREE);
        crapsTest.setComeBetPoints(5,10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 510;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest10() { // Checks Don't Come Point bet
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FIVE);
        crapsTest.setDontComeBetPoints(5,10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 510;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest11() { // Checks Come Point Odds bet on 5s
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.THREE);
        crapsTest.setComeBetPointOdds(5,10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 525;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest12() { // Checks Come Point Odds bet on 4
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.TWO);
        crapsTest.setComeBetPointOdds(4,10);
        crapsTest.setPoint(5);
        crapsTest.checkPhaseTwoRolls();
        int expected = 530;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPhaseTwoRollsTest13() { // Checks Come Point Odds bet on 6
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FOUR);
        crapsTest.setComeBetPointOdds(6,10);
        crapsTest.setPoint(5);
        crapsTest.checkPhaseTwoRolls();
        int expected = 522;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }
}
