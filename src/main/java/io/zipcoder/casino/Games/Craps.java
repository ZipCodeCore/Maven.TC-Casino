package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.CrapsPlayer;
import io.zipcoder.casino.Players.Player;


public class Craps extends Dice implements Game{
CrapsPlayer crapsPlayer = new CrapsPlayer(); // go back an add main player
InputOutput inputOutput = new InputOutput();
private Integer playerBetAmount = 0;

public String userPlacesBet(){
    System.out.println("Hello! " + crapsPlayer.getName());
    String askUserBet = "Do you bet Pass Line or Don't Pass Line?";
    String betUserPlaces = inputOutput.promptForString(askUserBet);
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

public String passLineWin(){
    // if certain numbers they loose
    return null;
}

public String passLineBetLose(){
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
   // System.out.println("Wasn't that fun?");
}
public void returnToMainMenu(){
    //end game and go to different menu
}
}
