package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.CrapsPlayer;
import io.zipcoder.casino.Players.Player;



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

public String passLineWin(Integer betUserPlaces, Integer dieValue){
  if (betUserPlaces == 1 &&  dieValue == 7 || dieValue == 11) {
      // add funds to wallet
      System.out.println("You Win! Your winnings of " + playerBetAmount +  " dollars were added to you wallet!");
      String askPlayerToPlayAgain = "Do you want to play again?";
      String playerDecision = inputOutput.promptForString(askPlayerToPlayAgain);
      return playerDecision;
}
    return null;
}

public String passLineLose(Integer betUserPlaces, Integer dieValue){
    // if certain numbers they lose
    return null;
}

public String passLineBetRollNonWinLoseNumber(){
    //Roll dice while the value is not a win or lose value(Do while loop)
    return null;
}

public void startGame(){

}

public void endGame(){
   // System.out.println(I hope you had fun! Thank You!");
}
public void returnToMainMenu(){
    //end game and go to different menu
}
}
