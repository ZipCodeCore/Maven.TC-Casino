package io.zipcoder.casino;


import java.util.ArrayList;

import static io.zipcoder.casino.Utilities.*;

public class Casino {

    private static ArrayList<Console> gameConsoles = new ArrayList<>();

    public static void startCasino() {
        gameConsoles.add(new BlackJackConsole());
        gameConsoles.add(new CrapsConsole());
        gameConsoles.add(new GoFishConsole());

        while(true) {
            selectGameToPlay();
        }
    }

    public static void selectGameToPlay() {
        ArrayList<String> gameNames = new ArrayList<>();
        for(Console console : gameConsoles) {
            gameNames.add(console.getNameOfGame());
        }
        gameNames.add("EXIT");

        printMenuName("Select a game to play");
        printMenuOptions(gameNames);
        String choice = getMenuInput(">> ", gameNames).toUpperCase();
        goToGame(choice);
    }

    public static void goToGame(String gameName) {
        switch (gameName) {
            case "BLACKJACK":
                startBlackJack();
                break;
            case "CRAPS":
                startCraps();
                break;
            case "GO FISH":
                startGoFish();
                break;
            case "EXIT":
                System.exit(0);
                break;
        }
    }

    public static void startBlackJack() {
        gameConsoles.get(0).start();
    }

    public static void startCraps() {
        gameConsoles.get(1).start();
    }

    public static void startGoFish() {
        gameConsoles.get(2).start();
    }
}
