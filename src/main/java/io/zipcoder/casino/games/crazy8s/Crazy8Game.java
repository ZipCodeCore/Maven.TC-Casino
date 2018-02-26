package io.zipcoder.casino.games.crazy8s;

import io.zipcoder.casino.core.Player;
import io.zipcoder.casino.games.Card;
import io.zipcoder.casino.games.Deck;
import io.zipcoder.casino.games.Rank;
import io.zipcoder.casino.games.Suit;
import io.zipcoder.casino.interfaces.Game;
import io.zipcoder.casino.utils.IOHandler;

import java.util.ArrayList;
import java.util.Arrays;

public class Crazy8Game implements Game{

    private Card matchThisCard;
    private Deck deck; //get new deck to play with
    private Crazy8Player playerOne;
    private Crazy8Player playerTwo;


    public Crazy8Game() {
        Crazy8sMenu menu = new Crazy8sMenu();
        menu.showMenu();
    }

    public Crazy8Game(boolean withoutMenu) {
        deck = new Deck();
        playerOne = new Crazy8Player("Player 1");
        playerTwo = new Crazy8Player("Player 2");

        playerOne.setPlayersHand(new ArrayList<Card>(Arrays.asList(deck.pullMany(8))));
        playerTwo.setPlayersHand(new ArrayList<Card>(Arrays.asList(deck.pullMany(8))));
        matchThisCard = deck.pull();
    }

    @Override
    public void play(Player player) {

        IOHandler.printMessage(runWelcome());


        boolean playerCardsValid = matchDisplayCard(playerOne.getPlayersHand());
        boolean computerCardsValid = matchDisplayCard(playerTwo.getPlayersHand());


        //playerOne values
        playerOne.setPlayerCardsValid(playerCardsValid);

        //playerTwo values
        playerTwo.setPlayerCardsValid(computerCardsValid);

        while (playerOne.getPlayersHand().size() != 0 || playerTwo.getPlayersHand().size() != 0) {

            //Ready Player 1 needs to select a card
            playerTurn(playerOne);

            //Player 2 needs to select a card
            playerTurn(playerTwo);
        }
        displayWinner();
    }

    private boolean playerTurn(Crazy8Player player) {

        //Computer needs to select a card
        if (player.isPlayerCardsValid()) {
            playerSelectCard(player);
        } else {
            pickUpCardFromDeck(player);
        }

        return true;
    }

    private Card pickUpCardFromDeck(Crazy8Player player) {
        IOHandler.printMessage("You don't have any cards to play.");
        Card pulledCard = deck.pull();

        IOHandler.printMessage("Here - try this one: " +pulledCard.toString());
        return pulledCard;
    }

    private Crazy8Player displayWinner() {
        String winningResults;
        Crazy8Player winner = new Crazy8Player("Nobody");
        if(playerOne.getPlayersHand().size() == 0){
            //player 1 won
            winningResults = "Player 1 Won!";
            winner = playerOne;
        }else if(playerTwo.getPlayersHand().size() == 0){
            //player 2 won
            winningResults = "Player 2 Won!";
            winner = playerTwo;
        }else{
            //ain't nobody win
            winningResults = "Ain't nobody winning today";
        }
        playerOne.getPlayersHand().clear();
        playerTwo.getPlayersHand().clear();
        deck.shuffle();
        IOHandler.printMessage(winningResults);
        return winner;
    }

    public Card playerSelectCard(Crazy8Player player){
        displayPreSelectionMessage(player);
        int cardSelection = IOHandler.promptForIntWithMessage("Select which card you would like to play: ");
        Card selectedCard = player.getPlayersHand().get(cardSelection);

        //make sure that card played is valid
        player.setPlayerCardsValid(validateSelection(selectedCard));

        if(player.playerCardsValid){
            matchThisCard = removeCard(cardSelection, player); // Set card to match to removed card
            if(selectedCard.getRank().equals(Rank.EIGHT)){
                //Prompt playerOne to select a new suit
                changeSuitwithEight();
            }
        }else {
            IOHandler.printMessage("That is not a legal play.");
            playerSelectCard(player);
        }

        return selectedCard;
    }


    private String displayPreSelectionMessage(Crazy8Player player) {
        IOHandler.printMessage("*********************" + player.name + "**********************");
        IOHandler.printMessage("Your hand ");
        displayPlayerHand(player);
        IOHandler.printMessage("\nThe card to match is: ");
        displayCardToMatch();
        IOHandler.printMessage("\n");
        IOHandler.printMessage("**************************************************************");
        return "";
    }

    public void changeSuitwithEight() {
     String newSuit =
                    IOHandler.promptForStringWithMessage("Enter the 1st letter of the suit you want to change to: ");

            if (newSuit.equalsIgnoreCase("S")) {
                this.matchThisCard.setSuit(Suit.SPADES);
            } else if (newSuit.equalsIgnoreCase("H")) {
                this.matchThisCard.setSuit(Suit.HEARTS);
            } else if (newSuit.equalsIgnoreCase("D")) {
                this.matchThisCard.setSuit(Suit.DIAMONDS);
            } else if (newSuit.equalsIgnoreCase("C")) {
                this.matchThisCard.setSuit(Suit.CLUBS);

            }
    }

    private Card removeCard(int cardSelected,Crazy8Player player ) {
        return player.getPlayersHand().remove(cardSelected);
    }

    private boolean matchDisplayCard(ArrayList<Card> cards){
        for(Card card : cards) {
            if (card.getRank().equals(matchThisCard.getRank())
                    || card.getSuit().equals(matchThisCard.getSuit())
                    || card.getRank().equals(Rank.EIGHT)){
                return true;
            }
        }
        return false;
    }

    private boolean validateSelection(Card card){
        if (card.getRank().equals(matchThisCard.getRank())
                || card.getSuit().equals(matchThisCard.getSuit())
                || card.getRank().equals(Rank.EIGHT)){
            return true;
        }
        return false;
    }

    public void displayPlayerHand(Crazy8Player player) {
        for (int i = 0; i < player.getPlayersHand().size(); i++) {
            IOHandler.printMessage(String.format("%2d: ", i));
            IOHandler.printMessage(player.getPlayersHand().get(i).toString());
        }
    }

    public void displayCardToMatch() {
        IOHandler.printMessage(matchThisCard.toString());
    }

    @Override
    public String runWelcome() {
        return IOHandler.getMessageFromFile("Crazy8Start");
    }


    @Override
    public String getRules() {
        return null;
    }
}
