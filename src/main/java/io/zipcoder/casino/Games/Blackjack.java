package io.zipcoder.casino.Games;


import io.zipcoder.casino.Games.Dealer.Dealer;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;

public class Blackjack implements Game {
    public void start(){
        Player sue = new Player("sue", 30, 1000);
        Dealer bkjkDealer = new Dealer();
        BlackjackPlayer sueBKJK = new BlackjackPlayer(sue);
    }

    public void startGame() {

    }

    public void endGame() {

    }
}
