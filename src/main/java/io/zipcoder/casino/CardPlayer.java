package io.zipcoder.casino;

public class CardPlayer extends Player{

    private Hand hand;
    private int score;
    private boolean isCurrentPlayer;
    Player currentPlayer;

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
