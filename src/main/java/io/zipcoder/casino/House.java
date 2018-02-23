package io.zipcoder.casino;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackGame;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.diceGame.DiceGame;

import java.util.ArrayList;
import java.util.HashMap;

public class House implements MainMenu {
    //private Game someGame;
    private Profile profile;
    private ArrayList<Profile> profiles;
    private HashMap<Integer, Player> mapOfPlayers;

    public House() {
        profiles = new ArrayList<>();

        mapOfPlayers = new HashMap<>();
    }

    public Profile getProfileById(int id) {
        for (Profile profile : profiles) {
            if (profile.getId() == id) {
                return profile;
            }
        }
        return null;
    }

    public Player getPlayerById(int id) {
        return mapOfPlayers.get(id);
    }

    public CardGame chooseCardGame(String cardGame, int id) {

        Player player = getPlayerById(id);

        if (cardGame.equals("Black Jack")) {
            BlackJackGame blackjack = new BlackJackGame(player);
        }

        return null;
    }

    public DiceGame chooseDiceGame(String game) {
        return null;
    }


    public void createProfile(String name) {
        createProfile(name, 0, profiles.size() + 1);
    }

    public void createProfile(String name, double balance) {
        createProfile(name, balance, profiles.size() + 1);
    }


    public void createPlayer(Profile profile) {
        int id = profile.getId();
        Player player = new Player(profile);
        mapOfPlayers.put(id, player);
        Console.print("Player was added");
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

    @Override
    public void removePlayer(int id) {
     mapOfPlayers.remove(id);
     Console.print("Player was Removed");
    }


}
