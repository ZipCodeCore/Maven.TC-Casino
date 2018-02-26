package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.CrapsPlayer;
import io.zipcoder.casino.Players.Player;



public class Craps extends Dice implements Game {
    private CrapsPlayer mainPlayer;
    private Integer betUserPlaces = 0;
    private Integer playerBetAmount = 0;
    private Integer playerDecision = 1;


    public Integer getPlayerBetAmount() {
        return playerBetAmount;
    }

    public void setPlayerBetAmount(Integer playerBetAmount) {
        this.playerBetAmount = playerBetAmount;
    }

    public Craps(Player player) {
        this.mainPlayer = new CrapsPlayer(player);
    }

    private void userPlacesBet() {
        System.out.println("Hello! " + mainPlayer.getName() + "\n Please press\n 1 for Pass Line\n 2 for Don't Pass Line");
        InputOutput inputOutput = new InputOutput();
        this.betUserPlaces = inputOutput.scanForInt();
    }

    protected boolean userBetAmount() {
        InputOutput inputOutput = new InputOutput();
        playerBetAmount = inputOutput.promptForInt("How much money do you bet?");
        if (playerBetAmount > mainPlayer.getMainPlayer().getBalance()) {
            System.out.println("You don't have enough to bet! Get Out of here!");
            return true;
        }
        return false;

    }

    private Integer addDiceValuesTogether() {
        System.out.println("*Rolls Dice*");
        Integer previousRoll = rollDice() + rollDice();
        return previousRoll;
    }



    protected void passLineBetTurnSequence(Integer previousRoll) {
        if (previousRoll == 7 || previousRoll == 11) {
            playerWins();
        } else if (previousRoll == 2 || previousRoll == 3 || previousRoll == 12) {
            playerLoses();
        } else {
            passLineBetRollsNonWinOrLoseNumber(previousRoll);
        }
    }

    protected void dontPassLineBetTurnSequence(Integer previousRoll) {
        if (previousRoll == 2 || previousRoll == 3) {
            playerWins();
        } else if (previousRoll == 7 || previousRoll == 11) {
            playerLoses();
        } else {
            dontPassLineBetRollNonWinLoseNumber(previousRoll);
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

    protected void passLineBetRollsNonWinOrLoseNumber(Integer previousRoll) {
        Integer currentRoll = 0;
        do {
            currentRoll = addDiceValuesTogether();

            if (currentRoll == 7) {
                playerLoses();
                break;

            } else if (currentRoll == previousRoll) {

                playerWins();
                break;
            }
        } while (currentRoll != 7 || currentRoll != previousRoll);

    }

    protected void dontPassLineBetRollNonWinLoseNumber(Integer previousRoll) {
        Integer currentRoll = 0;
        do {
            currentRoll = addDiceValuesTogether();

            if (previousRoll == 7) {
                playerWins();
                break;
            } else if (currentRoll == previousRoll) {
                playerLoses();
                break;
            }
        } while (currentRoll != 7 || currentRoll != previousRoll);

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
        Integer diceRoll;
        do {
            if (mainPlayer.getMainPlayer().getBalance() == 0) {
                System.out.println("You Have no money Left!");
                break;
            }
            System.out.println("\n" +
                    " ██████╗██████╗  █████╗ ██████╗ ███████╗    \n" +
                    "██╔════╝██╔══██╗██╔══██╗██╔══██╗██╔════╝    \n" +
                    "██║     ██████╔╝███████║██████╔╝███████╗    \n" +
                    "██║     ██╔══██╗██╔══██║██╔═══╝ ╚════██║    \n" +
                    "╚██████╗██║  ██║██║  ██║██║     ███████║    \n" +
                    " ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝╚═╝     ╚══════╝    \n" +
                    "                                            \n");
            userPlacesBet();
            if (userBetAmount() == true) break;
            diceRoll = addDiceValuesTogether();
            if (this.betUserPlaces == 1) {
                passLineBetTurnSequence(diceRoll);
            } else {
                dontPassLineBetTurnSequence(diceRoll);
            }


        } while (this.playerDecision == 1);
        endGame();

    }

    public void endGame() {
        System.out.println("Thank you for Playing!");
    }
}
