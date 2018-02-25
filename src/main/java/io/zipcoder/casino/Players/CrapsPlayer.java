package io.zipcoder.casino.Players;


import io.zipcoder.casino.Wallet;

public class CrapsPlayer extends Player {

    private String name;
    private Integer age;
    private Wallet wallet;

    public CrapsPlayer() {
        super.age = age;
        super.name = name;
        this.wallet = super.wallet;
    }

    public Wallet getWallet(){
        return wallet;
    }
}
