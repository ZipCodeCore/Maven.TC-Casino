package io.zipcoder.casino;

public abstract class Game {

    private Player player;
    private Player dealer;

    public Game() {
        player = new Player();
        dealer = new Player(); //make Player constructor that takes name parameter; for "Dealer"
    }

    //TODO: implement play
    void play() { }

    //TODO: implement reportWinner
    void reportWinner() { }

    //TODO: implement start
    public abstract void start();


}
