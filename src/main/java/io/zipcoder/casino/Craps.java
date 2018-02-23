package io.zipcoder.casino;

import java.util.Scanner;

public class Craps implements GameInterface, DiceGameInterface, GamblingInterface{

    private DiceManager crapsDice = new DiceManager(2);
    private int point = 0;
    private int passLineBet = 0;
    private int dontPassLineBet = 0;
    private boolean keepPlaying = true;
    private Scanner userInput = new Scanner(System.in);



    public void rollDice() {
        crapsDice.rollAllDice();
    }

    public int getNumberOfDice() {
        return 2;
    }

    public int checkChipAmount(Person personToCheck) {
        return personToCheck.getWallet().checkChipAmount();
    }

    public void placeBet(Person personPlacingBet, int betAmount) {

    }

    public int getAnte() {
        return 5;
    }

    public void bootPlayerFromGame(Person personToBoot) {

    }

    public int checkPot() {
        return 0;
    }

    public void start() {
        System.out.println("Welcome to Craps!");

    }

    public void comeOutRoll() {
        System.out.println("Time to make your first roll!");
        rollDice();
        System.out.println("You rolled a " + crapsDice.getTotalValue() + "!");
        checkComeOutRoll();
    }

    private void checkComeOutRoll(){
        if (crapsDice.getTotalValue() == 2 || crapsDice.getTotalValue() == 3 || crapsDice.getTotalValue() == 12) {
            System.out.println("You crapped out. Pass line bets loose and Don't-Pass bets win.");
        } else if (crapsDice.getTotalValue() == 7 || crapsDice.getTotalValue() == 11) {
            System.out.println("You rolled a natural! Pass Line bets win and Don't Pass looses.");
        } else {
            System.out.println("The point is now " + crapsDice.getTotalValue());
            point = crapsDice.getTotalValue();
        }
    }

    public void phaseTwoRolls() {
        System.out.println("Time for phase two! Roll a " + point + " and not a 7!");
        rollDice();
        System.out.println("You rolled a " + crapsDice.getTotalValue() + "!");
        checkPhaseTwoRolls();
    }

    private void checkPhaseTwoRolls() {
        if (crapsDice.getTotalValue() == point) {
            System.out.println("You rolled the point! Pass Line wins!");
        } else if (crapsDice.getTotalValue() == 7) {
            System.out.println("You rolled a 7. Don't Pass wins!");
        }
    }

    public void placePassLineBet() {

    }
}
