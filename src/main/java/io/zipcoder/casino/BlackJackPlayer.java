package io.zipcoder.casino;

public class BlackJackPlayer extends CardPlayer implements PlayForMoney {

    private double bet;

    public BlackJackPlayer(String name) {
        super(name);
    }

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


    public double makeBet(Double amount) {
        return 0;
    }

    public double collectWinnings(boolean isWin) {
        return 0;
    }
}
