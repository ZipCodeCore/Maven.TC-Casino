package io.zipcoder.casino;

import java.util.ArrayList;

import static io.zipcoder.casino.Utilities.*;

public class BlackJackConsole extends Console {

    private String nameOfGame = "BlackJack";

    private BlackJack game = new BlackJack(1);
    private BlackJackPlayer currentPlayer;

    public void start() {
        setUpGame();
        playRoundsUntilAllPlayersCashOut(game.getPlayers());
    }

    public void setUpGame() {
        printMenuName(String.format("Welcome to %s\n", nameOfGame));
        int numPlayers = getNumPlayers(game.MIN_NUMBER_OF_PLAYERS, game.MAX_NUMBER_OF_PLAYERS);
        ArrayList<String> playerNames = getPlayerNames(numPlayers);
        ArrayList<Player<BlackJack>> players = new ArrayList<>();
        for(String name : playerNames) {
            BlackJackPlayer player = new BlackJackPlayer(name);
            players.add(player);
        }
        game.addPlayers(players);

    }

    @Override
    public void playRound() {
        System.out.println("\nDealing cards...\n");
        game.dealInitialCards();

        displayAllFaceUpCards();

        int currentPlayerIndex = 0;
        while(!allPlayersStayOrBust()) {
            currentPlayer = (BlackJackPlayer) game.getPlayers().get(currentPlayerIndex);
            System.out.printf("Player %d turn:\n", currentPlayerIndex+1);
            playerTakeTurn(currentPlayer);
            currentPlayerIndex++;
            currentPlayerIndex %= game.getNumPlayers();
        }
        dealerHitsUntilFinished();
    }

    public void displayAllFaceUpCards() {

    }

    public boolean allPlayersStayOrBust() {
        return false;
    }

    public void playerTakeTurn(BlackJackPlayer player) {
        makeBet();
        boolean finishedTurn = false;
        while(!finishedTurn) {
            finishedTurn = hitOrStay();
        }
    }

    public void makeBet() {

    }

    public boolean hitOrStay() {
        if(currentPlayer.hasBust()) {
            return true;
        }
        return false;
    }

    public void dealerHitsUntilFinished() {

    }

    @Override
    public String getNameOfGame() {
        return nameOfGame;
    }
}
