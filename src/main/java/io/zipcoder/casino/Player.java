package io.zipcoder.casino;

import org.omg.CORBA.INTERNAL;

public class Player {
    private Long chips;

    public Player(){
        this.chips = 200l; //each chip is $5
    }


    public Boolean canCoverBet(Integer minimumBetCharge){
        return (this.chips >= minimumBetCharge ? true : false);
    }

    public void betChips(Integer bet){
        this.chips -= bet;
    }

    public void addChips(Integer numberOfChipsToAdd){
        this.chips += numberOfChipsToAdd;
    }

    public Long getBalance(){
        return this.chips;
    }
}
