package io.zipcoder.casino.Games;

import io.zipcoder.casino.InputOutput.InputOutput;
import io.zipcoder.casino.Players.CrapsPlayer;

public class Craps extends Dice {
//CrapsPlayer crapsPlayer = new CrapsPlayer();
InputOutput inputOutput = new InputOutput();


public String userPlacesBet(){
    String askUserBet = "Do you bet Pass Line or Don't Pass Line?";
    String betUserPlaces = inputOutput.scanForString();
    return betUserPlaces;
}

public Integer addDieValuesTogether(){
    return null;
}

}
