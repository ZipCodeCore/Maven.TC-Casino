package io.zipcoder.casino;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.diceGame.DiceGame;

import java.util.ArrayList;

public class House implements MainMenu {
    //private Game someGame;
    private Profile profile;
    private ArrayList<Profile> profiles;

    public House() {
        profiles = new ArrayList<>();
        this.profile = profile;
    }

    public Profile getProfileById(int id) {
        for (Profile profile : profiles) {
            if (profile.getId() == id) {
                return profile;
            }
        }
        return null;
    }

    public CardGame chooseCardGame(String cardGame) {
        return null;
    }

    public DiceGame chooseDiceGame(String game) {
        return null;
    }

    public void createProfile(String name, double balance) {

        int id =  profiles.size() +1;
        profile = new Profile(name, balance, id);
        profiles.add(profile);
    }

    public Profile selectExistingProfile(String nameOfPlayer) {
        //if(profile.getName().equals(nameOfPlayer);

        return null;
    }

    public void removeProfile(String nameOfPlayer) {

    }
}
