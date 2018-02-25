package io.zipcoder.casino.games.crazy8s;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import io.zipcoder.casino.core.Casino;
import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class Crazy8Play implements Game {
    private Crazy8sMenu start = new Crazy8sMenu();
    private ArrayList<Card> playersHand = new ArrayList<>();
    private ArrayList<Card> computerHand = new ArrayList<>();
    private Card matchThisCard;
    private boolean legalCard = false;
    private boolean legalCardComputer = false;
    private Deck deck = new Deck(); //get new deck to play with


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
        IOHandler.printMessage("\nThe card to match is: ");
        displayCardToMatch();
        IOHandler.printMessage("\n");

        //check if any of the players cards match the DisplayCard
        legalCard(matchThisCard);
    }

    public void playerSelectCard(){

        int cardSelection = IOHandler.promptForIntWithMessage("Select which card you would like to play: ");
        if(playersHand.get(cardSelection).getRank().equals(matchThisCard.getRank())) {
            cardSelect(cardSelection);
        }else if (playersHand.get(cardSelection).getSuit().equals(matchThisCard.getSuit())) {
            cardSelect(cardSelection);
        } else if((playersHand.get(cardSelection).getRank().equals("EIGHT"))) {
            cardSelect(cardSelection);
        }else {
            IOHandler.printMessage("That is not a legal play.");
            playerSelectCard();
        }
    }

    public void cardSelect(int cardSelection) {
        switch (cardSelection) {
            case 1:
                matchThisCard = playersHand.get(1);
                playersHand.remove(1);
                break;
            case 2:
                matchThisCard = playersHand.get(2);
                playersHand.remove(2);
                break;
            case 3:
                matchThisCard = playersHand.get(3);
                playersHand.remove(3);
                break;
            case 4:
                matchThisCard = playersHand.get(4);
                playersHand.remove(4);
                break;
            case 5:
                matchThisCard = playersHand.get(5);
                playersHand.remove(5);
                break;
            case 6:
                matchThisCard = playersHand.get(6);
                playersHand.remove(6);
                break;
            case 7:
                matchThisCard = playersHand.get(7);
                playersHand.remove(7);
                break;
            case 8:
                matchThisCard = playersHand.get(8);
                playersHand.remove(8);
                break;
            case 9:
                matchThisCard = playersHand.get(9);
                playersHand.remove(9);
                break;
            case 10:
                matchThisCard = playersHand.get(10);
                playersHand.remove(10);
                break;
            default:
                playerSelectCard();
                break;
        }
        isAnyHandEmpty();
        IOHandler.printMessage("\nThe NEW card to match is: \n");
        displayCardToMatch();
        IOHandler.printMessage("\n");
        computersTurn();
    }
    public void isAnyHandEmpty(){

        if(emptyHand(1) || emptyHand(2)) {
            decideWinner();
        }
    }

    private void computersTurn() {
        legalCardComputer(matchThisCard);
        computeMatchesComputer();
    }

    public void computeMatchesPlayer() {
        if (legalCard) {
            playerSelectCard();
        } else
            pickCard();
            computeMatchesPlayer();
    }

    public void computeMatchesComputer() {
        if(legalCardComputer) {
            //IF match (computerHand) force them to play match
            compPlayCard();
        }else {
            //IF NO MATCH (computerHand) force them to draw card
            computerHand.add(deck.pull(1)[0]);
            computeMatchesComputer();
        }
    }

    public boolean legalCard(Card card) {
        //check whether card matches suit, rank of pile or is eight
        for (int i = 1; i < playersHand.size(); i++) {
            if (playersHand.toString().contains("EIGHT")) { //card is 8
                IOHandler.printMessage("(You have an EIGHT)");
                legalCard = true;
                computeMatchesPlayer();
            } else if (playersHand.get(i).getSuit().equals(card.getSuit())) { //card matches suit
                legalCard = true;
                computeMatchesPlayer();
            } else if (playersHand.get(i).getRank().equals(card.getRank())) { //card matches rank
                legalCard = true;
                computeMatchesPlayer();
            } else {
                legalCard = false;
                pickCard();
            }
        }
        return legalCard;
    }

        public boolean legalCardComputer (Card card) {
            //check whether card matches suit, rank of pile or is eight
            for (int i = 0; i < computerHand.size(); i++) {
                if (computerHand.toString().contains("EIGHT")) { //card is 8
                    legalCardComputer = true;
                    computeMatchesComputer();
                } else if (computerHand.get(i).getSuit().equals(card.getSuit())) { //card matches suit
                    legalCardComputer = true;
                    computeMatchesComputer();
                } else if (computerHand.get(i).getRank().equals(card.getRank())) { //card matches rank
                    legalCardComputer = true;
                    computeMatchesComputer();
                }
                legalCardComputer = false;
                computeMatchesComputer();
            }
            return legalCardComputer;

        }

    private void compPlayCard() {
        //remove matching card from computers ahd
        for(int i = 0; i < computerHand.size(); i++) {
            if(computerHand.get(i).equals(matchThisCard)) {
                matchThisCard = computerHand.get(i);
                computerHand.remove(computerHand.get(i));
            }
        }
        isAnyHandEmpty();
        IOHandler.printMessage("Computer has " + (computerHand.size() -1) + " cards in their hand\n");
        displayPlayerHand();
        IOHandler.printMessage("\n");
        IOHandler.printMessage("Card to match:");
        displayCardToMatch();
        IOHandler.printMessage("\n");
        computeMatchesPlayer();
    }

    private void pickCard() {

        String userInput = IOHandler.promptForStringWithMessage("You don't have any cards to play. " +
                                                                      "Press X to pick up a card.");
        if(userInput.equalsIgnoreCase("x")) {
            playersHand.add(deck.pull();
            IOHandler.printMessage("\nThe card to match is:");
            displayCardToMatch();
            legalCard(matchThisCard);
        }
        playersHand.add(deck.pull(1)[0]);
        displayPlayerHand();
        legalCard(matchThisCard);

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
