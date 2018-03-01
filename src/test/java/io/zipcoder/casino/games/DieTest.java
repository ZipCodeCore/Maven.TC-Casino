package io.zipcoder.casino.games;

import org.junit.Assert;
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
public class DieTest {
    @Test
    public void testRoll() {
        Die d6 = new Die();
        Integer[] i = {1, 2, 3, 4, 5, 6};
        List<Integer> expected = new ArrayList<>(Arrays.asList(i));
        int[] actual = d6.roll(1);
        System.out.println(Arrays.toString(actual));
        for (int roll : actual)
            Assert.assertTrue(expected.contains(roll));
    }

    @Test
    public void testGetSides() {
        int expected = 20;
        int actual = new Die(expected).getSides();

        Assert.assertEquals(expected, actual);
    }
}
