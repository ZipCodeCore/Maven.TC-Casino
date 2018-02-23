package io.zipcoder.casino.Players;

public class BlackjackPlayer extends Player{
    private String name;
    private Integer balance;
    private Integer age;
    //private Card[] hand;
    private boolean canHit;

    public BlackjackPlayer(Player rootPlayer){
        this.name = rootPlayer.getName();
        this.age = rootPlayer.getAge();
        //this.balance = rootPlayer.getBalance();
        //this.hand = new Card[];
        this.canHit = true;
    }
}
