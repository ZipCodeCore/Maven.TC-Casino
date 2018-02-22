package io.zipcoder.casino.Game.cardGame;

import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

public abstract class CardGame implements Game {

    private Deck deck;
    private ArrayList<Player>players;
    private int playerScore;
    private Player winner;

    public Deck getDeck(){
        return deck;
    }
    public int calculateScore(){
        return playerScore;
    }
    public Player decideWinner( Player player1, Player player2){
        return winner;
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
