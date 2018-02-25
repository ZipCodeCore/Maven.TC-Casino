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
    boolean legalCard = false;
    Deck deck = new Deck(); //get new deck to play with


    public Crazy8Play() {

        start.showMenu();
    }

    @Override
    public void play(Player player) {
        //deal cards
        dealCards();
        //check for empty hands
        displayPlayerHand();
        displayCardToMatch();
        //check if any of the players cards match the DisplayCard
        computeMatchesPlayer();
    }

    public void playerSelectCard(){

        int cardSelection = IOHandler.promptForIntWithMessage("Select which card you would like to play: ");
        cardSelect(cardSelection);

    }

    public void cardSelect(int cardSelection){
        //take the selected card and make it the NEW cardToMatch
        if(emptyHand(1) || emptyHand(2)) {
            decideWinner();
        }
        switchTurns();

    }

    private void switchTurns() {
        //if the Player just played it now the computers turn
        //vice versa!
    }

    public void computeMatchesPlayer() {
        if (legalCard == true) {
            //check if the displayCard == any card in the player or computers hand by rank, suit OR 8
            //IF there is a match (for player) allow them to choose a card
            playerSelectCard();
        } else
            //IF NO MATCH (player) force them to draw a card
            playersHand = deck.pull(1);
        computeMatchesPlayer();
    }

    public void computeMatchesComputer() {
        if(legalCard == true) {
            //IF match (computer) force them to play match
            compPlayCard();
        }else {
            //IF NO MATCH (computer) force them to draw card
            computer = deck.pull(1);
            computeMatchesComputer();
        }
    }

    public boolean legalCard(Card card) {
        //check whether card matches suit, rank of pile or is eight
        if (card.getRank().equals(8)) { //card is 8
            return true;
//        } else if (card.getSuit().equals(matchThisCard.getSuit())) { //card matches suit
//            return true;
//        } else if (card.getRank().equals(matchThisCard.getRank())) { //card matches rank
//            legalCard = true;
        }
        legalCard = false;
        return legalCard;
    }

    private void compPlayCard() {

        //computers matching card is now removed from hand and made into displayCardToMatch
        if(emptyHand(1) || emptyHand(2)) {
            decideWinner();
        }
        switchTurns();
    }

    private void pickCard() {

        String userInput = IOHandler.promptForStringWithMessage("You don't have any cards to play. Press ANY key to pick up a card.");
        if(userInput.equalsIgnoreCase(" ")) {
            deck.pull(1);
        }
    }

    public void compPickCard(){

        deck.pull(1);
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

    public String displayPlayerHand(){

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < playersHand.length; i++) {
            sb.append(String.format("%2d: ", i));
            sb.append(playersHand[i].toString());
        }
        return sb.toString();
    }

    public String displayCardToMatch() {
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