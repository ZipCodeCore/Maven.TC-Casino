package io.zipcoder.casino;

public class BlackJackPlayer extends CardPlayer {
    private Hand hand;


    public void startGame(Deck deck) {
        
    }

    public double showBalance() {

    }

    public Card hit(Deck deck) {
        return deck.pop();
    }

    public boolean stay() {

        return true;
    }


}
