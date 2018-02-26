package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.CrapsPlayer;
import io.zipcoder.casino.Players.Player;


public class Craps extends Dice implements Game {
    private CrapsPlayer mainPlayer;
    private Integer betUserPlaces = 0;
    private Integer playerBetAmount = 0;
    private Integer dieValue = 0;
    private Integer playerDecision = 1;

    public Integer getPlayerBetAmount() {
        return playerBetAmount;
    }

    public void setPlayerBetAmount(Integer playerBetAmount) {
        this.playerBetAmount = playerBetAmount;
    }

    protected void setDieValue(Integer dieValue) {
        this.dieValue = dieValue;
    }

    public void setBetUserPlaces(Integer betUserPlaces) {
        this.betUserPlaces = betUserPlaces;
    }


    public Craps(Player player) {
        this.mainPlayer = new CrapsPlayer(player);
    }



    private void userPlacesBet() {
        System.out.println("Hello! " + mainPlayer.getName() + "\n Please press\n 1 for Pass Line\n 2 for Don't Pass Line");
        InputOutput inputOutput = new InputOutput();
        this.betUserPlaces = inputOutput.scanForInt();
    }

    private void userBetAmount() {
        InputOutput inputOutput = new InputOutput();
        this.playerBetAmount = inputOutput.promptForInt("How much money do you bet?");
    }

    private Integer addDiceValuesTogether() {
        System.out.println("51");
        return dieValue = rollDice() + rollDice();
    }


    protected void passLineBetTurnSequence(Integer dieValue) {
        if (this.dieValue == 7 || this.dieValue == 11) {
            playerWins();
        } else if (this.dieValue == 2 || this.dieValue == 3 || this.dieValue == 12) {
            playerLoses();
        } else {
            passLineBetRollsNonWinOrLoseNumber(this.dieValue);
        }
    }

    protected void dontPassLineBetTurnSequence(Integer dieValue) {
        if (this.dieValue == 2 || this.dieValue == 3) {
            playerWins();
        } else if (this.dieValue == 7 || this.dieValue == 11) {
            playerLoses();
        } else {
            dontPassLineBetRollNonWinLoseNumber(this.dieValue);
        }
    }


    protected void playerWins() {

        System.out.println("You Win!");
        addFundsToWallet(this.playerBetAmount);
        willUserPlayAgain();

    }

    protected void playerLoses() {

        System.out.println("You Lose!");
        takeFundsFromWallet(this.playerBetAmount);
        willUserPlayAgain();
    }

    protected void passLineBetRollsNonWinOrLoseNumber(Integer dieValue) {

        do {
            addDiceValuesTogether();
        } while (this.dieValue != 7 || this.dieValue != dieValue);

        if (dieValue == 7) {
            playerLoses();
        } else if (this.dieValue == dieValue) {

            playerWins();
        }

    }

    protected void dontPassLineBetRollNonWinLoseNumber(Integer dieValue) {

        do {
            rollDice();
        } while (this.dieValue != 7 || this.dieValue != this.dieValue);

        if (this.dieValue == 7) {
            playerWins();
        } else if (this.dieValue == this.dieValue) {
            playerLoses();
        }

    }

    protected void takeFundsFromWallet(Integer playerBetAmount) {
        mainPlayer.lostMoney(this.playerBetAmount);
        System.out.println(playerBetAmount + " dollars were removed from your wallet!");
    }

    protected void addFundsToWallet(Integer playerBetAmount) {
        mainPlayer.wonMoney(this.playerBetAmount);
        System.out.println("Your winnings of " + playerBetAmount + " dollars were added to you wallet!");

    }

    protected void willUserPlayAgain() {
        String askPlayerToPlayAgain = "Do you want to play again?\n 1 for Yes!\n 2 for No!";
        InputOutput inputOutput = new InputOutput();
        this.playerDecision = inputOutput.promptForInt(askPlayerToPlayAgain);
    }

    public void startGame() {
        do {
            userPlacesBet();
            userBetAmount();
            addDiceValuesTogether();
            System.out.println("his");
            if (this.betUserPlaces == 1) {
                System.out.println("hdsjh");
                passLineBetTurnSequence(this.dieValue);
            } else {
                dontPassLineBetTurnSequence(this.dieValue);
            }

        } while (this.playerDecision == 1);
        endGame();

    }

    public void endGame() {
        String goodbye = "Thank you for playing!";
    }
}
