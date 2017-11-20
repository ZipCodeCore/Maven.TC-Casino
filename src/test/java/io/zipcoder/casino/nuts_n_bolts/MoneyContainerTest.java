package io.zipcoder.casino.nuts_n_bolts;

import org.junit.Test;
import org.junit.Assert;
import java.util.Random;

public class MoneyContainerTest {

    private Random rando = new Random();

    @Test
    public void testAddAndGetMoney(){
        MoneyContainer testPot = new MoneyContainer();
        Double amountToAdd = rando.nextDouble();
        Double actual;
        testPot.addMoney(amountToAdd);
        actual=testPot.getMoney();
        Assert.assertEquals(amountToAdd, actual, 0.0001);
    }

    @Test
    public void testTakeOutMoney(){
        MoneyContainer testPot = new MoneyContainer();
        Double amountToRemove = rando.nextDouble();
        Double actual;
        Double expected;

        testPot.addMoney(rando.nextDouble());
        if (amountToRemove<testPot.getMoney())
            expected = amountToRemove;
        else
            expected=0.0;
        actual=testPot.takeOutMoney(amountToRemove);
        Assert.assertEquals(expected, actual, 0.0001);
    }

    @Test
    public void testTakeAllMoney(){
        MoneyContainer testPot = new MoneyContainer();
        testPot.addMoney(rando.nextDouble());
        Double expected=testPot.getMoney();
        Double actual = testPot.takeAllMoney();

        Assert.assertEquals(expected, actual, 0.0001);
        Assert.assertEquals(0.0, testPot.getMoney(), 0.0001);
    }


}
