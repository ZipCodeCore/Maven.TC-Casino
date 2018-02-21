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

    public void setDieFace(int desiredDieFace) {
        switch (desiredDieFace) {
            case 1:
                this.dieFace = DieFace.ONE;
                break;
            case 2:
                this.dieFace = DieFace.TWO;
                break;
            case 3:
                this.dieFace = DieFace.THREE;
                break;
            case 4:
                this.dieFace = DieFace.FOUR;
                break;
            case 5:
                this.dieFace = DieFace.FIVE;
                break;
            case 6:
                this.dieFace = DieFace.SIX;
                break;
            default:
                System.out.println("Invalid Option Given");
        }
    }

    public void rollDie() {
        int randomNumber = random.nextInt(6) + 1;
        this.setDieFace(randomNumber);
    }
}
