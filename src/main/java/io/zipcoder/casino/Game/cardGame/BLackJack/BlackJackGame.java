package io.zipcoder.casino.Game.cardGame.BLackJack;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.CardGame;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Game.cardGame.utilities.Hand;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;

public class BlackJackGame extends CardGame {

    private BlackJackPlayer user;
    private BlackJackPlayer dealer;

    public BlackJackGame (Profile userProfile) {

        super();
        user = new BlackJackPlayer(userProfile);
        dealer = new BlackJackPlayer(House.HOUSE_PROFILE);
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
