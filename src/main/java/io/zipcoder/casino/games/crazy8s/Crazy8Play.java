package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.core.Casino;
import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class Crazy8Play implements Game {
    Crazy8sMenu start = new Crazy8sMenu();
    private ArrayList<Card> playersHand = new ArrayList<>();
    private ArrayList<Card> computerHand = new ArrayList<>();
    private Card matchThisCard;
    boolean legalCard = false;
    Deck deck = new Deck(); //get new deck to play with


    public Crazy8Play() {

        start.showMenu();
    }

    public Crazy8Play(boolean withoutMenu){

    }

    @Override
    public void play(Player player) {

        IOHandler.printMessage(runWelcome());

        //deal cards
        dealCards();

        IOHandler.printMessage("Your hand ");
        displayPlayerHand();
        IOHandler.printMessage("\nThe card to match is: \n");
        displayCardToMatch();
        IOHandler.printMessage("\n");

        //check if any of the players cards match the DisplayCard
        legalCard(matchThisCard);
        ///////
        computeMatchesPlayer();

        //check for empty hands

        computeMatchesPlayer();
    }

    public void playerSelectCard(){

        int cardSelection = IOHandler.promptForIntWithMessage("Select which card you would like to play: ");
        cardSelect(cardSelection);

    }

    public void cardSelect(int cardSelection) {
        switch (cardSelection) {
            case 1:
                playersHand.remove(1);
                displayPlayerHand();
                break;
            case 2:
                playersHand.remove(2);
                displayPlayerHand();
                break;
            case 3:
                playersHand.remove(3);
                break;
            case 4:
                playersHand.remove(4);
                break;
            case 5:
                playersHand.remove(5);
                break;
            case 6:
                playersHand.remove(6);
                break;
            case 7:
                playersHand.remove(7);
                break;
            default:
                playerSelectCard();
                break;
        }
        isAnyHandEmpty();
        displayPlayerHand();
    }
    public void isAnyHandEmpty(){

        if(emptyHand(1) || emptyHand(2)) {
            decideWinner();
        }
    }

    private void computersTurn() {
        //if the Player just played it now the computers turn
        //vice versa!
    }

    public void computeMatchesPlayer() {
        if (legalCard == true) {
            playerSelectCard();
        } else
            pickCard();
            computeMatchesPlayer();
    }

    public void computeMatchesComputer() {
        if(legalCard == true) {
            //IF match (computerHand) force them to play match
            compPlayCard();
        }else {
            //IF NO MATCH (computerHand) force them to draw card
            computerHand.add.deck.pull(1);
            computeMatchesComputer();
        }
    }

    public boolean legalCard(Card card) {
    //check whether card matches suit, rank of pile or is eight
        if (card.getRank().equals(8)) { //card is 8
            System.out.println("You have an 8!");
            return true;
        } else if (card.getSuit().equals(matchThisCard.getSuit())) { //card matches suit
            System.out.println("You have a matching suit");
            return true;
        } else if (card.getRank().equals(matchThisCard.getRank())) { //card matches rank
            System.out.println("You have a matching Rank");
            legalCard = true;
        }
        legalCard = false;
        return legalCard;
    }

    private void compPlayCard() {

        isAnyHandEmpty();
//        switchTurns();
    }

    private void pickCard() {

        String userInput = IOHandler.promptForStringWithMessage("You don't have any cards to play. " +
                                                                      "Press ANY key to pick up a card.");
        if(userInput.equalsIgnoreCase(" ")) {
            playersHand.addAll(deck.pull(1));
        }
    }

    public void compPickCard(){

        computerHand.add(deck.pull(1));
    }

    public void playersTurn(){

        String userInput = IOHandler.promptForStringWithMessage("Do you want to play again? [Y/N]");
        handleInput(userInput);
    }

    public void dealCards() {
        int handSize = 9;

        deck.shuffle();

        playersHand.addAll(Arrays.asList(deck.pull(handSize)));   //deal playersHand
        computerHand.addAll(Arrays.asList(deck.pull(handSize))); //and computerHand's hand
        matchThisCard = deck.pull(1)[0]; //show one card from face down Deck
    }

    public void displayPlayerHand() {

        for (int i = 1; i < playersHand.size(); i++) {
            IOHandler.printMessage(String.format("%2d: ", i));
            IOHandler.printMessage(playersHand.get(i).toString());
        }
    }

    public void displayCardToMatch() {

        IOHandler.printMessage(matchThisCard.toString());
    }

    public boolean emptyHand(int whichHand){
    {
        Card[] hand;
        if (whichHand == 1) {
            hand = playersHand.toArray(new Card[0]);
        } else {
            hand = computerHand.toArray(new Card[0]);
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
        playersHand.clear();
        computerHand.clear();
        if (emptyHand(1)) { //player won
            IOHandler.printMessage(resultWin);
            playAgainPrompt();
        } else if (emptyHand(2)) { //computerHand won
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

    public String runWelcome() {

        return IOHandler.getMessageFromFile("Crazy8Start");
    }

    @Override
    public String getRules() {

        return IOHandler.getMessageFromFile("Crazy8Rules.txt");
    }

    public void quitGame() {

    }
}
