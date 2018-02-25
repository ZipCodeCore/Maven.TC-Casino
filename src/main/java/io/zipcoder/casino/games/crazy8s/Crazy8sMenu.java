package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.core.Casino;
import io.zipcoder.casino.utils.IOHandler;
import io.zipcoder.casino.core.Player;

public class Crazy8sMenu {

    public void showMenu() {

        String userInput = IOHandler.promptForStringWithMessage(runWelcome());
        handleInput(userInput);
    }

    public String handleInput(String userInput) {
        userInput = userInput.toUpperCase();

        switch (userInput) {
            case "R":
                IOHandler.printMessage(getRules());
                showMenu();
                return userInput;
            case "P":
                playGame();
                showMenu();
                return userInput;
            case "Q":
                Casino casino = new Casino();
                casino.enter();
                return userInput;
            default:
                showMenu();
        }
        return userInput;
    }

    public void playGame() {
        Player player = new Player();
        Crazy8Play game = new Crazy8Play(true);

        game.play(player);
    }


    public String runWelcome() {

        return IOHandler.getMessageFromFile("Crazy8Welcome.txt");
    }

    public String getRules() {

        return IOHandler.getMessageFromFile("Crazy8Rules.txt");
    }
}
