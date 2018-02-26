package io.zipcoder.casino.Players;

public class BlackjackPlayer extends Player{

    protected Player rootPlayer;
    //private Card[] hand;
    protected boolean canHit;

    public BlackjackPlayer(Player rootPlayer){
        this.name = rootPlayer.getName();
        this.age = rootPlayer.getAge();

        this.canHit = true;
        this.rootPlayer = rootPlayer;
    }
}
