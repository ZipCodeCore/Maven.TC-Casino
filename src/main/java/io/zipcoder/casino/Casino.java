package io.zipcoder.casino;

public class Casino {
    private Player player;
    private Game running;


    public Casino() {

    }
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getRunning() {
        return running;
    }

    public void setRunning(Game running) {
        this.running = running;
    }


}

