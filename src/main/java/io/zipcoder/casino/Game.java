package io.zipcoder.casino;

public interface Game {
    public void play(Player p1);

    public void quitGame();

    public void runWelcome();

    public String getRules();

}
