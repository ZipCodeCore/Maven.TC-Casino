package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.core.Casino;
import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

public class Crazy8Play implements Game {
    Crazy8sMenu start = new Crazy8sMenu();
    private Card[] playersHand;
    private Card[] computer;
    private Card[] matchThisCard;
    private Player player;
    private String answer;

    public Crazy8Play() {
    }

    @Override
    public void play(Player player) {
        this.player = player;
        start.showMenu();
//        Deck deck = new Deck(); //get new deck to play with
//        int handSize = 8;
//
//        playersHand = deck.pull(handSize);   //deal playersHand
//        computer = deck.pull(handSize); //and computer's hand
//        matchThisCard = deck.pull(1); //show one card from face down Deck
//
//        while (!emptyHand(1) && !emptyHand(2))
//        //while the playersHand and computers hands aren't empty
//        {
//            displayState();
//            playerPlays();
//
//            displayCardToMatch();
//            computerPlays();
//        }
//        result();
//        runWelcome();
    }

    public void emptyHand() {

    }

    public void decideWinner() {
//        String result;
//        if (emptyHand(1)) { //player won
//            result = "Congratulations! You are the winner!" +
//                    "\n Play again? [y/n]";
//            answer = IOHandler.promptForStringWithMessage(result);
//        } else if (emptyHand(2)) { //computer won
//            result = "Sorry! You lose!" +
//                    "\n Play again? [y/n]";
//            answer = IOHandler.promptForStringWithMessage(result);
//        } else {
//            result = "Its a TIE!!!" +
//                    "\n Play again? [y/n]";
//            answer = IOHandler.promptForStringWithMessage(result);
//        }
    }

    public void playAgainPrompt() {

        String userInput = IOHandler.promptForStringWithMessage("Do you want to play again? [Y/N]");
        handleInput(userInput);

    }

    public String handleInput(String userInput) {
        userInput = userInput.toUpperCase();

        switch (userInput) {
            case "Y":
                Crazy8sMenu game = new Crazy8sMenu();
                game.playGame();
                return userInput;
            case "N":
                Casino casino = new Casino();
                casino.enter();
                return userInput;
        }
        return userInput;
    }

    @Override
    public void runWelcome() {

        IOHandler.printMessage(IOHandler.getMessageFromFile("Crazy8Welcome.txt"));
    }

    @Override
    public String getRules() {

        return IOHandler.getMessageFromFile("Crazy8Rules.txt");
    }
}
