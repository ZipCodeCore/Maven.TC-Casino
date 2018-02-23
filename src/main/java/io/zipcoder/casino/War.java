package io.zipcoder.casino;

import java.util.*;

public class War extends Game implements GameInterface, CardGameInterface {

    private Dealer dealer = new Dealer();
    private Person player = new Person("Joe");
    private ArrayList<Card> playerPlayedCards = new ArrayList<Card>();
    private ArrayList<Card> dealerPlayedCards = new ArrayList<Card>();
    Scanner input = new Scanner(System.in);

    public War(Person player) {
       // this.player = player;
    }

    public void start() {
        System.out.println("Welcome to WAR! Enter anything into the console to play a card");
        System.out.println("Enter 'exit' at any time to end the game");
        Deck dealerDeck = new Deck();
        for (int i = 0; i < dealerDeck.getDeckOfCards().size(); i++) {
            dealer.getHand().receiveCards(dealerDeck.drawCard());
        }
        dealer.getHand().shuffleHand();
        dealCards();
        beginRound();
    }

    public void beginRound() {
        String playerInput = input.nextLine();
        if (!(playerInput.equals("exit"))) {
            while ((dealer.getHand().getHandArrayList().size() != 0) && (player.getHand().getHandArrayList().size() != 0)) {
                playerPlayedCards.add(player.getHand().drawCardfromHand());
                dealerPlayedCards.add(dealer.getHand().drawCardfromHand());
                System.out.println("You played " + playerPlayedCards + " and the dealer played " + dealerPlayedCards);
                int winner = compareCards(playerPlayedCards.get(playerPlayedCards.size()-1), dealerPlayedCards.get(dealerPlayedCards.size()-1));
                if (winner == 1) {
                    playerWins();
                } else if (winner == 2) {
                    dealerWins();
                }
                String playerInputAgain = input.nextLine();
                if (playerInputAgain.equals("exit")) {
                    end();
                }
            }
        } else {end();}
    }

    public int compareCards(Card p1card, Card p2card) {
        if (p1card.getRank().toInt() == p2card.getRank().toInt()) {
            iDeclareWar();
        } else if (p1card.getRank().toInt() > p2card.getRank().toInt()) {
            return 1;
        } else {return 2;}
        return 0;
    }

    public void playerWins() {
        System.out.println("You won this round!");
        while (playerPlayedCards.size()!=0) {
            player.getHand().receiveCards(playerPlayedCards.remove(0));
        }
        while (dealerPlayedCards.size()!=0) {
            player.getHand().receiveCards(dealerPlayedCards.remove(0));
        }
    }

    public void dealerWins() {
        System.out.println("You lost this round!");
        while (playerPlayedCards.size()!=0) {
            dealer.getHand().receiveCards(playerPlayedCards.remove(0));
        }
        while (dealerPlayedCards.size()!=0) {
            dealer.getHand().receiveCards(dealerPlayedCards.remove(0));
        }
    }

    public void iDeclareWar() {
        System.out.println("I   D E C L A R E   W A R!");
        int amountOfPlayerAvailibleCards = checkNumberOfCards(player.getHand());
        int amountOfDealerAvailibleCards = checkNumberOfCards(dealer.getHand());
        iDeclareWarLogic(playerPlayedCards, player, amountOfPlayerAvailibleCards);
        iDeclareWarLogic(dealerPlayedCards, dealer, amountOfDealerAvailibleCards);
    }

    public void iDeclareWarLogic(ArrayList<Card> playedCards, Person person, int amountOfCardsAvailable) {
        if (amountOfCardsAvailable < 4) {
            for (int i = 0; i < amountOfCardsAvailable; i++) {
                playedCards.add(person.getHand().getHandArrayList().remove(i));
            }
        } else {
            for (int i = 0; i < 4; i++) {
                playedCards.add(person.getHand().getHandArrayList().remove(i));
            }
        }
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
        String winner = "";
        if (player.getHand().getHandArrayList().size() == 52) {
            winner += "you!";
        } else {
            winner += "the dealer!";
        }
        System.out.println("And the winner is " + winner);
        System.out.println("If you want to play again, enter 'yes', or enter anything else to return to the casino");
        if (input.nextLine().equals("yes")) {
            start();
        }
    }

    public int checkNumberOfCards(Hand handToCheck) {
        return handToCheck.getHandArrayList().size();
    }

}
