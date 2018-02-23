package io.zipcoder.casino.Players;

public class CrapsPlayer extends Player{
    protected Player mainPlayer;
    public CrapsPlayer(Player mainPlayer){
        this.name = mainPlayer.getName();
        this.age = mainPlayer.getAge();

    }
}
