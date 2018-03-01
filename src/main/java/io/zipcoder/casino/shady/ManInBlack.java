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
    private final String fFIRST_VISIT = "You walk over to a shady corner and see a shady man wearing a black suit. \"Down on your luck, friend?" +
            " Need a little help?\" (yes/no)";
    private final String fSECOND_VISIT = "Welcome back. Need a few more chips? Today's your lucky day, I can feel it. (yes/no)";
    private final String fTOO_MUCH_DEBT_VISIT = "\"You sure have built up quite a large debt.\"\n" +
            "The Man in Black suggests ONE MORE GAME of Cee-lo to settle your bet. 'play'? (you could try to 'run' away, too)";
    private final String fRUN = "You turn around to run, but the man in black is already behind you...last chance, kid. play?\n" +
            "You can take your chances and 'play', or you might be able to 'run' around him...";
    private final String fPLAY = "You agree to one more game without asking what happens if you lose. The Man in Black \n" +
            "produces three bone-white dice seemingly from nowhere and throws them into the air...\n" +
            "\n...He rolls three sixes. With an evil grin, he gestures toward a door behind him that you hadn't noticed before. \n" +
            "The Man in Black follows you through the door and shuts it behind him, his laughter unnoticed amidst the \n" +
            "cheerful bells and dings of the Casino's slot machines.";
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
        for (; ; ) {
        String choice = IOHandler.promptForStringWithMessage(fRUN);
            if (choice.equalsIgnoreCase("run")) {
                IOHandler.printMessage("You try to run around him. The Man in Black grabs your arm with an unnaturally strong grip. \n" +
                        "He opens a previously unnoticed door with his free hand and pushes you through.");
                collectDebt();
            } else if (choice.equalsIgnoreCase("play")) {
                tryToWin();
            } else if (choice.equalsIgnoreCase("eat a dick"))
                tellHimToEatADick();
            else {
                IOHandler.printMessage("That's not going to work...");
            }
        }
    }

    protected void tryToWin() {
        IOHandler.printMessage(fPLAY);
        collectDebt();
    }

    protected void tellHimToEatADick() {
        String choice = IOHandler.promptForStringWithMessage("The man in black laughs. " +
                "Flames erupt from his eyes and the Casino begins to crumble around you.\n\n \"I'm going to enjoy ripping that tongue of yours right out of your mouth\". \n" +
                "Its probably too late to start praying...");
        if (choice.equalsIgnoreCase("rock off"))
            challengeToRockOff();
        else
            losePatience(choice);

    }

    protected void losePatience(String choice) {
        IOHandler.printMessage("The devil shrugs off your pitiful attemt to " + choice + " and beats you to death with your own skull.\n");
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
                "After a 26 minute guitar solo \nthat could rend asunder the very heavens, the devil is forced to concede to your terms \nand give you " + terms +
                "\n\nYou exit the casino, triumphant, soul intact, and not entirely sure any of this actually happened.");

        System.exit(0);
        //Trust me KG, it's the only whay.
    }

    protected void collectDebt() {
        IOHandler.printMessage("YOU LOSE");
        System.exit(0);
    }

    protected void friendlyGoodbye() {
        IOHandler.printMessage("Come back any time...");
        validChoice = true;
    }
}
