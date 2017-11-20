package io.zipcoder.casino.nuts_n_bolts;

import org.junit.Test;
import org.junit.Assert;
import java.util.Random;

public class PotTest {

    private Random rando = new Random();

    @Test
    public void testAddToPotAndGetMoney(){
        Pot testPot = new Pot();
        Double amountToAdd = rando.nextDouble();
        Double actual;
        testPot.addToPot(amountToAdd);
        actual=testPot.getMoney();
        Assert.assertEquals(amountToAdd, actual, 0.0001);
    }

    @Test
    public void testTakeOutOfPot(){
        Pot testPot = new Pot();
        Double amountToRemove = rando.nextDouble();
        Double actual;
        Double expected;

        testPot.addToPot(rando.nextDouble());
        if (amountToRemove<testPot.getMoney())
            expected = amountToRemove;
        else
            expected=0.0;
        actual=testPot.takeOutOfPot(amountToRemove);
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testTakeAllOutOfPot(){
        Pot testPot = new Pot();
        testPot.addToPot(rando.nextDouble());
        Double expected=testPot.getMoney();
        Double actual = testPot.takeAllOutOfPot();

        Assert.assertEquals(expected, actual, 0.0001);
        Assert.assertEquals(0.0, testPot.getMoney(), 0.0001);
    }


}
