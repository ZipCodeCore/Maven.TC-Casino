package io.zipcoder.casino.core;

import io.zipcoder.casino.games.blackjack.BlackJack;
import io.zipcoder.casino.games.ceelo.CeeLo;
import io.zipcoder.casino.games.crazy8s.Crazy8Game;
import io.zipcoder.casino.games.roulette.Roulette;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.shady.ManInBlack;
import io.zipcoder.casino.utils.IOHandler;

public class Casino {
    private final String fPLAYER_BROKE_MSG = "You're out of money, chum. Maybe try a nice safe game like Crazy 8s.";
    private final String fSHADY_MESSAGE = "pssst...hey, you (type 666 to check it out. Something doesn't feel right...)";
    private Player player;
    private Game currentGameRunning;
    private ManInBlack manInBlack;

    public Casino() {
        this.player = new Player();
        this.manInBlack = new ManInBlack();
    }

    protected static boolean playerIsBroke(Player playerToCheck) {
        return playerToCheck.getBalance() == 0;
    }

    @SuppressWarnings("all")
    public void enter() {
        for (; ; ) {
            if (playerIsBroke(player)) {
                showShadyMessage();
            }
            int userInput = IOHandler.promptForIntWithMessage(runWelcomeMenu());
            currentGameRunning = changeGameState(handleInput(userInput));
            if (currentGameRunning != null)
                currentGameRunning.play(player);
        }
    }

    public String runWelcomeMenu() {
        return IOHandler.getMessageFromFile("CasinoWelcomeMenu.txt");
    }

    public int handleInput(int userInput) {
        switch (userInput) {
            case 1:
            case 3:
            case 4:
                if (playerIsBroke(player)) {
                    IOHandler.printMessage(fPLAYER_BROKE_MSG);
                    return -1;
                }
                break;
            case 5:
                goodBye();
                break;
            case 666:
                if (playerIsBroke(player))
                    visitManInBlack();
            default:
                runWelcomeMenu();
        }
        return userInput;
    }

    public Game changeGameState(int answer) {
        switch (answer) {
            case 1:
                currentGameRunning = new BlackJack();
                break;
            case 2:
                currentGameRunning = new Crazy8Game();
                break;
            case 3:
                currentGameRunning = new CeeLo();
                break;
            case 4:
                currentGameRunning = new Roulette();
                break;
            default:
                currentGameRunning = null;
                break;
        }
        return currentGameRunning;
    }

    public void goodBye() {
        IOHandler.getMessageFromFile("Goodbye.txt");
        System.exit(0);
    }

    protected void showShadyMessage() {
        IOHandler.printMessage(fSHADY_MESSAGE);
    }

    protected void visitManInBlack() {
        manInBlack.proposition(player);
    }
}

