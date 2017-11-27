package io.zipcoder.casino.games.craps;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class CrapsTest {

    Craps game;

    @Before
    public void preTestsSetup(){
        game=new Craps();
    }
    @Test
    public void takeBetTest(){
        double beginningPot=game.getMainPot().getMoney();
        game.takeBet(100.0);
        double afterTakeBet=game.getMainPot().getMoney();

        Assert.assertEquals(beginningPot+100,afterTakeBet, 0.001);
    }

    @Test
    public void takeSideBetTest() {
        double beginningPot = game.getSidePot().getMoney();
        game.takeSideBet(100.0);
        double afterTakeSideBet = game.getSidePot().getMoney();

        Assert.assertEquals(beginningPot + 100, afterTakeSideBet, 0.001);
    }

    @Test
    public void settleBetTest(){
        double beforeBetting = game.getMainPot().getMoney();
        double betAmount=100;
        double settleAmount=50;

        game.takeBet(betAmount);
        game.settleBet(settleAmount);
        double afterSettling=game.getMainPot().getMoney();

        Assert.assertEquals(beforeBetting+betAmount-settleAmount, afterSettling, 0.001);
    }

    @Test
    public void settleSideBetTest(){
        double beforeBetting = game.getSidePot().getMoney();
        double betAmount=100;
        double settleAmount=50;

        game.takeSideBet(betAmount);
        game.settleSideBet(settleAmount);
        double afterSettling=game.getSidePot().getMoney();

        Assert.assertEquals(beforeBetting+betAmount-settleAmount, afterSettling, 0.001);
    }

    @Test
    public void emptyPotTest(){
        double beforeBetting = game.getMainPot().getMoney();
        double betAmount=100;

        game.takeBet(betAmount);
        double afterEmptying = game.emptyPot();

        Assert.assertEquals(beforeBetting+betAmount, afterEmptying, 0.001);
    }

    @Test
    public void emptySidePotTest(){
        double beforeBetting = game.getSidePot().getMoney();
        double betAmount=100;

        game.takeSideBet(betAmount);
        double afterEmptying = game.emptySidePot();

        Assert.assertEquals(beforeBetting+betAmount, afterEmptying, 0.001);
    }

    @Test
    public void isPlayerAndChangePlayerTest(){
        boolean isPlayerTurn=game.getPlayerTurn();
        Assert.assertEquals(isPlayerTurn, game.getPlayerTurn());
        game.changePlayerTurn();
        Assert.assertNotEquals(isPlayerTurn, game.getPlayerTurn());
        isPlayerTurn=game.getPlayerTurn();
        Assert.assertEquals(isPlayerTurn, game.getPlayerTurn());
    }

    @Test
    public void initialThrowAndGetNumberRolledTest(){
        int result;

        for (int i=0; i<1000000; i++) {
            result = game.initialThrow();
            Assert.assertTrue(Math.abs(result) <= 1);
            Assert.assertTrue(game.getNumberRolled() > 0 && game.getNumberRolled() < 13);
        }
    }

    @Test
    public void secondaryThrowTest(){
         Integer[] valid = {-1, 0, 1, 4, 5, 6, 8, 9, 10};
         ArrayList<Integer> validList = new ArrayList<>(Arrays.asList(valid));

        int result;
        int numRolled;
        for (int i=0; i<50; i++){
            result=game.initialThrow();//Need to get a pair set
                        //or else we throw a NullPointer Exception
        }

        for (int i=0; i<1000000; i++) {
            result = game.secondaryThrow();
            Assert.assertTrue(validList.contains(result));
        }

    }

    @Test
    public void playTest(){
        String test;
        for (char c='A'; c<='z'; c++){
            test=""+c;
            if ("Y".equalsIgnoreCase(test)){
                Assert.assertTrue(game.play(test));
            } else{
                Assert.assertFalse(game.play(test));
            }
        }
    }

}
