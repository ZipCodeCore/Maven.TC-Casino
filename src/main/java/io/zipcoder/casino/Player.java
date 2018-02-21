package io.zipcoder.casino;

import org.omg.CORBA.INTERNAL;

public class Player {
    private Long chips;

    public Player(){
        this.chips = 200l; //each chip is $5
    }


    public Boolean canCoverBet(Integer minimumBetCharge){
        return null;
    }

    public Long betChips(Integer bet){
        return null;
    }

    public void addChips(Integer numberOfChipsToAdd){

    }

    public Long getBalance(){
        return null;
    }
}
