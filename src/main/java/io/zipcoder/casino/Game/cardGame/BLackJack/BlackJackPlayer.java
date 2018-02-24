package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.*;
import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.cardGame.CardPlayer;

public class BlackJackPlayer extends CardPlayer implements Gambler {

    private boolean hasStood;
    private boolean isBusted;
    private Escrow playerEscrow;

    public BlackJackPlayer(Profile someProfile) {
        super(someProfile);
        this.playerEscrow = new Escrow();
    }

    public boolean getHasStood() {
        return hasStood;
    }

    public void setHasStood(boolean stoodStatus) {
        this.hasStood = stoodStatus;
    }

    public boolean getIsBusted() {
        return isBusted;
    }

    public void setIsBusted(boolean isBusted) {
        this.isBusted = isBusted;
    }

    public boolean bet(TypeOfBet typeOfBet, double amount) {
        double accountBalance = this.getProfile().getAccountBalance();

        if (accountBalance < amount) {
            Console.print("Insufficient funds : cannot place bet");
            return false;
        }
        else if (this.escrowContains(typeOfBet)) {
            double escrowBalance = this.getEscrowBet(typeOfBet);
            this.getProfile().setAccountBalance(accountBalance - amount);
            this.setEscrow(typeOfBet, amount + escrowBalance);
            return true;
        }
        else {
            this.getProfile().setAccountBalance(accountBalance - amount);
            this.setEscrow(typeOfBet, amount);
            return true;
        }

    }

    public void win(TypeOfBet typeOfBet, double payoutMultiplier) {
        double accountBalance = this.getProfile().getAccountBalance();
        double escrow = this.getEscrowBet(typeOfBet);
        double winnings = escrow + (escrow * payoutMultiplier);
        this.getProfile().setAccountBalance(accountBalance+ winnings);
        this.setEscrow(typeOfBet,0);
    }

    public void lose(TypeOfBet typeOfBet) {
        this.setEscrow(typeOfBet, 0);
    }

    public void setEscrow(TypeOfBet typeOfBet, double incomingBet){
        this.playerEscrow.getEscrow().put(typeOfBet, incomingBet);
    }


    public double getEscrowBet(TypeOfBet typeOfBet){
        return this.playerEscrow.getEscrow().get(typeOfBet);
    }


    public boolean escrowContains(TypeOfBet typeOfBet){
        return playerEscrow.getEscrow().containsKey(typeOfBet) ;
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
