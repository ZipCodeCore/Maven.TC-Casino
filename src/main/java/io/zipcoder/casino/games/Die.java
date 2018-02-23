package io.zipcoder.casino.games;

import java.util.Random;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/23/18
 */
public class Die {
    private int sides;
    private static final int fDEFAULT_SIDES = 6;

    public Die() {
        this(fDEFAULT_SIDES);
    }

    public Die(int sides) {
        this.sides = sides;
    }

    public int[] roll(int numberOfRolls) {
        int[] rolls = new int[numberOfRolls];
        for (int i=0;i<numberOfRolls;i++)
            rolls[i] = new Random().nextInt(sides) + 1;
        return rolls;
    }
}
