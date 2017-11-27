package io.zipcoder.casino.BlackJackGame;

import io.zipcoder.casino.*;

public class BlackJack extends CardGames implements Gamble {
    private Player dealer;
    private Double pot;

    public BlackJack() {
        super();
        deck = new Deck();
        deck.shuffle();
        dealer = new Player("Dealer");
        pot = 0.0;
    }


    public Player getDealer() {
        return dealer;
    }

    public void setDealer(Player dealer) {
        this.dealer = dealer;
    }

    public Double getPot() {
        return pot;
    }

    public void setPot(Double pot) {
        this.pot = pot;
    }

    public void takeBet(Double amountToBet) {
        this.pot += amountToBet;
    }

    @Override
    public void play() {
        for (int i = 0; i < 2; i++) {
            dealCard(getPlayer());
            dealCard(dealer);
        }
    }

    public boolean playerWins() {
        // if both player and dealer scores are = to 21 dealer wins
        // if both player and dealer score are over 21 then dealer wins
        // if player's score is <= 21 and players score is greater than dealers score then player wins.
        // if dealer's score is > 21 and player's score is <= 21 then players wins.
        getPlayer().calculateScore();
        dealer.calculateScore();

        if(     (getPlayer().getScore().equals(21) && !dealer.getScore().equals(21)) ||
                (getPlayer().getScore()<21 && dealer.getScore() < getPlayer().getScore()) ||
                (getPlayer().getScore() < 21 && dealer.getScore() > 21)) {
            //Player wins
            return true;
        }
        //Dealer wins
        return false;
    }

    public void dealerHitUntilFinished() {
        while (dealer.calculateScore() <= 17)
        {
            dealCard(dealer);
        }
    }

    public void returnBet() {
        if (playerWins()) {
            getPlayer().receiveWinnings(pot * 2);
        }
        else {
            this.pot = 0.0;
        }
    }

    @Override
    public void dealCard(Player playerToReceiveCard){
        Card card = getDeck().getCard();
        playerToReceiveCard.addToHand(card);
    }


    @Override
    public void takeBet() {

    }
}