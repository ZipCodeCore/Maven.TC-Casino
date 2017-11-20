package io.zipcoder.casino;

import io.zipcoder.casino.Console.Console;
import io.zipcoder.casino.Interfaces.Gamble;


import java.util.Scanner;
import java.util.logging.Logger;

public class Craps implements Gamble{
    Logger logger = Logger.getGlobal();
    Scanner input = new Scanner(System.in);

    //    public void start() {
    public static void main(String[] args) {
        double playerCash = player.balance;
        boolean play = true;
        while (play == true) {

            System.out.println("Player cash: " + playerCash);
            double bet;

            do {
                bet = Console.getDouble("Place your bet: ");
            } while (bet > playerCash);

            int rollONE = roll();
            int target = rollONE;

            if (rollONE == 7 || rollONE == 11) {
                playerCash += bet * 2;
                System.out.println("You win!");
            } else if (rollONE == 2 || rollONE == 3 || rollONE == 12) {
                playerCash -= bet;
                System.out.println("You lose!");
            } else {
                System.out.println("Target is now " + rollONE);
                int rollTWO = roll();
                while (rollTWO != 7) {
                    if (rollTWO == rollONE) {
                        System.out.println("You win!");
                        playerCash += bet * 2;
                        break;
                    } else {
                        System.out.println("Target is " + rollONE);
                    }
                    rollTWO = roll();
                }
                if (rollTWO == 7) {
                    System.out.println("You lose!");
                    playerCash -= bet;
                }
            }
            System.out.println("Press enter to play again");
            try {
                System.in.read();

            } catch (Exception e) {
                play = false;
            }

        }
    }


    //    public int roll() {
    public static int roll() {
        System.out.println("Press Enter key to roll");
        //logger.info("Rolling...");
        try {
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }
        int dice1 = (int) (Math.random() * 6) + 1;
        int dice2 = (int) (Math.random() * 6) + 1;

        int sum = dice1 + dice2;

        System.out.println("You rolled " + dice1 + " and " + dice2 + "\n");
        System.out.println("Rolled " + sum);
        return sum;
    }


    @Override
    public void takeBet(double playerbet) {

    }


}
