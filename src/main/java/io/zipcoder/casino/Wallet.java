package io.zipcoder.casino;

public class Wallet {
    private int balance;

    public Wallet(){
        this.balance = 0;
    }

    public Wallet(int balance){
        this.balance = balance;
    }

    public int getBalance(){
        return this.balance;
    }

    public void add(int money){
        this.balance += money;
    }

    public void subtract(int money){
        this.balance -= money;
    }
}
