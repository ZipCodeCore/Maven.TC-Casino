package io.zipcoder.casino;

import java.util.ArrayList;

import static io.zipcoder.casino.Utilities.*;

public class SlotsConsole extends Console {

    private String nameOfGame = "Slots";

    private Slots game = new Slots();
    private SlotsPlayer currentPlayer;

    int currentPlayerIndex = 0;

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
        ArrayList<SlotsPlayer> players = new ArrayList<>();
        for(String name : playerNames) {
            SlotsPlayer player = new SlotsPlayer(name);
            players.add(player);
        }
        game.addPlayers(players);
        getPlayerChips(game);
    }

    @Override
    public void playRound() {
        currentPlayer = game.getPlayers().get(currentPlayerIndex);
        if(currentPlayer.getMoney() > 0) {
            askContinueOrCashOut();
            if(currentPlayer.getMoney() > 0) {
                System.out.printf("Player %d turn:\n", currentPlayerIndex + 1);
                playerTakeTurn(currentPlayer);
            }
        }
    }

    public void askContinueOrCashOut() {
        System.out.println(game.printPlayersMoney());
        for(SlotsPlayer player : game.getPlayers()) {
            if(player.getMoney() > 0) {
                boolean cashOut = getYesOrNoInput(String.format("%s, Cash Out? Y or N", player.getName()));
                if(cashOut) {
                    player.cashOut();
                }
            }
        }
    }

    public void playerTakeTurn(SlotsPlayer player) {
        makeBet(player);
        String enter = getUserInput("Press enter to pull slot machine:");
        displaySlotMachine();
        game.payOutBets();
    }

    public void makeBet(SlotsPlayer player) {
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

    public void displaySlotMachine() {
        game.pullSlotMachine();
        System.out.println(game.printSlotMachine());
    }

    @Override
    public String getNameOfGame() {
        return nameOfGame;
    }
}
