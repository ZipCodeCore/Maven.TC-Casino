package io.zipcoder.casino.core;

import io.zipcoder.casino.games.blackjack.BlackJack;
import io.zipcoder.casino.games.ceelo.CeeLo;
import io.zipcoder.casino.games.crazy8s.Crazy8Play;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

public class Casino {
    private Player player;
    private Game currentGameRunning;

    public Casino() {

        this.player = player;
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
            case 1:
                changeGameState(userInput);
                runWelcomeMenu();
                return userInput;
            case 2:
                changeGameState(userInput);
                runWelcomeMenu();
                return userInput;
            case 3:
                changeGameState(userInput);
                runWelcomeMenu();
                return userInput;
            case 4:
                changeGameState(userInput);
                runWelcomeMenu();
                return userInput;
            case 5:
                goodBye();
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
                    currentGameRunning = new Crazy8Play();
                    break;
                case 3:
                    currentGameRunning = new CeeLo();
                    break;
                case 4:
                    //currentGameRunning = new Roulette();
                    System.out.println("[ SORRY! OUT OF ORDER! ]\n");
                    break;
                case 5:
                    goodBye();

            }
            return currentGameRunning;
        }

    public void welcomeScreen(){

        IOHandler.getMessageFromFile("CasinoWelcomeMenu.txt");
    }

    public void goodBye(){

        IOHandler.getMessageFromFile("Goodbye.txt");

        System.exit(0);
    }

}

