package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Interfaces.Gamble;


import java.util.Scanner;
import java.util.logging.Logger;

public class Craps extends Casino implements Gamble {
    Scanner input = new Scanner(System.in);
    Player crapsplayer;
    //double playerCash = crapsplayer.balance; null pointer
    double bet;


    public Craps(Player player) {
        this.crapsplayer = player;
    }

    void start() {
        boolean play = true;

        while (play) {
            Console.print("Player balance: " + crapsplayer.balance);

            do {
                bet = Console.getDouble("Place your bet: ");
            } while (takeBet(bet));

            int rollONE = roll();
            int target = rollONE;

            if (rollONE == 7 || rollONE == 11) {
                playerWin(bet);
            } else if (rollONE == 2 || rollONE == 3 || rollONE == 12) {
                playerLose(bet);
            } else {
                Console.print("Target is now " + rollONE);
                int rollTWO = roll();
                while (rollTWO != 7) {
                    if (rollTWO == rollONE) {
                        playerWin(bet);
                        break;
                    } else {
                        Console.print("Target is " + rollONE);
                    }
                    rollTWO = roll();
                }
                if (rollTWO == 7) {
                    playerLose(bet);
                }
            }
            play = playAgain();
        }
        crapsplayer.setBalance(crapsplayer.balance);
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

    private boolean playAgain() {
        String userinput = Console.getString("Play again? Y/N");
        return !userinput.equalsIgnoreCase("N") && !userinput.equalsIgnoreCase("no");
    }

    public boolean takeBet(double bet) {
        return bet > crapsplayer.balance;
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
