package io.zipcoder.casino.utils;

import io.zipcoder.casino.games.Die;
import org.junit.Assert;
import org.junit.Test;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/24/18
 */
public class DiceTest {

    @Test
    public void containsLowStraightSuccess() {
        Die d4 = new Die(4);
        int[] sample = {1, 2, 3};

        Assert.assertTrue(Dice.containsLowStraight(d4, sample));
    }

    @Test
    public void containsLowStraightFail() {
        Die d4 = new Die(4);
        int[] sample = {3, 4, 5};

        Assert.assertFalse(Dice.containsLowStraight(d4, sample));
    }

    @Test
    public void containsLowStraightMoreRollsThanHighestValSuccess() {
        Die d6 = new Die(6);
        int[] sample = {1, 2, 3, 4, 5, 6};

        Assert.assertTrue(Dice.containsLowStraight(d6, sample));
    }

    @Test
    public void containsLowStraightMoreRollsThanHighestValFail() {
        Die d6 = new Die(6);
        int[] sample = {1, 2, 4, 6, 2, 5, 1};

        Assert.assertFalse(Dice.containsLowStraight(d6, sample));
    }

    @Test
    public void containsHighStraightSuccess() {
        Die d4 = new Die(4);
        int[] sample = {2, 3, 4};

        Assert.assertTrue(Dice.containsHighStraight(d4, sample));
    }

    @Test
    public void containsHighStraightFail() {
        Die d4 = new Die(4);
        int[] sample = {2, 3, 1};

        Assert.assertFalse(Dice.containsHighStraight(d4, sample));
    }

    @Test
    public void containsHighStraightMoreRollsThanHighestValSuccess() {
        Die d6 = new Die(6);
        int[] sample = {1, 2, 3, 4, 5, 6, 3};

        Assert.assertTrue(Dice.containsHighStraight(d6, sample));
    }

    @Test
    public void containsHighStraightMoreRollsThanHighestValFail() {
        Die d6 = new Die(6);
        int[] sample = {5, 4, 3, 2, 2, 3, 4};

        Assert.assertFalse(Dice.containsHighStraight(d6, sample));
    }

    @Test
    public void allDiceMatchSuccess() {
        int[] sample = {3, 3, 3};

        Assert.assertTrue(Dice.allDiceMatch(sample));
    }

    @Test
    public void allDiceMatchFail() {
        int[] sample = {3, 4, 5};

        Assert.assertFalse(Dice.allDiceMatch(sample));
    }

    @Test
    public void matchSuccess() {
        int[] s1 = {6, 3, 2, 4, 1};
        int[] s2 = {6, 2, 4, 3, 1};

        Assert.assertTrue(Dice.match(s1, s2));
    }

    @Test
    public void matchFail() {
        int[] s1 = {2, 3, 4, 5, 9};
        int[] s2 = {2, 3, 4, 9, 11};

        Assert.assertFalse(Dice.match(s1, s2));
    }

    @Test
    public void testContainsSuccess() {
        int[] sample = {1, 2, 3};
        Assert.assertTrue(Dice.contains(sample, 2));
    }

    @Test
    public void testContainsFail() {
        int[] sample = {1, 2, 3};
        Assert.assertFalse(Dice.contains(sample, 4));
    }
}