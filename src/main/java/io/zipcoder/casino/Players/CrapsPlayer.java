package io.zipcoder.casino.Players;


public class CrapsPlayer extends Player {

    protected Player mainPlayer;


    public CrapsPlayer(Player mainPlayer) {
        this.age = mainPlayer.getAge();
        this.name = mainPlayer.getName();
        this.mainPlayer = mainPlayer;
    }


    public Player getMainPlayer() {
        return mainPlayer;
    }

    public void lostMoney(int money) {
        mainPlayer.wallet.subtract(money);
    }

    public void wonMoney(int money) {
        mainPlayer.wallet.add(money);
    }
}
