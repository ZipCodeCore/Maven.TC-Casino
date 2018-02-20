package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Interfaces.Gamble;
import io.zipcoder.casino.Interfaces.Game;

import java.util.Scanner;

public class Craps extends Casino implements Gamble, Game {
    Scanner input = new Scanner(System.in);
    Player crapsplayer;
    //double playerCash = crapsplayer.balance; null pointer
    double bet;


    public Craps(Player player) {
        this.crapsplayer = player;
    }

    public boolean play() {
        boolean play = true;
        Console.print("Welcome to Craps");

        while (play) {

            Console.print("Player balance: " + format.format(crapsplayer.balance));

            takeBet();

            int rollONE = roll();
            int target = rollONE;

            if (rollONE == 7 || rollONE == 11) {
                playerWin(bet);
            } else if (rollONE == 2 || rollONE == 3 || rollONE == 12) {
                playerLose(bet);
            } else {
                Console.print("Target is now " + rollONE);
                int rollTWO = roll();
                checkRollTwo(rollTWO, rollONE);
                if (rollTWO == 7) {
                    playerLose(bet);
                }
            }
            play = playAgain();
        }
        crapsplayer.setBalance(crapsplayer.balance);
        gameOptions();
        return true;
    }


    public int roll() {
        Console.print("Press Enter key to roll");
        input.nextLine();
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;

        int sum = dice1 + dice2;

        Console.print("You rolled " + dice1 + " and " + dice2);
        Console.print("Rolled " + sum);
        return sum;
    }

    public int checkRollTwo(int rollTWO, int rollONE) {
        while (rollTWO != 7) {
            if (rollTWO == rollONE) {
                playerWin(bet);
                break;
            } else {
                Console.print("Target is " + rollONE);
            }
            rollTWO = roll();
        }
        return rollTWO;
    }

    private boolean playAgain() {
        String userinput = Console.getString("Play again? Y/N");
        return !userinput.equalsIgnoreCase("N") && !userinput.equalsIgnoreCase("no");
    }

    public double takeBet() {
        do {
            bet = Console.getDouble("Place your bet: ");
        } while (bet > crapsplayer.balance);
        return bet;
    }

    public void playerLose(double bet) {
        Console.print("You lose!");
        crapsplayer.balance -= bet;
    }

    public void playerWin(double bet) {
        Console.print("You win!");
        crapsplayer.balance += bet;
    }
}
