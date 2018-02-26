package io.zipcoder.casino;

import java.util.Scanner;

public class CoinFlipper extends Game implements GameInterface{

    private boolean gameIsRunning;
    private Person player = new Person("Joe");
    private Scanner input = new Scanner(System.in);
    private Coin coin = new Coin();

    public CoinFlipper(Person player) {
        this.player = player;
        // Un-note ^ this when added to main
    }

    public void start() {
        gameIsRunning = true;
        System.out.println("Welcome to Coin Flipper!");
        System.out.println("In this simple game you can bet chips on a lucky coin.");
        System.out.println("If it lands on heads, you get double your money!  But if it lands on tails, you get nothing!");
        System.out.println("If you're feeling lucky, enter how much you would like to bet and hit enter:");
        engine();
    }

    public void engine() {
        while (gameIsRunning == true) {
            int thisRoundsBet = 0;
            if (checkChipAmount(player) == 0) {bootPlayerFromGame();}
            if (input.hasNextInt()) {
                thisRoundsBet = input.nextInt();
                placeBet(player, thisRoundsBet);
            } else {
                System.out.println("Invalid input!  Bye-bye!");
                end();
            }
            String coinFace = coin.flip();
            if (coinFace.equals("heads")) {
                int payout  = thisRoundsBet*2;
                System.out.println("Heads!  You win!  Your payout: " + payout);
                player.getWallet().addChipsToAmount(payout);
            } else {
                System.out.println("Tails!  You lose!");
            }
            System.out.println("Enter another bet to play again, or enter anything else to quit");
        }
    }

    public int checkChipAmount(Person personToCheck) {
        return personToCheck.getWallet().checkChipAmount();
    }

    public void placeBet(Person personPlacingBet, int betAmount) {
        personPlacingBet.getWallet().removeChipsFromAmount(betAmount);
    }

    public void bootPlayerFromGame() {
        gameIsRunning = false;
        System.out.println("Sorry, you're out of money!  Bye-bye!");
    }

    public void end() {
        System.out.println("Thanks for playing!");
        gameIsRunning = false;
    }

}
