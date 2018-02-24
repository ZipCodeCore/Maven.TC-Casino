package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;

import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;

public class BlackJackGame extends CardGame {
    BlackJackPlayer player;
    BlackJackPlayer dealer;

        player = new BlackJackPlayer(userProfile);
        this.addPlayer(player);
        dealer = new BlackJackPlayer(null);
        this.addPlayer(dealer);
    }

    public static void main(String[] args) {
        Profile someProfile = new Profile("Commander", 100.0, 1);
        BlackJackGame game = new BlackJackGame(someProfile);
        game.startGame();

    }

    public void deal() {

        for (int i = 0; i < 2; i++) {
            player.getHand().addCard(deck.getCard());
            // print card value to string
            dealer.getHand().addCard(deck.getCard());
        }
        // prints player hand

        Console.print(player.getHand().showHand());
    }


    public void hit(Player aPlayer) {

    }

    public void stand() {

    }

    public void round() {

    }

    public void dealerBehavior() {

    }


    @Override
    public void startGame() {
        //Console.print("Welcome to BlackJack! Please place your [Bet] amount");
        //player.bet(Console.getDouble());

        deal();
    }

    public void endGame() {

    }

    public String getRules() {
        return null;
    }


}
