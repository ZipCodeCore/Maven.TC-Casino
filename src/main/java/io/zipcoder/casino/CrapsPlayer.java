package io.zipcoder.casino;

import io.zipcoder.casino.Profile;

public class CrapsPlayer extends Player implements Gambler {

    private boolean isPassLine;

    public CrapsPlayer(Profile playerProfile){
        super(playerProfile);
    }

    public void bet(double amount) {

    }

    public void win() {

    }

    public void lose() {

    }

    public boolean isPassLine(Player somePlayer) {
        return false;
    }

    public void setPassLine(Player somePlayer) {

    }
}
