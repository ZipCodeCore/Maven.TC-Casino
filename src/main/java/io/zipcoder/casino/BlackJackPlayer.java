package io.zipcoder.casino;

public class BlackJackPlayer extends CardPlayer {

    private double bet;

    public void startGame(Deck deck) {
        if (deck == null) {
            throw new IllegalStateException("Deck is null");
        }
    }

    public void setBet(double amount){
        this.bet = amount;
    }

    public double getBet() {
        return bet;
    }

    public double showBalance() {

        return 0;

    }

    public Card hit(Deck deck) {
        return deck.pop();
    }

    public boolean stay() {

        return true;
    }


}
