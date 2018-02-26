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
        System.out.println(displayLogo());
        System.out.println("\nWelcome to Go Fish!\nYou are playing with Bob and Sue today.");
        System.out.println("=======================================\n");

    }

    public void startGame() {
        this.welcomeMessage();
        this.deal();
        while (gameIsNotOver()) {
            takeTurn();
        }
        List<GoFishPlayer> winners = this.determineWinner();
        this.gameOverMessage(winners);
        this.endGame();
    }


    public void deal() {
        System.out.println("\n+-+-+ +-+-+-+-++-+-+ +-+-+-+-++-+-+");
        System.out.println("Dealing out player hands.");
        System.out.println("+-+-+ +-+-+-+-++-+-+ +-+-+-+-++-+-+\n");
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
            System.out.println("\n" + currentPlayer.getName() + " ran out of cards and there are no cards left in the deck. Skipping turn.");
            System.out.println("=======================================\n");
            turnCounter++;
            return;
        }
        System.out.println("\n\n\n=======================================");
        System.out.println("It's " + currentPlayer.getName() + "'s turn.\n");

        List<GoFishPlayer> opponents = new ArrayList<>(players);
        opponents.remove(currentPlayer);
        GoFishPlayer opponentToAsk = currentPlayer.pickOpponentToAsk(opponents);

        Card cardPicked = currentPlayer.pickCard();
        System.out.println("\n" + currentPlayer.getName() + " asked " + opponentToAsk.getName() + " for a " + cardPicked + ".\n");

        if (opponentToAsk.hasCard(cardPicked)) {
            opponentToAsk.removeCard(cardPicked);
            currentPlayer.addCardToHand(cardPicked);
            System.out.println("\n" + opponentToAsk.getName() + " had that card. " + currentPlayer.getName() + " goes again.");
            System.out.println("=======================================\n\n");
            this.fillPlayerHands();
            this.takeTurn();
        } else {
            System.out.println("\n" + opponentToAsk.getName() + " did not have that card " + displaySecondLogo());
            if (deck.deck.isEmpty()) {
                System.out.println("\nThe deck is empty. No cards to draw.");
                System.out.println("=======================================\n");
                turnCounter++;
                return;
            }
            Card topCard = deck.getTopCard();
            deck.deck.remove(0);
            currentPlayer.addCardToHand(topCard);
            if (topCard.getRankEnum().equals(cardPicked.getRankEnum())) {
                System.out.println("\n" + currentPlayer.getName() + " picked their wish! " + currentPlayer.getName() + " gets a point. Go again.\n");
                System.out.println("=======================================\n");
                this.fillPlayerHands();
                this.takeTurn();

            } else {
                this.fillPlayerHands();
                System.out.println("=======================================\n");
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

    public String displayScores(ArrayList<GoFishPlayer> players) {
        System.out.println("=======================================");
        System.out.println("Score totals:\n");
        StringBuilder displayScores = new StringBuilder();
        for (int i = 0; i < players.size(); i++) {
            displayScores.append("\t> ")
                         .append(players.get(i).getName())
                         .append(": ")
                         .append(players.get(i).getNumPairs())
                         .append("\n")
                         .append("\t--------------\n");
        }
        System.out.println(displayScores.toString());
        return displayScores.toString();
    }

    public List<GoFishPlayer> determineWinner() {
        List<GoFishPlayer> winners = new ArrayList<>();
        int highestScore = 0;
        for (GoFishPlayer player: players) {
            int currentScore = player.getNumPairs();

            if (currentScore > highestScore) {
                highestScore = currentScore;
                winners.clear();
                winners.add(player);
            }
            else if(currentScore == highestScore) {
                winners.add(player);
            }
        }
        return winners;
    }

    public void gameOverMessage(List<GoFishPlayer> winners) {
        if(winners.size() > 1) {
            System.out.println("There was a tie!");
            for (int i = 0; i < winners.size(); i++) {
                System.out.println(displayCongrats());
                System.out.println("\n" + winners.get(i).getName() + ", you tied!\n");
            }
        }
        else {
            System.out.println(displayCongrats());
            System.out.println("\n" + winners.get(0).getName() + ", you win!\n");
        }
        this.displayScores(players);
        System.out.println("\nThat was fun! Game over.\n");
    }

    public String displayLogo() {
        StringBuilder logo = new StringBuilder("\n");

logo.append("   /$$$$$$                  /$$$$$$$$ /$$           /$$\n");
logo.append("  /$$__  $$                | $$_____/|__/          | $$\n");
logo.append(" | $$ \\__/  /$$$$$$        | $$       /$$  /$$$$$$$| $$$$$$$\n");
logo.append(" | $$ /$$$$ /$$__  $$      | $$$$$   | $$ /$$_____/| $$__  $$\n");
logo.append(" | $$|_  $$| $$ \\ $$       | $$__/   | $$|  $$$$$$ | $$  \\ $$\n");
logo.append(" | $$ \\ $$| $$  | $$       | $$      | $$\\____  $$ | $$  | $$\n");
logo.append(" |  $$$$$$/|  $$$$$$/      | $$      | $$ /$$$$$$$/| $$  | $$\n");
logo.append(" \\______/ \\______/         |__/      |__/|_______/ |__/  |__/\n");

    return logo.toString();
    }

    public String displaySecondLogo() {
        StringBuilder logo = new StringBuilder("\n\n");
        logo.append(" +-+-+ +-+-+-+-+\n");
        logo.append(" |G|o| |F|i|s|h|\n");
        logo.append(" +-+-+ +-+-+-+-+\n");
        return logo.toString();
    }

    public String displayCongrats() {
        StringBuilder congrats = new StringBuilder("\n");
        congrats.append("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        congrats.append("|C|o|n|g|r|a|t|u|l|a|t|i|o|n|s|\n");
        congrats.append("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+\n");
        return congrats.toString();
    }

    public void endGame() {

    }
}