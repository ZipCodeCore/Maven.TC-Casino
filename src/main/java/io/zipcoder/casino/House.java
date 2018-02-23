package io.zipcoder.casino;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackGame;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFish;
import io.zipcoder.casino.Game.diceGame.Craps.CrapsGame;
import io.zipcoder.casino.Game.diceGame.DiceGame;

import java.util.ArrayList;
import java.util.HashMap;

public class House implements MainMenu {
    public static final House INSTANCE = new House();
    public static final Profile HOUSE_PROFILE = new Profile("Dealer", 0, 1);
    private Profile profile;
    private ArrayList<Profile> profiles;

    public House() {
        profiles = new ArrayList<>();
    }

    public Profile getProfileById(int id) {
        for (Profile profile : profiles) {
            if (profile.getId() == id) {
                return profile;
            }
        }
        return null;
    }

    public CardGame chooseCardGame(String cardGame, int id) {
        Profile playerProfile = getProfileById(id);
       /* if (cardGame.equalsIgnoreCase("Black Jack")) {
            BlackJackGame blackjack = new BlackJackGame(playerProfile);
            return blackjack;
        } else if (cardGame.equalsIgnoreCase("Gold Fish")) {
            GoFish goldFish = new GoFish(playerProfile);

            return goldFish;
        }*/
        return null;
    }

    public DiceGame chooseDiceGame(String diceGame, int id) {

        if (diceGame.equalsIgnoreCase("Craps")) {
            //Craps game needs to take in a player
//            CrapsGame craps = new CrapsGame(Player);
//            return craps;
        }
        return null;
    }


    public void createProfile(String name) {
        createProfile(name, 0, profiles.size() + 1);
    }

    public void createProfile(String name, double balance) {
        createProfile(name, balance, profiles.size() + 1);
    }


    public void createProfile(String name, double balance, int id) {
        profile = new Profile(name, balance, id);
        createProfile(profile);
    }

    public void createProfile(Profile profile) {
        Console.print("Registering a new profile...");
        profiles.add(profile);
    }

    public Profile selectExistingProfile(String name) {
        for (Profile profile : profiles) {
            if (profile.getName().equals(name)) {
                return profile;
            }
        }
        return null;
    }

    public void removeProfile(int id) {
        profiles.remove(id);
        Console.print("Profle was removed");
    }

}
