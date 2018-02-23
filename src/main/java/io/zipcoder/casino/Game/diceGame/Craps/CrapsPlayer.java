package io.zipcoder.casino.Game.diceGame.Craps;


import io.zipcoder.casino.*;
import io.zipcoder.casino.CasinoUtilities.Console;

public class CrapsPlayer extends Player implements Gambler {

    private boolean passLine;



    public CrapsPlayer(Profile someProfile) {
        super(someProfile);
    }


    public void bet(TypeOfBet typeOfBet, double amount) {
        double accountBalance = this.getProfile().getAccountBalance();

        if (accountBalance < amount) {
            Console.print("Insufficient funds : cannot place bet");
        }
        else if (this.getProfile().escrowContains(typeOfBet)) {
            double escrowBalance = this.getProfile().getEscrow(typeOfBet);
            this.getProfile().setAccountBalance(accountBalance - amount);
            this.getProfile().setEscrow(typeOfBet, amount + escrowBalance);
        }
        else {
            this.getProfile().setAccountBalance(accountBalance - amount);
            this.getProfile().setEscrow(typeOfBet, amount);
        }

    }

    public void win(TypeOfBet typeOfBet, double payoutMultiplier) {
        double accountBalance = this.getProfile().getAccountBalance();
        double escrow = this.getProfile().getEscrow(typeOfBet);
        double winnings = escrow + (escrow * payoutMultiplier);

        this.getProfile().setAccountBalance(accountBalance+ winnings);
        this.getProfile().setEscrow(typeOfBet,0);
    }

    public void lose(TypeOfBet typeOfBet) {
        this.getProfile().setEscrow(typeOfBet, 0);
    }

    public boolean isPassLine() {
        return this.passLine;
    }

    public void setPassLine(boolean input) {
        this.passLine = input;

    }
}
