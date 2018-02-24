package io.zipcoder.casino.Factories;

import io.zipcoder.casino.Players.Player;

public class PlayerFactory extends Player {

    public static Player createPlayer(String name, Integer age) {
        return new Player(name, age);
    }

    public static Player createPlayer(String name, Integer age, Integer balance) {
        return new Player(name, age, balance);
    }

}
