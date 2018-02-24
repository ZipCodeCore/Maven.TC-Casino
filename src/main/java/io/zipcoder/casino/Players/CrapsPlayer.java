package io.zipcoder.casino.Players;

import io.zipcoder.casino.Wallet;

public class CrapsPlayer extends Player{


    public CrapsPlayer(){
        this.name = getName();
        this.age = getAge();
        this.wallet = new Wallet(getBalance());

    }
}
