package io.zipcoder.casino.shady;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.utils.IOHandler;

/**
 * filename:
 * project: casino
 * author: https://github.com/vvmk
 * date: 2/25/18
 */
public class ManInBlack {
    private final String fFIRST_VISIT = "first Visit";
    private final String fSECOND_VISIT = "second visit";
    private final String fTOO_MUCH_DEBT_VISIT = "too much debt, play one more to wipe your debt?";
    private final String fRUN = "you turn around to run, but the man in black is already behind you...last chance, kid. play?";
    private final String fTRUE_FORM = "[true form]";
    private final String fPLAY = "the man in black scores three sixes.";
    private final String fROCK_OFF = "[rock off]";
    private final String fTAKE_SOUL = "you lose";
    private Player[] ledger;
    private boolean validChoice;

    public void ManInBlack() {
        //TODO: pull ledger from disk
        ledger = new Player[1];
        validChoice = false;
    }

    public void proposition(Player player) {
        selectGameTrack(player);
        //handle player's choice
    }

    protected void selectGameTrack(Player player) {
        String choice;
        validChoice = false;
        do {
            if (player.getDebt() == 0) {
                choice = IOHandler.promptForStringWithMessage(fFIRST_VISIT);
                businessAsUsual(player, choice);
            } else if (player.getDebt() < 1000000) {
                choice = IOHandler.promptForStringWithMessage(fSECOND_VISIT);
                businessAsUsual(player, choice);
            } else {
                choice = IOHandler.promptForStringWithMessage(fTOO_MUCH_DEBT_VISIT);
                if (choice.equalsIgnoreCase("run"))
                    tryToRun();
                else if (choice.equalsIgnoreCase("play"))
                    tryToWin();
            }
        } while (!validChoice);
    }

    protected void businessAsUsual(Player player, String choice) {
        if (choice.equalsIgnoreCase("yes"))
            loanMoney(player);
        else if (choice.equalsIgnoreCase("no"))
            friendlyGoodbye();
    }

    protected void loanMoney(Player player) {
        int chipsToAdd = IOHandler.promptForIntWithMessage("How many chips would you like??");
        player.addChips(chipsToAdd);
        player.addDebt(chipsToAdd);
        validChoice = true;
    }

    protected void tryToRun() {
        String choice = IOHandler.promptForStringWithMessage(fRUN);
        if (choice.equalsIgnoreCase("run")) {
            IOHandler.printMessage("You try to run around him. Turns out he's the devil. He devours your still-beating heart.");
            collectDebt();
        } else if (choice.equalsIgnoreCase("play")) {
            tryToWin();
        } else if (choice.equalsIgnoreCase("eat a dick"))
            tellHimToEatADick();
    }

    protected void tryToWin() {
        IOHandler.printMessage(fPLAY);
        collectDebt();
    }

    protected void tellHimToEatADick() {
        String choice = IOHandler.promptForStringWithMessage("The man in black laughs. " +
                "Turns out, he's the devil.\n\n \"I'm going to enjoy ripping that tongue of yours right out of your mouth\". \n");
        if (choice.equalsIgnoreCase("rock off"))
            challengeToRockOff();
        else
            losePatience();

    }

    protected void losePatience() {
        IOHandler.printMessage("The devil grows impatient. He beats you to death with your own skull.\n");
        collectDebt();
    }

    protected void challengeToRockOff() {
        IOHandler.printMessage("FUCK! The Demon's Code prevents me from declining a rock-off challenge! What are your terms?\n");
        String terms = IOHandler.promptForStringWithMessage("What do you want from the devil?: ");
        IOHandler.printMessage("FINE! Let the rock-off begin! \n\nThe devil plays the tastiest, most evil lick you have ever heard. \n" +
                "Now its your turn...Time to blow this fucker down!");
        String song = IOHandler.promptForStringWithMessage("What song do you play?");
        if (song.equalsIgnoreCase("friday")) {
            IOHandler.printMessage("The devil tolerates no more than one note before ridding this plane of your pitiful existence. \n\n" +
                    "(Friday? Really? You deserved this.)\n");
            collectDebt();
        }
        IOHandler.printMessage("Inspiration strikes as you stare eternal damnation in the face. " +
                "After a 26 minute guitar solo that could rend asunder the very heavens, the devil is forced to concede to your terms and " + terms +
                "\n\nYou exit the casino, triumphant, soul intact, and not entirely sure any of this actually happened.");

        System.exit(0);
        //Trust me KG, it's the only whay.
    }

    protected void collectDebt() {
        //you lose
    }

    protected void friendlyGoodbye() {
        IOHandler.printMessage("Come back any time...");
        validChoice = true;
    }

    protected boolean isValidChoice(String choice) {
        return true;
    }
}
