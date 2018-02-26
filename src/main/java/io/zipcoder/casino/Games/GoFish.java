package io.zipcoder.casino.Games;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.GoFishComputerPlayer;
import io.zipcoder.casino.Players.GoFishHumanPlayer;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Players.Player;
import java.util.*;

public class GoFish implements Game {
    private int turnCounter;
    private ArrayList<GoFishPlayer> players;
    private InputOutput inputOutput;
    private Deck deck;


    public GoFish(GoFishHumanPlayer player1) {
        inputOutput = new InputOutput();
        players = new ArrayList<>();
        players.add(player1);
        players.add(new GoFishComputerPlayer("Bob"));
        players.add(new GoFishComputerPlayer("Sue"));
        turnCounter = 0;
        deck = new Deck();
        deck.shuffleDeck();

    }

    public void welcomeMessage() {
        System.out.println("Welcome to Go Fish!\nYou are playing with Bob and Sue today.\n");

    }

    public void startGame() {
        this.welcomeMessage();
        this.deal();
        while (gameIsNotOver()) {
            takeTurn();
        }
        GoFishPlayer winner = this.determineWinner();
        System.out.println("Congratulations, " + winner.getName() + " , you win!");
        System.out.println("That was fun! Game over.");
        this.endGame();
    }


    public void deal() {
        System.out.println("Dealing out player hands.");
        for (int i = 0; i < players.size(); i++) {
            for(int j= 0; j < 5; j++) {
                players.get(i).addCardToHand(deck.getTopCard());
                deck.deck.remove(0);
            }

        }
    }

    public boolean gameIsNotOver () {
        int numPairsMatched = 0;
        for (GoFishPlayer player : players) {
            numPairsMatched += player.getNumPairs();

        }
        return numPairsMatched < 26;
    }

    public GoFishPlayer getCurrentPlayer() {
        // turncount mod numplayers = index of currentplayer
        return players.get(turnCounter % players.size());
    }


    public void takeTurn () {
        GoFishPlayer currentPlayer = getCurrentPlayer();
        if(currentPlayer.isHandEmpty()) {
            System.out.println(currentPlayer.getName() + " ran out of cards and there are no cards left in the deck. Skipping turn.");
            turnCounter++;
            return;
        }
        System.out.println("\nIt's " + currentPlayer.getName() + "'s turn.\n");

        List<GoFishPlayer> opponents = new ArrayList<>(players);
        opponents.remove(currentPlayer);
        GoFishPlayer opponentToAsk = currentPlayer.pickOpponentToAsk(opponents);

        Card cardPicked = currentPlayer.pickCard();

        System.out.println("\n" + currentPlayer.getName() + " asked " + opponentToAsk.getName() + " for a " + cardPicked + ".");

        if (opponentToAsk.hasCard(cardPicked)) {
            opponentToAsk.removeCard(cardPicked);
            currentPlayer.addCardToHand(cardPicked);
            System.out.println("\n" + opponentToAsk.getName() + " had that card. " + currentPlayer.getName() + " goes again.\n");
            this.fillPlayerHands();
            this.takeTurn();
        } else {
            System.out.println("\n" + opponentToAsk.getName() + " did not have that card. Go fish.\n");
            if (deck.deck.isEmpty()) {
                System.out.println("The deck is empty. No cards to draw.");
                turnCounter++;
                return;
            }
            Card topCard = deck.getTopCard();
            deck.deck.remove(0);
            currentPlayer.addCardToHand(topCard);
            if (topCard.getRankEnum().equals(cardPicked.getRankEnum())) {
                System.out.println("\n" + currentPlayer.getName() + " picked their wish! " + currentPlayer.getName() + " gets a point. Go again.\n");
                this.fillPlayerHands();
                this.takeTurn();

            } else {
                this.fillPlayerHands();
                turnCounter++;
            }

        }
    }

    public void fillPlayerHands() {
            for (GoFishPlayer player : players) {
                if (player.isHandEmpty() && deck.deck.size() > 0) {
                    Card topCard = deck.getTopCard();
                    deck.deck.remove(0);
                    player.addCardToHand(topCard);

                }
            }

    }

    public GoFishPlayer determineWinner() {
        GoFishPlayer winner = null;
        int highestScore = 0;
        for (GoFishPlayer player: players) {
            int currentScore = player.getNumPairs();
            if (currentScore > highestScore) {
                highestScore = currentScore;
                winner = player;
            }
        }
        return winner;
    }

    public void endGame() {

    }
}



