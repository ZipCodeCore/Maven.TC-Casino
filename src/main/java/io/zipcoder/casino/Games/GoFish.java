package io.zipcoder.casino.Games;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.GoFishAI;
import io.zipcoder.casino.Players.GoFishPlayer;
import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Players.Player;

import java.util.*;



public class GoFish implements Game {
    private int turnCounter;
    private ArrayList<GoFishPlayer> players;
    private InputOutput inputOutput;
    private int numPairsMatched;
    private GoFishAI goFishAI;
    private Deck deck;


    public GoFish(GoFishPlayer player1) {
        inputOutput = new InputOutput();
        players = new ArrayList<GoFishPlayer>();
        players.add(player1);
        players.add(new GoFishPlayer("Bob"));
        //players.add(goFishAI);
        numPairsMatched = 0;
        turnCounter = 0;
        deck = new Deck();
        deck.shuffleDeck();

    }

//    public int welcomeMessage() {
//        int numOpponents = inputOutput.promptForInt("Welcome! Choose number of opponents:");
//        return numOpponents;
//    }

    public void startGame() {
        //this.welcomeMessage();
        this.deal();
        while (gameIsNotOver()) {
            takeTurn();
        }
        GoFishPlayer winner = this.determineWinner();
        System.out.println("Congratulations, " + winner.getName() + " , you win!");
        inputOutput.promptForString("That was fun! Want to play again?");
        endGame();
    }


    public void deal() {
        for (int i = 0; i < players.size(); i++) {
            for(int j= 0; j < 5; j++) {
                players.get(i).cardHand.add(deck.deck.get(0));
                deck.deck.remove(0);
            }

        }
    }

    private boolean gameIsNotOver () {
        for (GoFishPlayer player : players) {
            numPairsMatched = player.getNumPairs();
        }
        return numPairsMatched < 26;
    }

    public GoFishPlayer getCurrentPlayer() {
        // turncount mod numplayers = index of currentplayer
        return players.get(turnCounter % players.size());
    }


    public void takeTurn () {
        GoFishPlayer currentPlayer = getCurrentPlayer();
        System.out.println("It's " + currentPlayer.getName() + "'s turn.\n");
        List<GoFishPlayer> opponents = new ArrayList<>(players);
        opponents.remove(currentPlayer);
        GoFishPlayer opponentToAsk = currentPlayer.pickOpponentToAsk(opponents);

        Card cardPicked = currentPlayer.pickCard();

        if (opponentToAsk.hasCard(cardPicked)) {
            opponentToAsk.removeCard(cardPicked);
            currentPlayer.removeCard(cardPicked);
            currentPlayer.addPair();
            System.out.println("\n" + opponentToAsk.getName() + " had that card. You get a point. Go again.\n");
            this.takeTurn();
        } else {
            System.out.println(opponentToAsk.getName() + " did not have that card. Go fish.\n");
            currentPlayer.goFish(deck.deck.get(0));
            deck.deck.remove(0);
            turnCounter++;
        }

    }

    public GoFishPlayer determineWinner() {
        GoFishPlayer winner = new GoFishPlayer();
        int highestScore = 0;
        for (GoFishPlayer player : players) {
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



