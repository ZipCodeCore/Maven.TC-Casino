package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.CrapsPlayer;


public class Craps extends Dice implements Game {
    CrapsPlayer crapsPlayer = new CrapsPlayer();
    InputOutput inputOutput = new InputOutput();
    private Integer playerBetAmount = 0;
    private Integer betUserPlaces;
    private Integer dieValue;
    private Integer playerDecision = 1;

    public Integer userPlacesBet() {
        System.out.println("Hello! " + crapsPlayer.getName());
        String askUserBet = "Please press\n 1 for Pass Line\n 2 for Don't Pass Line";
        Integer betUserPlaces = inputOutput.promptForInt(askUserBet);
        return betUserPlaces;
    }

    public Integer userBetAmount() {
        String askForBetAmount = ("How much money do you bet?");
        Integer playerBetAmount = inputOutput.promptForInt(askForBetAmount);
        return playerBetAmount;
    }

    public Integer addDiceValuesTogether() {
        Integer dieValue = rollDice() + rollDice();
        return dieValue;
    }

    public void passLineWin(Integer betUserPlaces, Integer dieValue) {
        if (betUserPlaces == 1 && dieValue == 7 || dieValue == 11) {

            System.out.println("You Win!");
            addFundsToWallet();
            willUserPlayAgain();

        }
    }

    public String passLineLose(Integer betUserPlaces, Integer dieValue) {
        if (betUserPlaces == 1 && dieValue == 2 || dieValue == 3 || dieValue == 12) {

            System.out.println("You Lose!");
            takeFundsFromWallet();
            willUserPlayAgain();
        }
        return null;
    }

    public String passLineBetRollNonWinLoseNumber(Integer betUserPlaces, Integer dieValue) {
        //Roll dice while the value is not a win or lose value(Do while loop)
        do {
            rollDice();
        } while (dieValue != 7 || dieValue != dieValue);
        return null;
    }

    public String dontPassLineWin() {
        if (betUserPlaces == 2 && dieValue == 2 || dieValue == 3) {

            System.out.println("You Win!");
            addFundsToWallet();
            willUserPlayAgain();

        }
        return null;
    }

    public String dontPassLineLose() {
        if (betUserPlaces == 2 && dieValue == 7 || dieValue == 11) {

            System.out.println("You Lose!");
            takeFundsFromWallet();
            willUserPlayAgain();
        }
        return null;
    }

    public String dontPassLineBetRollNonWinLoseNumber(Integer betUserPlaces, Integer dieValue) {
        //Roll dice while the value is not a win or lose value(Do while loop)
        do {
            rollDice();
        } while (dieValue != 7 || dieValue != dieValue);
        return null;
    }

    public void takeFundsFromWallet() {
        crapsPlayer.getWallet().subtract(playerBetAmount);
        System.out.println(playerBetAmount + " dollars were removed from your wallet!");
    }

    public void addFundsToWallet() {
        crapsPlayer.getWallet().add(playerBetAmount);
        System.out.println("Your winnings of " + playerBetAmount + " dollars were added to you wallet!");

    }

    public Integer willUserPlayAgain() {
        String askPlayerToPlayAgain = "Do you want to play again?\n 1 for Yes!\n 2 for No!";
        Integer playerDecision = inputOutput.promptForInt(askPlayerToPlayAgain);
        return playerDecision;
    }

    public void startGame() {
        do {
            this.userPlacesBet();

        } while (willUserPlayAgain() == 1);
// take in user passlineWin if they say yes
    }

    public void endGame() {
        // take in passLineWin answer if they say no
        // no == 2;
        // in tests will be expected System.out.println(I hope you had fun! Thank You!");
    }

    public void returnToMainMenu() {
        //end game and go to different menu
        //
    }
}
