package io.zipcoder.casino.interfaces;

import io.zipcoder.casino.Player;

public interface Game {

    /**
     * Each game must require a player in order for it to play. The player is changed by the game.
     * @param player
     */
    void play(Player player);

    /**
     * Each game must have a way for the player to quit the game and go back to the main menu.
     */
    void quitGame();

    /**
     * The game must have a welcome prompt.
     */
    void runWelcome();

    /**
     * Makes it so that every game has a way to pull up the rules for the game.
     * @return rules
     */
    String getRules();

}
