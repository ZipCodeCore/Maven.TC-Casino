package io.zipcoder.casino.utils;

import io.zipcoder.casino.games.Die;

import java.util.Arrays;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/24/18
 */
public class Dice {
    public static boolean containsLowStraight(Die die, int[] rolls) {
        int straightLength = die.getSides() / 2;
        int[] model = new int[straightLength];

        for (int i = 0; i < straightLength; i++)
            model[i] = i + 1;

        return match(model, rolls);
    }

    public static boolean containsHighStraight(Die die, int[] rolls) {
        int straightLength = die.getSides() / 2;
        int[] model = new int[straightLength];

        for (int i = 0; i < straightLength; i++) {
            model[i] = i + straightLength + 1;
        }

        return match(model, rolls);
    }

    public static boolean allDiceMatch(int[] rolls) {
        Arrays.sort(rolls);
        return (rolls[0] == rolls[rolls.length - 1]);
    }

    protected static boolean match(int[] model, int[] rolls) {
        Arrays.sort(model);
        Arrays.sort(rolls);

        if (Arrays.equals(model, rolls))
            return true;

        for (int i : model) {
            if (!contains(rolls, i))
                return false;
        }
        return true;
    }

    protected static boolean contains(int[] rolls, int target) {
        for (int i : rolls) {
            if (i == target)
                return true;
        }
        return false;
    }
}
