package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.Game.Game.cardGame.CardPlayer;
import io.zipcoder.casino.Game.Game.Gambler;
import io.zipcoder.casino.Profile;

public class BlackJackPlayer extends CardPlayer implements Gambler {

    private boolean hasStood;
    private boolean isBusted;

    public BlackJackPlayer(Profile someProfile) {
        super(someProfile);
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

    public void bet(double amount) {

    }

    public void win() {

    }

    public void lose() {

    }





//    public void buyInsurance() {
//
//    }
//
//    public io.zipcoder.casino.Game.cardGame.utilities.Hand split(io.zipcoder.casino.Game.cardGame.utilities.Hand currentHand) {
//
//        return additionalHand;
//
//    }
//
//    public void doubleDown() {
//
//    }


}
