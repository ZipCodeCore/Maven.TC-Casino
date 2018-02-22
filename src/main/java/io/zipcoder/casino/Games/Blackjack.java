package io.zipcoder.casino.Games;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.Games.Dealer.Dealer;
import io.zipcoder.casino.Players.BlackjackPlayer;

public class Blackjack {
    public void start(){
        Player sue = new Player("sue", 30, 1000.00);
        Dealer bkjkDealer = new Dealer();
        BlackjackPlayer sueBKJK = new BlackjackPlayer(sue);
    }
}
