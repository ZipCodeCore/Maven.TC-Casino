package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.CrapsPlayer;



public class Craps extends Dice implements Game{
//CrapsPlayer crapsPlayer = new CrapsPlayer();
InputOutput inputOutput = new InputOutput();


public String userPlacesBet(){
    String askUserBet = "Do you bet Pass Line or Don't Pass Line?";
    String betUserPlaces = inputOutput.scanForString();
    return betUserPlaces;
}

public Integer addDieValuesTogether(){
    return rollDice() + rollDice();
}

public String passLineBetWin(){
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
    System.out.println("Wasn't that fun?");
}
public void playDifferentGame(){
    //end game and go to different menu
}
}
