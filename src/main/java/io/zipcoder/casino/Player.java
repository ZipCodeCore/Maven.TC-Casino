package io.zipcoder.casino;

abstract class Player<E> {

    protected String name;
    protected Double money;
    protected double bet;


    Player(String name, Double money){
        this.name = name;
        this.money = money;
    }

    Player(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void bet(double bet){
     this.bet = bet;
    }

}
