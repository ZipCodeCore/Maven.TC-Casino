package io.zipcoder.casino;

import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.diceGame.DiceGame;

public interface MainMenu {
    public CardGame chooseCardGame(String game, int id);
    public DiceGame chooseDiceGame(String game);
    public void createProfile(String name, double balance);
    public void createPlayer(Profile profile);
    public Profile selectExistingProfile(String nameOfPlayer);
    public void removeProfile(int id);
    public void removePlayer(int id);
}
