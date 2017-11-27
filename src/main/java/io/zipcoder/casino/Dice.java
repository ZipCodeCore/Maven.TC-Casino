package io.zipcoder.casino;

import static java.util.concurrent.ThreadLocalRandom.current;

public class Dice {
    private final int min;
    private final int max;

    public Dice(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public Dice() {
        this(1, 6);
    }

    public Integer roll() {
        return current().nextInt(min, max);
    }
}