package io.zipcoder.casino.core;

import io.zipcoder.casino.games.ceelo.CeeLoGamble;
import io.zipcoder.casino.games.crazy8s.Crazy8Play;
import io.zipcoder.casino.games.roulette.Roulette;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

public class Casino {
    private Player player;
    private Game currentGameRunning;

    public Casino() {

        this.player = player;
    }


    public void enter() {

        int userInput = IOHandler.promptForIntWithMessage(runWelcomeMenu());
        handleInput(userInput);
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
                return userInput;
            default:
                runWelcomeMenu();
        }
        return userInput;
    }


    public Game changeGameState(int answer) {

        switch (answer) {
            case 1:
//                currentGameRunning = new BlackJack();
//                break;
            case 2:
                currentGameRunning = new Crazy8Play(player);
                break;
            case 3:
//                currentGameRunning = new CeeLoGamble();
//                break;
            case 4:
//                currentGameRunning = new Roulette();
//                break;
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

