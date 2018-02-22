package io.zipcoder.casino.Game.diceGame.Craps;


import io.zipcoder.casino.Gambler;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

public class CrapsPlayer extends Player implements Gambler {

    private boolean isPassLine;


    public CrapsPlayer(Profile someProfile) {
        super(someProfile);
    }

    public CrapsPlayer() {

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
