package io.zipcoder.casino;

import java.util.Random;

public class Die {

    private Integer dieFace;
    Random random = new Random();

    public Die() {
        rollDie();
    }

    public Integer getDieFace() {
        return this.dieFace;
    }

    public void rollDie() {
        this.dieFace = random.nextInt(6) + 1;
    }
}
