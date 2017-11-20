package io.zipcoder.casino.nuts_n_bolts;

import io.zipcoder.casino.games.Gamble;

public class Pot {

    private Double money = 0d;

    public Double getMoney() {
        return money;
    }

    public void addToPot(Double money) {
        this.money = money;
    }

    public Double takeOutOfPot (Double money){
        return null; //check request < pot
    }

    public Double takeAllOutOfPot(){
        return null;
    }
}
