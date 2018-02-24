package io.zipcoder.casino;

import java.util.Scanner;

public class Casino {

    //put in person class?
    /*
    private Person createPlayer() {

        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to our casino! Please enter your name");
        this.name = in.nextLine();
 //if in person class these next lines would be deleted/////
        player = new Person(name);
        System.out.println("Welcome " + name);
        return player;
    }*/

    //lets player fill wallet if going to be playing gambling game
    public void fillPlayerWallet(Person player) {
        String isGambling;
        int walletAmount;
        Scanner in = new Scanner(System.in);
        System.out.println("If you will be playing a gambling game press y.");
        isGambling = in.nextLine();
        if(isGambling.equals("y")) {
            System.out.println("Please enter number of chips you would like to begin with");
            walletAmount = in.nextInt();
            player.getWallet().addChipsToAmount(walletAmount);
        }
    }

    public void chooseGameFromMainMenu(){
        Person player = createPlayer();
        MainMenu menu = new MainMenu();
        String choice = menu.displayGameChoices();
        Game myGame = menu.chooseGame(choice, player);
        myGame.start();
    }

}
