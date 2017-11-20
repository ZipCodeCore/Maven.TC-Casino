package io.zipcoder.casino.nuts_n_bolts;

import io.zipcoder.casino.games.Gamble;

public class Pot {

    private Double money = 0d;

    public Double getMoney() {
        return money;
    }

    public void addToPot(Double money) {
        if (money>0) {
            this.money += money;
        }
    }

    public Double takeOutOfPot (Double money){
        if (money>0 && money<=this.money){
            this.money-=money;
            return money;
        }
        return 0.0;
    }

    public Double takeAllOutOfPot(){
        double moneyHolder = this.money;
        this.money=0.0;
        return moneyHolder;
    }
}
