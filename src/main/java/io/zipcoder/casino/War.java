package io.zipcoder.casino;

import java.util.*;

public class War extends Game implements GameInterface, CardGameInterface {

    private boolean gameIsRunning;
    private Dealer dealer = new Dealer();
    private Person player;
    private ArrayList<Card> playerPlayedCards = new ArrayList<Card>();
    private ArrayList<Card> dealerPlayedCards = new ArrayList<Card>();
    private Scanner input = new Scanner(System.in);

    public War(Person player) {
        this.player = player;
    }

    public void start() {
        gameIsRunning = true;
        System.out.println("Welcome to WAR! Enter anything into the console to play a card");
        System.out.println("Enter 'exit' at any time to end the game");
        Deck dealerDeck = new Deck();
        for (int i = 0; i < dealerDeck.getDeckOfCards().size(); i++) {
            dealer.getHand().receiveCards(dealerDeck.getDeckOfCards().get(i));
        }
        dealer.getHand().shuffleHand();
        dealCards();
        engine();
    }

    // Make private after testing / Make public for testing
    public void engine() {
        // String playerInput = input.nextLine();
        if (nextLineIsNotExit()) {
            while (gameIsRunning == true) {
                while (!handOfPersonIsEmpty(dealer) && !handOfPersonIsEmpty(player)) {
                    playerPlayedCards.add(player.getHand().drawCardfromHand());
                    dealerPlayedCards.add(dealer.getHand().drawCardfromHand());
                    System.out.println("You played " + playerPlayedCards + " and the dealer played " + dealerPlayedCards);
                    int winner =
                            compareCards(
                                    getLastCardPlayedOnTable(playerPlayedCards),
                                    getLastCardPlayedOnTable(dealerPlayedCards));
                    announceWinner(winner);
                    if (!nextLineIsNotExit()) {
                        end();
                    }
                     checkIfGameIsOver();
                }
            }
        } else {end();}
    }

    private void checkIfGameIsOver() {
        if (handOfPersonIsEmpty(player) || handOfPersonIsEmpty(dealer)) {
            end();
        }
    }

    private boolean handOfPersonIsEmpty(Person person) {
        return person.getHand().getHandArrayList().size() == 0;
    }

    private void announceWinner(int winnerNumber) {
        if (winnerNumber == 1) {
            playerWins();
        } else if (winnerNumber == 2) {
            dealerWins();
        }
    }

    private Card getLastCardPlayedOnTable(ArrayList<Card> cardsOnTable) {
        return cardsOnTable.get(cardsOnTable.size() - 1);
    }

    private boolean nextLineIsNotExit() {
        return !("exit").equals(input.nextLine());
    }

    public int compareCards(Card p1card, Card p2card) {
        if (p1card.getRank().toInt() == p2card.getRank().toInt()) {
            iDeclareWar();
        } else if (p1card.getRank().toInt() > p2card.getRank().toInt()) {
            return 1;
        } else {return 2;}
        return 0;
    }

    // Make private after testing / Make public for testing
    public void playerWins() {
        System.out.println("You won this round!");
        while (playerPlayedCards.size()!=0) {
            player.getHand().receiveCards(playerPlayedCards.remove(0));
        }
        while (dealerPlayedCards.size()!=0) {
            player.getHand().receiveCards(dealerPlayedCards.remove(0));
        }
        System.out.println("You have " + player.getHand().getHandArrayList().size() + " cards and the dealer has " + dealer.getHand().getHandArrayList().size() + " cards");
    }

    // Make private after testing / Make public for testing
    public void dealerWins() {
        System.out.println("You lost this round!");
        while (playerPlayedCards.size()!=0) {
            dealer.getHand().receiveCards(playerPlayedCards.remove(0));
        }
        while (dealerPlayedCards.size()!=0) {
            dealer.getHand().receiveCards(dealerPlayedCards.remove(0));
        }
        System.out.println("You have " + player.getHand().getHandArrayList().size() + " cards and the dealer has " + dealer.getHand().getHandArrayList().size() + " cards");
    }

    // Make private after testing / Make public for testing
    public void iDeclareWar() {
        System.out.println("I   D E C L A R E   W A R!");
        int amountOfPlayerAvailibleCards = checkNumberOfCards(player.getHand());
        int amountOfDealerAvailibleCards = checkNumberOfCards(dealer.getHand());
        iDeclareWarLogic(playerPlayedCards, player, amountOfPlayerAvailibleCards);
        iDeclareWarLogic(dealerPlayedCards, dealer, amountOfDealerAvailibleCards);
    }

    // Make private after testing / Make public for testing
    public void iDeclareWarLogic(ArrayList<Card> playedCards, Person person, int amountOfCardsAvailable) {
        for (int i = 0; i < decideOnHowManyTimesToIterateBasedOn(amountOfCardsAvailable); i++) {
            playCardInHandForPerson(playedCards, person, i);
        }
    }

    // Make private after testing / Make public for testing
    public int decideOnHowManyTimesToIterateBasedOn(int amountOfCardsAvailable) {
        if(amountOfCardsAvailable <= 4) {
            int cardsAvailableInteger = amountOfCardsAvailable;
            return cardsAvailableInteger;
        }
        return 4;
    }

    // Make private after testing / Make public for testing
    public void playCardInHandForPerson(ArrayList<Card> playedCards, Person person, int i) {
        playedCards.add(person.getHand().drawCardfromHand());
    }

    public void dealCards() {
        for (int i = dealer.getHand().getHandArrayList().size()-1; i >= 26; i--) {
            player.getHand()
                    .getHandArrayList()
                    .add(dealer
                            .getHand()
                            .getHandArrayList()
                            .remove(i));
        }
    }

    public void end() {
        player.getHand().clearHand();
        dealer.getHand().clearHand();
        String winner = "";
        if (player.getHand().getHandArrayList().size() > 50) {
            winner += "you!";
        } else {
            winner += "the dealer!";
        }
        System.out.println("And the winner is " + winner);
        System.out.println("If you want to play again, enter 'yes', or enter anything else to return to the casino");
        if (input.nextLine().equals("yes")) {
            start();
        }
        gameIsRunning = false;
    }

    public int checkNumberOfCards(Hand handToCheck) {
        return handToCheck.getHandArrayList().size();
    }

}
