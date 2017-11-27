package io.zipcoder.casino;
import java.util.Scanner;

public class Craps extends CardGames implements Gamble{
    private static Dice dice1 = new Dice();
    private static Dice dice2 = new Dice();
    private static Scanner scanner = new Scanner(System.in);
    private Player player;
    private static Double betAmount;

    @Override
    public void takeBet() {
        Double amount = Console.getDoubleInput("How much money do you want to bet? " +
                "You currently have $" + String.format("%.2f", player.getMoney()));
        while (amount > player.getMoney() || amount <= 0) {
            Console.print("Please make sure you have entered a number greater than " +
                    "zero and less than or equal to $" + String.format("%.2f", player.getMoney()));
            amount = Console.getDoubleInput("How much money do you want to bet?");
        }
        betAmount = amount;
    }

    @Override
    public void play() {
        player = PlayerWarehouse.getCurrentPlayer();
        printWelcomeMessage();
        do {
            if (player.getMoney() == 0) {
                bootPlayer();
            }
            takeBet();
            Integer sumOfTwoDiceRolls = rollBothDice();
            if (sevenOrEleven(sumOfTwoDiceRolls)) {
                printWinMessage();
            } else if (twoThreeOrTwelve(sumOfTwoDiceRolls)) {
                printLoseMessage();
            } else {
                Integer target = sumOfTwoDiceRolls;
                Console.print("The new target is: " + target);
                do {
                    sumOfTwoDiceRolls = rollBothDice();
                } while (!sumOfTwoDiceRolls.equals(7) && !sumOfTwoDiceRolls.equals(target));
                if (sumOfTwoDiceRolls.equals(7)) {
                    printLoseMessage();
                } else if (sumOfTwoDiceRolls.equals(target)) {
                    printWinMessage();
                }
            }
        } while (playerStillWantsToPlay());
    }

    public void bootPlayer() {
        Console.print("Time for you to go to the ATM. Kicking you from the casino :)");
        System.exit(0);
    }

    public boolean playerStillWantsToPlay() {
        Console.print("\nDo you want to play another round? [Yes, No]");
        String response = scanner.nextLine();
        while (!response.equalsIgnoreCase("yes") && !response.equalsIgnoreCase("no")) {
            Console.print("Invalid response. Please enter yes or no.");
            response = scanner.nextLine();
        }
        if (response.equalsIgnoreCase("yes")) {
            return true;
        } else {
            return false;
        }
    }

    public void printLoseMessage() {
        Console.print("Sorry you lost!");
        printLosings(betAmount);
    }

    public void printLosings(Double amount) {
        Double newMoneyAmount = player.getMoney() - amount;
        player.setMoney(newMoneyAmount);
        Console.print(String.format("You now have $%.2f dollars :(", player.getMoney()));
    }

    public boolean twoThreeOrTwelve(Integer diceRollValue) {
        if (diceRollValue.equals(2) || diceRollValue.equals(3) || diceRollValue.equals(12))
            return true;
        return false;
    }

    public void printWinMessage() {
        Console.print("Congratulations you won!");
        printWinnings(betAmount);
    }

    public void printWinnings(Double amount) {
        Double newMoneyAmount = player.getMoney() + amount;
        player.setMoney(newMoneyAmount);
        Console.print(String.format("You now have $%.2f dollars!", newMoneyAmount));

    }

    public boolean sevenOrEleven(Integer diceRollValue) {
        if (diceRollValue.equals(7) || diceRollValue.equals(11))
            return true;
        return false;
    }

    public void printDiceRoll(Integer diceRollValue) {
        Console.print("You rolled a " + diceRollValue);
    }

    public Integer rollBothDice() {
        pressEnterToRoll();
        Integer sumOfRolls = dice1.roll() + dice2.roll();
        printDiceRoll(sumOfRolls);
        return sumOfRolls;
    }

    public String pressEnterToRoll() {
        Console.print("\nPress enter to roll:");
        return scanner.nextLine();
    }

    public void printWelcomeMessage() {
        Console.print("Welcome to craps " + player.getName() + "!");
    }
}