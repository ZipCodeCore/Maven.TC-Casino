package io.zipcoder.casino;

import java.util.ArrayList;

abstract class Player<E> {

    private String name;
    private Double money;
    private double bet;

    public String getName() {
        return name;
    }

    private void bet(double bet){
     this.bet = bet;
    }

    Player(String name, Double money){
        this.name = name;
        this.money = money;
    }

    Player(String name){
        this.name = name;
    }

}
