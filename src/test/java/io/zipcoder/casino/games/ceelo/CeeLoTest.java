package io.zipcoder.casino.games.ceelo;

import io.zipcoder.casino.games.Die;
import io.zipcoder.casino.utils.IOHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/23/18
 */
public class CeeLoTest {
    private CeeLo clo;
    private Die d6;

    @Before
    public void setup() {
        clo = new CeeLo();
        d6 = new Die(6);
    }

    @Test
    public void getRulesTest() {
        String expected = IOHandler.getMessageFromFile("ceelo.rules.txt");
        String actual = clo.getRules();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testRollForPointInCorrectRange() {
        Integer[] i = {1, 2, 3, 4, 5, 6};
        List<Integer> expected = new ArrayList<>(Arrays.asList(i));
        int actual = clo.rollForPoint();

        Assert.assertTrue(expected.contains(actual));
    }

    @Test
    public void getPointSetLeopards() {
        int[] sample = {4, 4, 4};
        int expected = 6;
        int actual = clo.getPoint(d6, sample);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPointTestHighStraight() {
        int[] sample = {4, 5, 6};
        int expected = 6;
        int actual = clo.getPoint(d6, sample);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPointTestLowStraight() {
        int[] sample = {1, 2, 3};
        int expected = 1;
        int actual = clo.getPoint(d6, sample);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPointTestSetPoint() {
        int[] sample = {3, 3, 2};
        int expected = 2;
        int actual = clo.getPoint(d6, sample);

        Assert.assertEquals(expected, actual);
    }
}
