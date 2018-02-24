package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.CrapsPlayer;



public class Craps extends Dice implements Game{
CrapsPlayer crapsPlayer = new CrapsPlayer(); // go back an add main player
InputOutput inputOutput = new InputOutput();
private Integer playerBetAmount = 0;
private Integer betUserPlaces;
private Integer dieValue;

public Integer userPlacesBet(){
    System.out.println("Hello! " + crapsPlayer.getName());
    String askUserBet = "Please press\n 1 for Pass Line\n 2 for Don't Pass Line";
    Integer betUserPlaces = inputOutput.promptForInt(askUserBet);
    return betUserPlaces;
}

public Integer userBetAmount(){
    String askForBetAmount = ("How much money do you bet?");
    Integer playerBetAmount = inputOutput.promptForInt(askForBetAmount);
    return playerBetAmount;
}

public Integer addDiceValuesTogether(){
    Integer dieValue = rollDice() + rollDice();
    return dieValue;
}

public void passLineWin(Integer betUserPlaces, Integer dieValue){
  if (betUserPlaces == 1 &&  dieValue == 7 || dieValue == 11) {
      // call addFundsToWallet
      System.out.println("You Win!");
     // call willUserPlayAgain method

 }
}

public String passLineLose(Integer betUserPlaces, Integer dieValue){
    return null;
}

public String passLineBetRollNonWinLoseNumber(Integer betUserPlaces, Integer dieValue){
    //Roll dice while the value is not a win or lose value(Do while loop)
    return null;
}

public void takeFundsFromWallet(){
// call remove funds from wallet
}

public void addFundsToWallet(){
// add funds to wallet
//  System.out.println("Your winnings of " + playerBetAmount + " dollars were added to you wallet!");

}

public Integer willUserPlayAgain(){
    String askPlayerToPlayAgain = "Do you want to play again?\n 1 for Yes!\n 2 for No!";
    Integer playerDecision = inputOutput.promptForInt(askPlayerToPlayAgain);
    return playerDecision;
}

public void startGame(){
// take in user passlineWin if they say yes
}

public void endGame(){
    // take in passLineWin answer if they say no
   // in tests will be expected System.out.println(I hope you had fun! Thank You!");
}
public void returnToMainMenu(){
    //end game and go to different menu
}
}
