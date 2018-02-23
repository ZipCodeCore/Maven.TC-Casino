package io.zipcoder.casino;

import java.util.*;

public class War extends Game implements GameInterface, CardGameInterface {

    private Dealer dealer;
    private Person player;
    private ArrayList<Card> playerPlayedCards = new ArrayList<Card>();
    private ArrayList<Card> dealerPlayedCards = new ArrayList<Card>();

    public War(Person player) {
        this.player = player;
    }

    public void start() {
        dealer.getHand().shuffleHand();
        player.getHand().clearHand();
        dealCards();
        beginRound();
    }

    public void beginRound() {
        // Upon player input, player1playedCard calls player1hand.draw() and so does player 2 for their playedCard
        // Ask compareCards for the winner
        // Based on winner, either call player1wins method or player2wins method or iDeclareWar method
        // Check length of both players decks and if one == 52, call end

    }

    public int compareCards(Card p1card, Card p2card) {
        if (p1card.getRank().toInt() == p2card.getRank().toInt()) {
            iDeclareWar();
        } else if (p1card.getRank().toInt() > p2card.getRank().toInt()) {
            return 1;
        } else {return 2;}
        return 0;
    }

    public void playerOneWins() {
        // Uses playedCard.draw on both played card decks until they're empty to return all card objects to player1s deck
    }

    public void playerTwoWins() {
        // Uses playedCard.draw on both played card decks until they're empty to return all card objects to player2s deck
    }

    public void iDeclareWar() {
        int amountOfPlayerAvailibleCards = checkNumberOfCards(player.getHand());
        int amountOfDealerAvailibleCards = checkNumberOfCards(dealer.getHand());
        if (amountOfPlayerAvailibleCards < 4) {
            for (int i = 0; i < amountOfPlayerAvailibleCards; i++) {
                playerPlayedCards.add(player.getHand().getHandArrayList().get(i));
            }
        } else {
            for (int i = 0; i < 4; i++) {
                playerPlayedCards.add(player.getHand().getHandArrayList().get(i));
            }
        }
        if (amountOfDealerAvailibleCards < 4) {
            for (int i = 0; i < amountOfDealerAvailibleCards; i++) {
                dealerPlayedCards.add(dealer.getHand().getHandArrayList().get(i));
            }
        } else {
            for (int i = 0; i < 4; i++) {
                dealerPlayedCards.add(dealer.getHand().getHandArrayList().get(i));
            }
        }
    }

    public void dealCards() {
        for (int i = dealer.getHand().getHandArrayList().size()-1; i >= (dealer.getHand().getHandArrayList().size())/2; i--) {
            player.getHand().getHandArrayList().add(dealer.getHand().getHandArrayList().remove(i));
        }
    }

    public void end() {
        // "And the winner is " + winner
    }
    public int checkNumberOfCards(Hand handToCheck) {
        return handToCheck.getHandArrayList().size();
    }

}
