package io.zipcoder.casino;


public class Person {
    private String name = "";
    private Hand hand = null;
    private Wallet wallet = null;


    protected Person(){ }

    public Person(String name) {
        this.name = name;
        this.hand = new Hand();
        this.wallet = new Wallet();
    }

    public String getName() {
        return this.name;
    }

    public Hand getHand() {
        return this.hand;
    }

    public Wallet getWallet() {
        return this.wallet;
    }
}
