package io.zipcoder.casino;

abstract class Player<E> {

    protected String name;
    protected Double money;
    protected double bet;


    Player(String name, Double money){
        this.name = name;
        this.money = money;
    }

    Player() {
    }

    public String getName() {
        return name;
    }

    private void bet(double bet) {
        this.bet = bet;
    }

    public abstract void addCardToHand(Card card);
}
