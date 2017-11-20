package io.zipcoder.casino.nuts_n_bolts;

public class User {

    protected String name;
    protected Double money;

    public User(String name, Double money){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public void gainMoney(Double money){

    }

    public void loseMoney(Double money){
        //check to see if money < this.money
    }
}
