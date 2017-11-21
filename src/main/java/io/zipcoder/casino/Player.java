package io.zipcoder.casino;

public class Player<T extends Game> {

    private String name;
    private Double money;

    public Player(String name) {
        this.name = name;
    }

    public void bet(Double money) {
        this.money -= money;
    }

    public void receiveWinnings(Double money) {
        this.money += money;
    }

    public void cashOut() {
        money = 0.0;
    }

    public String getName() {
        return name;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
