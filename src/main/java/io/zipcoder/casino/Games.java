package io.zipcoder.casino;

public interface Games {
    public void play(Player);
    public void quitGame();
    public void runWelcome();
    public String getRules();
}
