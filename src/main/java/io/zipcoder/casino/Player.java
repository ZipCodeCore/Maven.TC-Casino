package io.zipcoder.casino;

public class Player {
    private String name;
    private Hand hand;
    private Integer cash;
    private boolean isPerson;

    public Player(String name, Integer cash, boolean isPerson) {
        this.name = name;
        this.isPerson = isPerson;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public boolean isPerson() {
        return isPerson;
    }

    public Integer getCash(){
        return cash;
    }
    public void addCash(Integer amount){
        cash+=amount;
    }

    public Integer withdrawalCash(Integer amount) {
        if (amount > cash)
            return 0;
        else
            cash-=amount;
        return amount;
    }

}
