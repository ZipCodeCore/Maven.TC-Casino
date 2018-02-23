package io.zipcoder.casino;

import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.diceGame.DiceGame;

public interface MainMenu {
    public CardGame chooseCardGame(String game, int id);
    public DiceGame chooseDiceGame(String game, int id);
    public void createProfile(String name, double balance);
    public Profile selectExistingProfile(String nameOfPlayer);
    public void removeProfile(int id);
}
