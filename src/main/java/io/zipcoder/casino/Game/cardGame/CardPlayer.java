package io.zipcoder.casino.Game.cardGame;

import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

public class CardPlayer extends Player {

    private Hand hand;
    private int score;
    private boolean isCurrentPlayer;
    Player player;


    public CardPlayer(Profile someProfile, Hand someHand) {
        super(someProfile);
        this.hand = someHand;
    }

    public void setScore(int newScore){

        this.score = newScore;
    }

    public int getScore(){

        return this.score;
    }

    public void setPlayer(Player player){
        this.player = player;

    }
    public Player getPlayer(){

        return this.player;
    }


    public void setHand (Hand aHand) {
        this.hand = aHand;
    }

    public Hand getHand () {
        return hand;
    }


}
