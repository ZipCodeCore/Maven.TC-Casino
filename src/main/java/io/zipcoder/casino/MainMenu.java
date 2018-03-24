package io.zipcoder.casino;

import java.awt.*;
import java.util.*;
import java.util.Scanner;


public class MainMenu {

    Game game;

    public MainMenu() {
        this.game = game;
    }

    public void setMainMenu(Game game) {
        this.game = game;
    }

    public Game getMainMenu() {
        return game;
    }

    public String displayGameChoices() {
        Scanner in = new Scanner(System.in);
        String choice;
        do {
            System.out.println("Please choose a game from the following menu:\nWar\nGo Fish\nBlackJack\nCraps" +
                    "\nCoin Flipper");
            choice = in.nextLine().toLowerCase();
        } while ( !(choice.equals("craps")) && !(choice.equals("go fish")) && !(choice.equals("war")) &&
                !(choice.equals("blackjack")) && !(choice.equals("coin flipper")));
        return choice;
    }



    public static Game chooseGame(String choice, Person player) {

        Game game;
        switch (choice) {
            case "war":
                game = new War(player);
                break;
            case "go fish":
                game = new GoFish(player);
                break;
            case "blackjack":
                game = new Blackjack(player);
                break;
            case "craps":
                game = new Craps(player);
                break;
            case "coin flipper":
                game = new CoinFlipper(player);
                break;

            default:
                return null;
        }

        return game;
    }

}