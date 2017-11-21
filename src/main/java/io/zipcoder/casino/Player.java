package io.zipcoder.casino;

import java.util.ArrayList;

abstract class Player<E extends Comparable<E>> {

    private String name;
    private Double money;
    protected ArrayList<E> players;
    private Hand playerHand;
    private double bet;

    private void bet(double bet){
     this.bet = bet;
    }

    public Player<E> findPlayer(String name){
        return null;
    }

    abstract void addToList(E player);

    Player(String name, Double money){
        this.name = name;
        this.money = money;
    }

    Player(String name){
        this.name = name;
    }
}
