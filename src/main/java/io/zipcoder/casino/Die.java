package io.zipcoder.casino;

import java.util.Random;

public class Die {

    private Integer dieFace;



    public Integer getDieFace() {
        return this.dieFace;
    }

    public void rollDie() {
        Random random = new Random();
        this.dieFace = random.nextInt(6) + 1;
    }
}
