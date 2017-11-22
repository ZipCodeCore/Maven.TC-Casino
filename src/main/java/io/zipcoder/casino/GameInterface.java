package io.zipcoder.casino;

public class GameInterface {

    public static void playCraps() {
        String playAgain;
        do {

            System.out.println("Welcome to the craps table. How many people are playing");
            CrapsPlayer first = new CrapsPlayer(Console.getUserInputString("What is the first players name?"), Console.getUserInputDouble("How miuch omoney are you bringing to the table?"));
            first.firstRoll();
            playAgain = Console.getUserInputString("Do you want to continue playing?");
            first.getName();
        } while (playAgain.equals("no"));


    }

    public static void playBlakcjack() {


    }

    public static void playGoFish() {


    }
}
