package io.zipcoder.casino.Players;


import io.zipcoder.casino.Wallet;


public class Player {

    protected String name;
    protected Integer age;
    protected Wallet wallet;

    public Player(String name, Integer age){
        this.name = name;
        this.age = age;
    }

    public Player(){
        this.name = "";
        this.age = Integer.MAX_VALUE;
    }


    public Player(String name, Integer age, Integer balance) {
        this.name = name;
        this.age = age;
        this.wallet = new Wallet(balance);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getBalance() {
        return wallet.getBalance();
    }

}
