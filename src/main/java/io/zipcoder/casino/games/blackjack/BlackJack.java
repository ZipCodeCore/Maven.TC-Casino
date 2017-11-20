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
