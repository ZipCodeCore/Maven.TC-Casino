package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.core.Casino;
import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

public class Crazy8Play implements Game {
    Crazy8sMenu start = new Crazy8sMenu();
    private Card[] playersHand;
    private Card[] computer;
    private Card[] matchThisCard;
    private Player player;
    private String answer;
    Deck deck = new Deck(); //get new deck to play with


    public Crazy8Play(Player player) {

        start.showMenu();
    }

    @Override
    public void play(Player player) {
        //deal cards
        dealCards();
        //check for empty hands
        displayPlayerHand();
        displayPileCard();

        emptyHand(1);
        emptyHand(2);

    }

    public void computeMatches(){
        //check if the displayCard == any card in the player or computers hand
        //by rand, suit OR 8
        //IF match (player) allow them to choose a card
        pickCard();
        //IF NO MATCH (player) force them to draw a card
        playersHand = deck.pull(1);
        computeMatches();
        //IF 8 - force them to chose a suit

        //IF match (computer) force them to play match
        compPlayCard();
        //IF NO MATCH (computer) force them to draw card
        computer = deck.pull(1);
        computeMatches();
        //IF 8 - force them to chose a suit

    }

    private void compPlayCard() {

    }

    private void pickCard() {

    }

    public void playersTurn(){

        String userInput = IOHandler.promptForStringWithMessage("Do you want to play again? [Y/N]");
        handleInput(userInput);
    }

    public void dealCards() {
        int handSize = 8;

        playersHand = deck.pull(handSize);   //deal playersHand
        computer = deck.pull(handSize); //and computer's hand
        matchThisCard = deck.pull(1); //show one card from face down Deck
    }

    public String displayPileCard(){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < playersHand.length; i++) {
            sb.append(String.format("%2d: ", i));
            sb.append(playersHand[i].toString());
        }
        return sb.toString();
    }

    public String displayPlayerHand() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < matchThisCard.length; i++) {
            sb.append(matchThisCard[i].toString());
        }
        return sb.toString();
    }

    public boolean emptyHand(int whichHand){
    {
        Card[] hand;
        if (whichHand == 1) {
            hand = playersHand;
        } else {
            hand = computer;
        }
        if (hand.length > 0) {
            return false;
        }
        return true;
    }

    }
    public void decideWinner() {
        String resultWin = "Congratulations! You are the winner!";
        String resultLose = "Sorry! You lose!";
        if (emptyHand(1)) { //player won
            IOHandler.printMessage(resultWin);
            playAgainPrompt();
        } else if (emptyHand(2)) { //computer won
            IOHandler.printMessage(resultLose);
            playAgainPrompt();
        } else
            playAgainPrompt();
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
            default:
                quitGame();
        }
        return userInput;
    }

    @Override
    public String runWelcome() {

        return IOHandler.getMessageFromFile("Crazy8Welcome.txt");
    }

    @Override
    public String getRules() {

        return IOHandler.getMessageFromFile("Crazy8Rules.txt");
    }

    @Override
    public void quitGame() {

    }
}
