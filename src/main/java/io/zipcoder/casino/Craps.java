package io.zipcoder.casino;

public class Craps implements Gamble<CrapsPlayer>, Games<CrapsPlayer> {

    private String playAgain = "yes";

    int pot;

    Die d1;
    Die d2;

    int bet4or10 = 0;
    int bet5or9 = 0;
    int bet6or8 = 0;

    @Override
    public void play(CrapsPlayer player) {

        do {
            d1 = new Die();
            d2 = new Die();
            int pointValue;
            int rollValue;


            printCurrentChips(player);
            pot = takeBet(player);

            rollDice();
            rollValue = d1.getValue() + d2.getValue();
            printDiceValue(d1, d2);

            if (rollValue == 7 || rollValue == 11) {
                // Win
                int winnings = pot * 2;
                printWinOrLose("win", winnings);
                payOut(player, pot, 2);
                playAgain = Console.getStringInput("Play Again?");

            } else if (rollValue == 2 || rollValue == 3 || rollValue == 12) {
                // Lose
                printWinOrLose("lose", 0);
                playAgain = Console.getStringInput("Play Again?");
                continue;
            } else {
                pointValue = rollValue;
                do {

                    printCurrentChips(player);
                    // prompt for bets on next roll group (4 & 10, 5 & 9, or 6 & 8)
                    placeSideBet(player);

                    rollDice();
                    rollValue = d1.getValue() + d2.getValue();
                    printDiceValue(d1, d2);

                    int winnings = handlePointerRoll(pointValue, rollValue);

                    payOut(player, winnings, 2);

                }
                while (rollValue != pointValue && rollValue != 7);

                resetBets();
                playAgain = Console.getStringInput("Play Again?");
            }



        } while ("yes".equalsIgnoreCase(playAgain));
    }

    @Override
    public Integer takeBet(CrapsPlayer player) {
        Integer bet;
        bet = Console.getIntegerInput("Place your bet");
        player.placeBet(bet);

        return bet;
    }

    @Override
    public void resetBets() {
        pot = 0;
        clearSideBets();
    }

    private void rollDice() {
        d1.rollDie();
        d2.rollDie();
    }

    private int handlePointerRoll(int pointValue, int rollValue) {

        int retValue = 0;

        switch (rollValue) {

            case 4:
                retValue = determineRollPayout(rollValue, pointValue, 10, bet4or10);
                break;
            case 5:
                retValue = determineRollPayout(rollValue, pointValue, 9, bet5or9);
                break;
            case 6:
                retValue = determineRollPayout(rollValue, pointValue, 8, bet6or8);
                break;
            case 7:
                // Lose
                printWinOrLose("lose", 0);
                retValue = 0;
                clearSideBets();
                break;
            case 8:
                retValue = determineRollPayout(rollValue, pointValue, 6, bet6or8);
                break;
            case 9:
                retValue = determineRollPayout(rollValue, pointValue, 5, bet5or9);
                break;
            case 10:
                retValue = determineRollPayout(rollValue, pointValue, 4, bet4or10);
                break;
            default:
                break;
        }
        return retValue;
    }

    private int determineRollPayout(int rollValue, int pointValue, int sideValue, int groupBets) {
        int retValue;
        if (pointValue == rollValue) {
            int total = pot + bet4or10;
            printWinOrLose("win", total);
            retValue = total;
            pot = 0;
            clearSideBets();
        } else if (sideValue == rollValue && groupBets < 0) {
            printWinOrLose("win", groupBets);
            retValue = groupBets;
            clearSideBets();
        } else {
            printWinOrLose("lose", 0);
            retValue = 0;
            clearSideBets();
        }
        return retValue;
    }

    private void printDiceValue(Die d1, Die d2) {
        int total = d1.getValue() + d2.getValue();
        System.out.println("You rolled a :" + d1.getValue() + " and a " + d2.getValue());
        System.out.println("You have a combined value of " + total);
    }

    private void printCurrentChips(CrapsPlayer player) {
        System.out.println("\nYou currently have " + player.getChipCount() + " chips.\n");
    }

    private void printWinOrLose(String input, int value) {
        if("win".equals(input)) {
            System.out.println("");
            System.out.println("Congratulations! You win!");
            System.out.println("You won: " + value + " chips!");
            System.out.println("");
        }
        else if ("lose".equals(input)) {
            System.out.println("Sorry, a Winrar\u00A9 is not you.");
            System.out.println("Better luck next time.");
        }
        else {
            System.out.println("What are you trying to pull here? Lrn2spelling my boy.");
        }
    }

    private int placeSideBet(CrapsPlayer player) {
        boolean isValidInput = false;
        int retValue = -1;

        while (isValidInput == false) {
            String group = Console.getStringInput("Which group would you like to bet on?\n" +
                    "[4 & 10]\t[5 & 9]\t[6 & 8]\tNONE");
            if (group.equals("4 & 10") || group.equals("4&10") || group.equals("4") || group.equals("10")) {
                bet4or10 = takeBet(player);
                isValidInput = true;
            } else if (group.equals("5 & 9") || group.equals("5&9") || group.equals("5") || group.equals("9")) {
                bet5or9 = takeBet(player);
                isValidInput = true;
            } else if (group.equals("6 & 8") || group.equals("6&8") || group.equals("6") || group.equals("8")) {
                bet6or8 = takeBet(player);
                isValidInput = true;
            } else if (group.equalsIgnoreCase("NONE")) {
                retValue = 0;
                isValidInput = true;
            } else {
                System.out.println("Invalid input. Try again");
            }
        }
        return retValue;

    }

    private void clearSideBets() {
        bet4or10 = 0;
        bet5or9 = 0;
        bet6or8 = 0;
    }

    public void payOut(CrapsPlayer player, int value, int multiplier) {
        player.addChips(value * multiplier);
    }

}