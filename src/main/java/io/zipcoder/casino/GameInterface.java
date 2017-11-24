package io.zipcoder.casino;

public class GameInterface {

    public static void playCraps() {

        String playAgain;
        do {

            System.out.println("Welcome to the craps table. How many people are playing");
            CrapsPlayer first = new CrapsPlayer(Console.getUserInputString("What is the first players name?"), Console.getUserInputDouble("How much money are you bringing to the table?"));
            first.firstRoll();
            playAgain = Console.getUserInputString("Do you want to continue playing?");
            first.getName();
        } while (playAgain.equals("no"));


    }

    public static void playBlackjack() {

        String playAgain;
        do {

            System.out.println("Welcome to the Blackjack table");
            BlackjackPlayer blackjackPlayer = new BlackjackPlayer(Console.getUserInputString("What is your name?"),
                    Console.getUserInputDouble("How much money are you bringing to the table?"));
            BlackJack.start();
            playAgain = Console.getUserInputString("Do you want to play another game of Blackjack?");
            //the below line to retrieve the same player name from previous game if player wants to continue may fail...
            //so may need to rewrite, won't know until we test the game-play from console itself
            blackjackPlayer.getName();
        } while (playAgain.equals("no"));


    }


    public static void playGoFish() {


    }
}

