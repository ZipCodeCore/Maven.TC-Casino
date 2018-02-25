package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.interfaces.Game;

public class Crazy8Play implements Game
{
    @Override
    public void play(Player player) {
        Crazy8sMenu start = new Crazy8sMenu();

        start.showMenu();
    }

    @Override
    public void quitGame() {

    }

    @Override
    public String runWelcome() {
        return null;
    }

    @Override
    public String getRules() {
        return null;
    }
}
