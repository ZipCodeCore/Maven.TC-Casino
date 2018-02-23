package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;

public class BlackJackGame extends CardGame implements Game {

    private Deck blackJackDeck;
    private Hand dealerHand;
    private Hand userHand;

    public BlackJackGame (Profile userProfile) {

        BlackJackPlayer user = new BlackJackPlayer(userProfile);

        //userHand = new Hand(ArrayList<>);

        blackJackDeck = new Deck();


        //BlackJackPlayer dealer = new BlackJackPlayer();


    }


    public void deal () {

    }

    public void hit (Player aPlayer) {

    }

    public void stand() {

    }

    public void round () {

    }

    public void dealerBehavior() {

    }

    public void addPlayer(Player player) {

    }

    public void removePlayer (Player player) {

    }

    public void startGame() {

    }

    public void endGame() {

    }

    public String getRules() {
        return null;
    }


}
