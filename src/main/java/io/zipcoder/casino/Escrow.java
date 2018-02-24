package io.zipcoder.casino;

import java.util.HashMap;

public class Escrow {
    private HashMap<TypeOfBet, Double> escrow;

    public Escrow(){
        this.escrow = new HashMap<>(0);
    }

    public HashMap<TypeOfBet, Double> getEscrow(){
        return this.escrow;
    }

}
