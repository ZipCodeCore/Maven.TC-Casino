package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.CrapsPlayer;


public class Craps extends Dice implements Game {
    private CrapsPlayer crapsPlayer = new CrapsPlayer();
    private InputOutput inputOutput = new InputOutput();
    private Integer playerBetAmount = 0;
    private Integer playerDecision = 1;
    private Integer betUserPlaces = 0;


    public Integer userPlacesBet() {
        System.out.println("Hello!");
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

    public void passLineWin() {
        if (userPlacesBet() == 1 && addDiceValuesTogether() == 7 || addDiceValuesTogether() == 11) {

            System.out.println("You Win!");
            addFundsToWallet();
            willUserPlayAgain();

        }
    }

    public String passLineLose() {
        if (userPlacesBet() == 1 && addDiceValuesTogether() == 2 || addDiceValuesTogether() == 3 || addDiceValuesTogether() == 12) {

            System.out.println("You Lose!");
            takeFundsFromWallet();
            willUserPlayAgain();
        }
        return null;
    }

    public String passLineBetRollsNonWinOrLoseNumber() {

        do {
            rollDice();
        } while (addDiceValuesTogether() != 7 || addDiceValuesTogether() != addDiceValuesTogether());

        if (addDiceValuesTogether() == 7) {
            System.out.println("You Lose!");
            takeFundsFromWallet();
            willUserPlayAgain();
        } else if (addDiceValuesTogether() == addDiceValuesTogether()) {

            System.out.println("You Win!");
            addFundsToWallet();
            willUserPlayAgain();
        }
        return null;
    }

    public String dontPassLineWin() {
        if (userPlacesBet() == 2 && addDiceValuesTogether() == 2 || addDiceValuesTogether() == 3) {

            System.out.println("You Win!");
            addFundsToWallet();
            willUserPlayAgain();

        }
        return null;
    }

    public String dontPassLineLose() {
        if (userPlacesBet() == 2 && addDiceValuesTogether() == 7 || addDiceValuesTogether()== 11) {

            System.out.println("You Lose!");
            takeFundsFromWallet();
            willUserPlayAgain();
        }
        return null;
    }

    public String dontPassLineBetRollNonWinLoseNumber() {

        do {
            rollDice();
        } while (addDiceValuesTogether() != 7 || addDiceValuesTogether()!= addDiceValuesTogether());

        if (addDiceValuesTogether()== 7) {
            System.out.println("You Win!");
            addFundsToWallet();
            willUserPlayAgain();
        } else if (addDiceValuesTogether() == addDiceValuesTogether()) {
            System.out.println("You Lose!");
            takeFundsFromWallet();
            willUserPlayAgain();
        }

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
           userPlacesBet();

        } while (playerDecision == 1);


    }

    public void endGame() {
       String goodbye = "Thank you for playing!";
    }
}
