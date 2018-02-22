package io.zipcoder.casino;

import java.util.Random;

public class Die {

    private DieFace dieFace;
    Random random = new Random();

    public Die() {
        this.dieFace = null;
    }

    public DieFace getDieFace() {
        return this.dieFace;
    }

    public void setDieFace(DieFace desiredDieFace) {
        this.dieFace = desiredDieFace;
    }


    public void rollDie() {
        int randomNumber = random.nextInt(6) + 1;
        switch (randomNumber) {
            case 1:
                this.setDieFace(DieFace.ONE);
                break;
            case 2:
                this.setDieFace(DieFace.TWO);
                break;
            case 3:
                this.setDieFace(DieFace.THREE);
                break;
            case 4:
                this.setDieFace(DieFace.FOUR);
                break;
            case 5:
                this.setDieFace(DieFace.FIVE);
                break;
            case 6:
                this.setDieFace(DieFace.SIX);
                break;
        }
    }
}
