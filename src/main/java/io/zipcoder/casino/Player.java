package io.zipcoder.casino;


public abstract class Player {
    private String name;
    protected Double money;

    public Player() {
        name = "Player";
        money = 500.0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
