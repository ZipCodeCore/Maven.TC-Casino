package io.zipcoder.casino.Game.diceGame.Craps;


import io.zipcoder.casino.Gambler;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

public class CrapsPlayer extends Player implements Gambler {

    private boolean passLine;



    public CrapsPlayer(Profile someProfile) {
        super(someProfile);
    }


    public void bet(double amount) {
        this.getProfile().setAccountBalance(this.getProfile().getAccountBalance()-amount);
        this.getProfile().setEscrow(amount);

    }


    public void win(double payoutMultiplier) {


    }

    public void lose() {

    }

    public boolean isPassLine() {
        return this.passLine;
    }

    public void setPassLine(boolean input) {
        this.passLine = input;

    }
}
