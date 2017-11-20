package io.zipcoder.casino.nuts_n_bolts;

import io.zipcoder.casino.games.Gamble;

public class MoneyContainer {

    private Double money = 0d;

    public Double getMoney() {
        return money;
    }

    public void addMoney(Double money) {
        if (money>0) {
            this.money += money;
        }
    }

    public Double takeOutMoney (Double money){
        if (money>0 && money<=this.money){
            this.money-=money;
            return money;
        }
        return 0.0;
    }

    public Double takeAllMoney(){
        double moneyHolder = this.money;
        this.money=0.0;
        return moneyHolder;
    }
}
