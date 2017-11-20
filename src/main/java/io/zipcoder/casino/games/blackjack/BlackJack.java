package io.zipcoder.casino.games.blackjack;

import io.zipcoder.casino.games.CardGame;
import io.zipcoder.casino.games.Gamble;
import io.zipcoder.casino.nuts_n_bolts.User;
import io.zipcoder.casino.nuts_n_bolts.Pot;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingCard;
import io.zipcoder.casino.nuts_n_bolts.cards.PlayingDeck;

import java.util.ArrayList;

public class BlackJack extends CardGame implements Gamble {

    private Pot pot;
    private ArrayList<BlackJackPlayer> users;

    @Override
    public void play() {

    }

    @Override
    public void takeBet(Double bet) {
        //match biggest bet
    }

    @Override
    public void settleBet() {

    }

    public void evaluatePointsInHand(){}



    //setup game:
    //enter user, enter dealer, get fresh deck
    //start game
    //make bet
    //deal 2 cards each, dealer shows one
    //hit or stay?
    //dealer hits or stays
    //resolve winner
    //resolve bets
    //would you like to go another round?

    private class BlackJackPlayer{

        private ArrayList<PlayingCard> hand = new ArrayList<>();
        private User user;

        public BlackJackPlayer(User user) {
            this.user = user;
        }

        public void makeABet(Double money){}

        public void winABet(Double money){}

        public void hit(){}

        public void stay(){}



    }

}



/*
* private Player player;
    private Deck deck;
    private Player dealer;
    private Double pot;

    public Game(){
        player = new Player();
        deck = new Deck();
        dealer = new Player("Dealer");
        deck.shuffle();
        pot = 0.0;
    }

    public Double getPot() {
        return pot;
    }

    public void addToPot(Double amount) {
        this.pot += amount;
    }

    public Player getPlayer() {
        return player;
    }

    public Player getDealer() {
        return dealer;
    }

    public void start() {

        //Deal two cards to the player and the dealer
        for (int i = 0; i < 2; i++)
        {
            dealCard(player);
            dealCard(dealer);
        }

    }

    public boolean playerWins() {
        // if both player and dealer scores are = to 21 dealer wins
        // if both player and dealer score are over 21 then dealer wins
        // if player's score is <= 21 and players score is greater than dealers score then player wins.
        //if dealer's score is > 21 and player's score is <= 21 then players wins.
        player.calculateScore();
        dealer.calculateScore();

        if(     (player.getScore().equals(21) && !dealer.getScore().equals(21)) ||
                (player.getScore()<21 && dealer.getScore() < player.getScore()) ||
                (player.getScore() < 21 && dealer.getScore() > 21)) {
            //Player wins
            return true;
        }
        //Dealer wins
        return false;
    }

    public void dealCard(Player playerToReceiveCard){
        Card card = deck.getCard();
        playerToReceiveCard.addToHand(card);
    }

    public void dealerHitUntilFinished() {
        while (dealer.calculateScore() <= 17)
        {
            dealCard(dealer);
        }
    }

    public void returnBet() {
        if (playerWins()) {
            player.receiveWinnings(pot * 2);
        }
        else {
            this.pot = 0.0;
        }
    }
* */
