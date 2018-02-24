package io.zipcoder.casino.Game.cardGame;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;

public abstract class CardGame implements Game {

    protected Deck deck;
    private ArrayList<CardPlayer> cardPlayers;


    public CardGame() {

        deck = new Deck();
    }


    public Deck getDeck() {

        return deck;
    }

    public void deal() {

    }

    public int calculateScore() {
        return 0;
    }

    public Player decideWinner(Player player1, Player player2) {

        return null;
    }

    public void addPlayer() {


    }

    public void removePlayer(Player player) {

    }

    public void startGame() {

    }

    public void endGame() {

    }

    public String getRules() {

        return null;
    }

}
