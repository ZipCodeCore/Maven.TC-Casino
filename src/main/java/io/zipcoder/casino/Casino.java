package io.zipcoder.casino;

public class Casino {
    private Player player;
    private Games running;


    public Casino() {

    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Games getRunning() {
        return running;
    }

    public void setRunning(Games running) {
        this.running = running;
    }


}

