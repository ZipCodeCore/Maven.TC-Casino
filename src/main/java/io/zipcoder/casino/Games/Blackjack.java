package io.zipcoder.casino.Games.Blackjack;

import io.zipcoder.casino.Player;

public class Blackjack {
    public void start(){
        Player sue = new Player("sue", 30, 1000.00);
        Dealer bkjkDealer = new Dealer();
        BlackjackPlayer sueBKJK = new BlackjackPlayer(sue);
    }
}
