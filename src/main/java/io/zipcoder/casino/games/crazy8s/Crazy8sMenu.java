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
<<<<<<< HEAD
        Crazy8Play game = new Crazy8Play(true);
=======
        //Crazy8Play game = new Crazy8Play(true);
        Crazy8Game game = new Crazy8Game(true);
>>>>>>> d0d678eff7061b4c818d211fa46047a14fb68b2d

        game.play(player);
    }


    public String runWelcome() {

        return IOHandler.getMessageFromFile("Crazy8Welcome.txt");
    }

    public String getRules() {

        return IOHandler.getMessageFromFile("Crazy8Rules.txt");
    }
}
