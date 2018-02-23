package io.zipcoder.casino.Game;

import io.zipcoder.casino.Player;

public interface Game {

    public void addPlayer(Player player);
    public void removePlayer (Player player);
    public void startGame();
    public void endGame();
    public String getRules();
}
