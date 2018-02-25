package io.zipcoder.casino.Game.cardGame;

import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

public abstract class CardPlayer extends Player {


    protected boolean isCurrentPlayer;
    protected Hand cardPlayerHand;
    protected int score;

    public CardPlayer(Profile someProfile) {
        super(someProfile);
        cardPlayerHand = new Hand();
        setHand(cardPlayerHand);
        this.isCurrentPlayer = isCurrentPlayer;
    }

    public void setScore(int newScore) {

        this.score = newScore;
    }

    public int getScore() {

        return this.score;
    }


    public void setHand(Hand aHand) {
        this.cardPlayerHand = aHand;
    }

    public Hand getHand() {
        return cardPlayerHand;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Score=" + score);
        return sb.toString();
    }

    public boolean isCurrentPlayer() {
        return isCurrentPlayer;
    }

    public void setCurrentPlayer(boolean currentPlayer) {
        isCurrentPlayer = currentPlayer;
    }
}
