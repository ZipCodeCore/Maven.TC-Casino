package io.zipcoder.casino;

import java.util.ArrayList;

import static io.zipcoder.casino.Utilities.*;

public class BlackJackConsole extends Console {

    private String nameOfGame = "BlackJack";

    private BlackJack game = new BlackJack(1);
    private BlackJackPlayer currentPlayer;

    @Override
    public void start() {
        setUpGame();
        playRoundsUntilAllPlayersCashOut(game);
    }

    @Override
    public void setUpGame() {
        printMenuName(String.format("Welcome to %s", nameOfGame));
        int numPlayers = getNumPlayers(game.MIN_NUMBER_OF_PLAYERS, game.MAX_NUMBER_OF_PLAYERS);
        ArrayList<String> playerNames = getPlayerNames(numPlayers);
        ArrayList<BlackJackPlayer> players = new ArrayList<>();
        for(String name : playerNames) {
            BlackJackPlayer player = new BlackJackPlayer(name);
            players.add(player);
        }
        game.addPlayers(players);
        getPlayerChips(game);
    }

    @Override
    public void playRound() {
        for(BlackJackPlayer player : game.getPlayers()) {
            if(player.getMoney() > 0) {
                makeBet(player);
            }
        }

        System.out.println("\nDealing cards...\n");
        game.dealInitialCards();

        displayDealerFaceUpCard();

        for(int currentPlayerIndex = 0; currentPlayerIndex < game.getNumPlayers(); currentPlayerIndex++) {
            currentPlayer = game.getPlayers().get(currentPlayerIndex);
            if(game.getBets().containsKey(currentPlayer)) {
                System.out.printf("Player %d, %s turn:\n", currentPlayerIndex + 1, currentPlayer.getName());
                playerTakeTurn(currentPlayer);
            }
        }
        dealerHitsUntilFinished();
        displayEndOfRound();
        payOutBets();
        game.putCardsInDiscardPile();
        askContinueOrCashOut();
    }

    public void displayDealerFaceUpCard() {
        System.out.printf("Dealer showing %s\n\n", game.getDealer().getHand().getCard(0));
    }

    public void playerTakeTurn(BlackJackPlayer player) {
        boolean finishedTurn = false;
        while(!finishedTurn) {
            System.out.printf("Your cards: %s\n", player.getHand());
            finishedTurn = hitOrStay();
        }
    }

    public void makeBet(BlackJackPlayer player) {
        Double amountAvailableToBet = player.getMoney();
        Double amount = 0.0;
        boolean isValidInput = false;
        while(!isValidInput) {
            amount = getMoneyInput(String.format("%s, how much would you like to bet?", player.getName()));
            if(amount <= amountAvailableToBet) {
                isValidInput = true;
            } else {
                System.out.println("Sorry you do not have that much money to bet.");
            }
        }
        game.takeBet(player, amount);
    }

    public boolean hitOrStay() {
        boolean toHit = getYesOrNoInput("Do you want to hit? Y or N");
        if(toHit) {
            game.dealCardToHand(currentPlayer);
        } else {
            return true;
        }
        if(game.playerHasBust(currentPlayer)) {
            System.out.printf("Bust! %s\n", currentPlayer.getHand());
            return true;
        }
        return false;
    }

    public void dealerHitsUntilFinished() {
        while(game.calculatePlayerScore(game.getDealer()) <= 16 ||
                (game.calculatePlayerScore(game.getDealer()) == 17 && game.getDealer().hasAceInHand())) {
            game.dealCardToHand(game.getDealer());
        }
    }

    public void displayEndOfRound() {
        System.out.printf("\nDealer score: %d %s\n", game.calculatePlayerScore(game.getDealer()),
                game.getDealer().getHand());
        for(BlackJackPlayer player : game.getPlayers()) {
            if(game.getBets().containsKey(currentPlayer)) {
                System.out.printf("%s score: %d %s\n", player.getName(), game.calculatePlayerScore(player),
                        player.getHand());
            }
        }
    }

    public void payOutBets() {
        game.determineWinners();
        game.payOutBets();
    }

    public void askContinueOrCashOut() {
        System.out.println(game.printPlayersMoney());
        for(BlackJackPlayer player : game.getPlayers()) {
            if(player.getMoney() > 0) {
                boolean cashOut = getYesOrNoInput(String.format("%s, Cash Out? Y or N", player.getName()));
                if(cashOut) {
                    player.cashOut();
                }
            }
        }
    }

    @Override
    public String getNameOfGame() {
        return nameOfGame;
    }
}
