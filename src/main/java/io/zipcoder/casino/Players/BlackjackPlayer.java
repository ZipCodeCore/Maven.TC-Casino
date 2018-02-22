package io.zipcoder.casino.Games.Blackjack;

import io.zipcoder.casino.*;

public class BlackjackPlayer{
    private String name;
    private Double balance;
    private Integer age;
    //private Card[] hand;
    private boolean canHit;

    public BlackjackPlayer(Player rootPlayer){
        this.name = rootPlayer.getName();
        this.age = rootPlayer.getAge();
        this.balance = rootPlayer.getBalance();
        //this.hand = new Card[];
        this.canHit = true;
    }
}
