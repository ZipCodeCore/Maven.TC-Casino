package io.zipcoder.casino;

import java.util.Scanner;

public class CoinFlipper extends Game implements GameInterface{

    private Person player = new Person("Joe");
    Scanner input = new Scanner(System.in);

    public CoinFlipper(Person player) {
        // this.player = player;
        // Un-note ^ this when added to main
    }

    public void start() {
        System.out.println("Welcome to Coin Flipper!");
        System.out.println("In this simple game you can bet on whether the coin will land on heads or tails.");
        System.out.println("If you win, you get double what you bet!  But if you lose, you get nothing!");
        System.out.println("If you're feeling lucky, enter how much you would like to bet and hit enter:");
    }

    public void newGame() {
        if (checkChipAmount(player) == 0) {bootPlayerFromGame();}

    }

    public int checkChipAmount(Person personToCheck) {
        return personToCheck.getWallet().checkChipAmount();
    }

    public void placeBet(Person personPlacingBet, int betAmount) {

    }

    public void bootPlayerFromGame() {
        System.out.println("Sorry, you're out of money!  Bye-bye!");
    }

    public void end() {
        System.out.println("Thanks for playing!");
    }

}
