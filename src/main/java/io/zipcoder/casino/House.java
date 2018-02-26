package io.zipcoder.casino;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackGame;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackPlayer;
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
    private Profile currentPlayer;
    private double initialBalance;

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
        Console.print("");
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

    public void startCasino(){
        Console.print("Welcome to Casino Royale With Cheese!");
        Console.print("What is your name?");
        String profileName = Console.getString();
        Console.print("How much money do you want to deposit with the house?");
        Console.print("The minimum deposit is $100");
        Double accountBalance = this.intakeBalance();
        initialBalance = accountBalance;
        createProfile(profileName,accountBalance);
        currentPlayer = getProfileById(profiles.size());
        this.gameSelection();
    }

    public void gameSelection(){
        Console.print("Hello " + currentPlayer.getName());
        Console.print("You have $" + currentPlayer.getAccountBalance() + " to gamble with");
        Console.print("What game would you like to play?");
        Console.print("[Craps]");
        Console.print("[Black Jack]");
        Console.print("[Go Fish]");
        Console.print("Enter [leave] to cash out and go home");
       boolean keepRunning = true;
        do{
            String userInput = Console.getString();
            if(userInput.equalsIgnoreCase("craps")){
                CrapsGame newGame = new CrapsGame(currentPlayer);
                newGame.startGame();
                break;
            }
            else if(userInput.equalsIgnoreCase("black jack")){
                BlackJackGame newGame = new BlackJackGame(currentPlayer);
                newGame.startGame();
                break;
            }
            else if(userInput.equalsIgnoreCase("go fish")){
                GoFish newGame = new GoFish(currentPlayer);
                newGame.startGame();
                break;
            }
            else if(userInput.equalsIgnoreCase("leave")){
                Console.print("Goodbye " + currentPlayer.getName());
                Console.print("You're leaving our casino with $" + currentPlayer.getAccountBalance());
                if(currentPlayer.getAccountBalance()>initialBalance){
                    Console.print("That's $" + (currentPlayer.getAccountBalance()-initialBalance) + " more than you came here with!");
                    Console.print("Great job! Come again soon!");
                   System.exit(0);
                }
                else if (currentPlayer.getAccountBalance()<initialBalance){
                    Console.print("That's $" + (initialBalance-currentPlayer.getAccountBalance()) + " less than you came here with");
                    Console.print("Better luck next time.  Come again soon!");
                    System.exit(0);
                }
                else{
                    Console.print("That's exactly the amount you came here with");
                    Console.print("Maybe next time you'll be a winner.  Come again soon!");
                   System.exit(0);
                }
            }
            else{
                Console.print("Invalid selection: please enter your choice again");
            }
        }
        while(keepRunning);
    }

    public Double intakeBalance() {
        boolean keepRunning = true;
        do {
            Double accountBalance = Console.getDouble();
            if (accountBalance >= 0 && accountBalance < 100) {
                Console.print("Cannot deposit less than the minimum.  Please enter a valid deposit");
            } else if (accountBalance >= 100) {
                return accountBalance;
            } else if (accountBalance == -0.001) {
                continue;

            } else if (accountBalance < 0) {
                Console.print("Cannot deposit negative values.  Please enter a valid deposit");
            }
        }
        while (keepRunning == true);

        return 0d;
    }

}
