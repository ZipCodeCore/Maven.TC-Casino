package io.zipcoder.casino.core;

import io.zipcoder.casino.games.blackjack.BlackJack;
import io.zipcoder.casino.games.ceelo.CeeLo;
import io.zipcoder.casino.games.crazy8s.Crazy8Game;
import io.zipcoder.casino.games.roulette.Roulette;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

public class Casino {
    private Player player;
    private Game currentGameRunning;

    public Casino() {
        this.player = new Player();
    }

    @SuppressWarnings("all")
    public void enter() {
        for (; ; ) {
            int userInput = IOHandler.promptForIntWithMessage(runWelcomeMenu());
            handleInput(userInput);
            currentGameRunning = changeGameState(userInput);
            if (currentGameRunning != null)
                currentGameRunning.play(player);
        }
    }


    public String runWelcomeMenu() {
        return IOHandler.getMessageFromFile("CasinoWelcomeMenu.txt");
    }

    public int handleInput(int userInput) {
        switch (userInput) {
            case 5:
                goodBye();
                return userInput;
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
                System.out.println("[ SORRY! OUT OF ORDER! ]\n");
                break;
            case 3:
                currentGameRunning = new CeeLo();
                break;
            case 4:
                currentGameRunning = new Roulette();
                break;
            case 5:
                goodBye();

        }
        return currentGameRunning;
    }

    public void goodBye() {
        IOHandler.getMessageFromFile("Goodbye.txt");
        System.exit(0);
    }

}

