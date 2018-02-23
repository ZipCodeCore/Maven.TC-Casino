package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

public class BlackJackGame extends CardGame implements Game {


    public BlackJackGame (Profile userProfile) {

        BlackJackPlayer user = new BlackJackPlayer(userProfile);
        //BlackJackPlayer dealer = new BlackJackPlayer();
        Deck blackJackDeck = new Deck();

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
