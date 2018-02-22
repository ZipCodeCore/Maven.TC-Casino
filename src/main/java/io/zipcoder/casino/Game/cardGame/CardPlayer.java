package io.zipcoder.casino.Game.cardGame;

import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

public class CardPlayer extends Player {

    private Hand hand;
    private int score;
    private boolean isCurrentPlayer;
    Player currentPlayer;
    public CardPlayer(){

    }

    public CardPlayer(Profile someProfile) {
        super(someProfile);
    }
    public void setScore(int newScore){
        score = newScore;
    }

    public int getScore(){
        return score;
    }

    public void setCurrentPlayer(Player currentPlayer){
        currentPlayer = currentPlayer;

    }
    public Player getCurrentPlayer(){
        return currentPlayer;
    }




}
