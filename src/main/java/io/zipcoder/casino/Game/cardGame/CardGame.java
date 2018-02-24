package io.zipcoder.casino.Game.cardGame;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Player;

import java.util.ArrayList;

abstract public class CardGame implements Game {

    protected Deck deck;
    protected ArrayList<Player> players;
    //private Player winner;

    public CardGame() {
         deck = new Deck();
         players = new ArrayList<>();
    }

    public Deck getDeck() {

        return deck;
    }

    public int calculateScore() {
        return 0;
    }

    public Player decideWinner(Player player1, Player player2) {

        return null;
    }

    public void addPlayer(Player aPlayer){
        if(players.contains(aPlayer)){
            Console.print("Error: Player already added to game - cannot add duplicate players");
        }
        else{
            players.add(aPlayer);
        }

    }
    public void removePlayer (Player aPlayer){
        if(!players.contains(aPlayer)){
            Console.print("Error: Player not in game - cannot remove nonexistent player");
        }
        else{
            players.remove(aPlayer);
        }

    }

    public void startGame() {

    }

    public void endGame() {

    }

    public String getRules() {

        return null;
    }

}
