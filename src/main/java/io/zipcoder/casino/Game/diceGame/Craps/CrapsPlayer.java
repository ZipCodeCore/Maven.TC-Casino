package io.zipcoder.casino.Game.diceGame.Craps;


import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Gambler;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

public class CrapsPlayer extends Player implements Gambler {

    private boolean passLine;



    public CrapsPlayer(Profile someProfile) {
        super(someProfile);
    }


    public void bet(String typeOfBet, double amount) {
       if (this.getProfile().getAccountBalance() < amount){
           Console.print("Insufficient funds : cannot place bet");
       }
       else if (this.getProfile().escrowContains(typeOfBet)) {
           this.getProfile().setAccountBalance(this.getProfile().getAccountBalance() - amount);
           this.getProfile().setEscrow(typeOfBet, amount
                    + this.getProfile().getEscrow(typeOfBet));
       }

       else{
           this.getProfile().setAccountBalance(this.getProfile().getAccountBalance() - amount);
           this.getProfile().setEscrow(typeOfBet, amount);
        }

    }


    public void win(String typeOfBet, double payoutMultiplier) {
        double escrow = this.getProfile().getEscrow(typeOfBet);
        double winnings = escrow + (escrow * payoutMultiplier);
        this.getProfile().setAccountBalance(this.getProfile().getAccountBalance()+ winnings);
        this.getProfile().setEscrow(typeOfBet,0);
    }

    public void lose(String typeOfBet) {
        this.getProfile().setEscrow(typeOfBet, 0);
    }

    public boolean isPassLine() {
        return this.passLine;
    }

    public void setPassLine(boolean input) {
        this.passLine = input;

    }
}
