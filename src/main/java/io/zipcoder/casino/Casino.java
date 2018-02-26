package io.zipcoder.casino;


import java.util.Scanner;

import static io.zipcoder.casino.Person.createNewPlayerFromUserInput;


public class Casino {
    //both methods call methods that have Scanner and Wilhelm said you can't do tests on methods with Scanner

    //createNewPlayer creates a new player based on user input of their name
    //fillPlayerWallet fills the new player's wallet with chips based on user's input
    public static Person newPlayer() {
        Person player = createNewPlayerFromUserInput();
        player.getWallet().fillPlayerWalletFromUserInput();
        return player;
    }

    //first call newPlayer, then use the Person it returns as the parameter
    public static void sendPlayerToGame(Person player) {
        MainMenu menu = new MainMenu();
        boolean exitCasino = true;
        do {


            String choice = menu.displayGameChoices();
            Game myGame = MainMenu.chooseGame(choice, player);
            myGame.start();
            exitCasino = exitCasino();
        }while (exitCasino);
    }

    private static boolean exitCasino() {
        Scanner userInput = new Scanner(System.in);
        String userChoice;
        do {
            System.out.println("Would you like to play a different game? Yes or no.");
            userChoice = userInput.nextLine().toLowerCase();
        } while (!(userChoice.equals("yes")) && !(userChoice.equals("no")));
        if (userChoice.equals("yes")) {
            return true;
        } else {
            return false;
        }
    }

}
