package io.zipcoder.casino.Players;

public class BlackjackPlayer extends Player{
<<<<<<< HEAD
    private String name;
    private Integer balance;
    private Integer age;
=======
    protected Player rootPlayer;
>>>>>>> dev
    //private Card[] hand;
    protected boolean canHit;

    public BlackjackPlayer(Player rootPlayer){
        this.name = rootPlayer.getName();
        this.age = rootPlayer.getAge();
<<<<<<< HEAD
        //this.balance = rootPlayer.getBalance();
        //this.hand = new Card[];
=======
>>>>>>> dev
        this.canHit = true;
        this.rootPlayer = rootPlayer;
    }
}
