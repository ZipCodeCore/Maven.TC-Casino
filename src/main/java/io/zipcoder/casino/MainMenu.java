package io.zipcoder.casino;

import java.util.*;
import java.util.Scanner;


public class MainMenu {

    Game game;

    public MainMenu(){
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
        System.out.println("Please choose a game from the following menu:\nWar\nGo Fish\nBlackJack\nCraps");
        String choice = in.nextLine().toLowerCase();
        return choice;
    }


    public static Game chooseGame(String choice, Person player) {

        Game game;
        switch(choice)
        {
            case "war":
                game = new War(player);
                break;
            case "go fish":
                //game = new GoFish(player);
                break;
            case "blackjack":
                game = new Blackjack(player);
                break;
            case "craps":
                game = new Craps(player);
                break;
            default:
                return null;
        }

        return game = new Blackjack(player);
    }

}