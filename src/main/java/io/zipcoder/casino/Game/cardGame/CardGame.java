package io.zipcoder.casino.Game.cardGame;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.GoFIsh.GoFishPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.House;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;

public abstract class CardGame implements Game {

    protected Deck deck;


    private int playerScore;
        private ArrayList<Player>players;


    public CardGame() {

        deck = new Deck();
    }


    public Deck getDeck(){

        return deck;
    }
    public int calculateScore(){
        return playerScore;
    }

    public Player decideWinner( Player player1, Player player2){

        return null;
    }
    public void addPlayer(Player player) {

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
