package io.zipcoder.casino;

public class BlackJackPlayer extends CardPlayer implements Gambler<> {

    private boolean hasStood;
    private boolean isBusted;


    public BlackJackPlayer () {

    }


    public boolean getHasStood() {
        return hasStood;
    }

    public void setHasStood(boolean hasStood) {
        this.hasStood = hasStood;
    }

    public boolean getIsBusted() {
        return isBusted;
    }

    public void setIsBusted(boolean isBusted) {
        this.isBusted = isBusted;
    }





//    public void buyInsurance() {
//
//    }
//
//    public io.zipcoder.casino.Hand split(io.zipcoder.casino.Hand currentHand) {
//
//        return additionalHand;
//
//    }
//
//    public void doubleDown() {
//
//    }


}