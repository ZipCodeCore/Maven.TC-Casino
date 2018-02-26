package io.zipcoder.casino.interfaces;

import io.zipcoder.casino.core.Player;

public interface Game {

    /**
     * Each game must require a player in order for it to play. The player is changed by the game.
     *
     * @param player
     */
    void play(Player player);

    /**
     * The game must have a welcome prompt.
     */
    void runWelcome();

    /**
     * Makes it so that every game has a way to pullMany up the rules for the game.
     *
     * @return rules
     */
    String getRules();

}
