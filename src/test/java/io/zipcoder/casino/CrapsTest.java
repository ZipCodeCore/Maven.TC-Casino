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
    public void checkPassLineBetWin() {
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
    public void checkPassLineBetLose(){
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setPassLineBet(5);
        crapsTest.setPoint(8);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkDontPassLineBetWin() {
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
    public void checkDontPassLineBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setDontPassLineBet(5);
        crapsTest.setPoint(8);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkComeBetWin() {
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setPoint(8);
        crapsTest.setComeBet(5);
        crapsTest.checkPhaseTwoRolls();
        int expected = 505;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkComeBeLose() {
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.ONE);
        crapsTest.setPoint(8);
        crapsTest.setComeBet(5);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkDontComeBetWin() {
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.ONE);
        crapsTest.setPoint(8);
        crapsTest.setDontComeBet(5);
        crapsTest.checkPhaseTwoRolls();
        int expected = 505;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkDontComeBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0,DieFace.ONE);
        crapsTest.getDiceManager().setSpecificDie(1,DieFace.SIX);
        crapsTest.setPoint(8);
        crapsTest.setDontComeBet(5);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected,actual);
    }

    @Test
    public void checkFieldBetDoubleWin() {
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
    public void checkFieldBetWin() {
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
    public void checkFieldBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.THREE);
        crapsTest.setFieldBet(10);
        crapsTest.createFieldValues();
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPassOddsBetWin() {
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
    public void checkPassOddsBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FIVE);
        crapsTest.setPassOddsBet(10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkDontPassOddsWin() {
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
    public void checkDontPassOddsLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.TWO);
        crapsTest.setDontPassOddsBet(10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkComePointBetWin() {
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
    public void checkComePointBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FIVE);
        crapsTest.setComeBetPoints(5,10);
        crapsTest.setComeBetPoints(4,10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkDontComePointBetWin() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FIVE);
        crapsTest.setDontComeBetPoints(5,10);
        crapsTest.setDontComeBetPoints(4,10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 520;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkDontComePointBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.TWO);
        crapsTest.setDontComeBetPoints(4,10);
        crapsTest.setPoint(4);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkComePointOddsBetWin1() { // Checks Come Point Odds bet on 5s
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
    public void checkComePointOddsBetWin2() { // Checks Come Point Odds bet on 4
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
    public void checkComePointOddsBetWin3() { // Checks Come Point Odds bet on 6
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FOUR);
        crapsTest.setComeBetPointOdds(6,10);
        crapsTest.setPoint(5);
        crapsTest.checkPhaseTwoRolls();
        int expected = 522;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkComePointOddsBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.THREE);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FOUR);
        crapsTest.setComeBetPointOdds(6,10);
        crapsTest.setComeBetPointOdds(5,10);
        crapsTest.setPoint(5);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkDontComePointOddsBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.THREE);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.THREE);
        crapsTest.setDontComeBetPointOdds(6,10);
        crapsTest.setPoint(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkDontComePointOddsBetWin() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.FOUR);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.THREE);
        crapsTest.setDontComeBetPointOdds(6,10);
        crapsTest.setDontComeBetPointOdds(5,10);
        crapsTest.setDontComeBetPointOdds(4,10);
        crapsTest.setPoint(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 549;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPlaceWinBet1() {//Checks Place Win on 6
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.THREE);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.THREE);
        crapsTest.setPlaceWinBets(6,10);
        crapsTest.setPoint(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 521;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPlaceWinBet2() {//Checks place win on 5
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.THREE);
        crapsTest.setPlaceWinBets(5,10);
        crapsTest.setPoint(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 524;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPlaceWinBet3() {//Checks place win on 4
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.TWO);
        crapsTest.setPlaceWinBets(4,10);
        crapsTest.setPoint(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 528;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPlaceWinLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FIVE);
        crapsTest.setPlaceWinBets(4,10);
        crapsTest.setPlaceWinBets(5,10);
        crapsTest.setPlaceWinBets(6,10);
        crapsTest.setPoint(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPlaceLoseBetWin() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FIVE);
        crapsTest.setPlaceLoseBets(4,10);
        crapsTest.setPlaceLoseBets(5,10);
        crapsTest.setPlaceLoseBets(6,10);
        crapsTest.setPoint(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 548;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void checkPlaceLoseBetLose() {
        crapsTest.getDiceManager().setSpecificDie(0, DieFace.TWO);
        crapsTest.getDiceManager().setSpecificDie(1, DieFace.FOUR);
        crapsTest.setPlaceLoseBets(6, 10);
        crapsTest.setPoint(6);
        crapsTest.checkPhaseTwoRolls();
        int expected = 500;
        int actual = crapsTest.getPlayer().getWallet().checkChipAmount();
        Assert.assertEquals(expected, actual);
    }
}
