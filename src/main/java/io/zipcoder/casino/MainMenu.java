package io.zipcoder.casino;

import java.util.*;
import java.util.Scanner;


public class MainMenu {

    Person player;
    Scanner in = new Scanner(System.in);

    public Person makePerson() {
        String name = "";
        String isGambling = "";
        int walletAmount = 0;

        System.out.println("Welcome to our casino! Please enter your name");
        name = in.nextLine();
        System.out.println("Hello " + name + ".  Will you be playing a gambling game? Please type y for yes and n for no");
        isGambling = in.nextLine();
        if (isGambling.equals("y")) {
            System.out.println("Please enter the number of chips you would like to start with");
            walletAmount = in.nextInt();
            player = new Person(name, walletAmount);
            System.out.println("Your wallet now has " + walletAmount);
        }
        if (isGambling.equals("n")) {
            player = new Person(name);
        }
        return player;
    }

//This method will be called from the Casino class.  The makePerson method is called inside chooseGame
    public void chooseGame() {
        String choice = "";
        makePerson();
        System.out.println("Please choose a game you would like to play from the following menu:\nWar\nGo Fish\n" +
                "Blackjack\nCraps\n");
        choice = in.nextLine().toLowerCase();
        switch(choice)
        {
            case "war":
                War.start();
                break;
            case "go fish":
                GoFish.start();
                break;
            case "blackjack":
                Blackjack.start();
                break;
            case "craps":
                Craps.start();
                break;
            default:
                System.out.println("Invalid Entry, please review the menu and choose a game. Thank you.");
                chooseGame();
        }
    }

}