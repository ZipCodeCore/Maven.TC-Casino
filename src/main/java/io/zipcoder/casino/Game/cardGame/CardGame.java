package io.zipcoder.casino.Game.cardGame;

import io.zipcoder.casino.CasinoUtilities.Console;
import io.zipcoder.casino.Game.Game;
import io.zipcoder.casino.Game.cardGame.BLackJack.BlackJackPlayer;
import io.zipcoder.casino.Game.cardGame.utilities.Deck;
import io.zipcoder.casino.Player;
import io.zipcoder.casino.Profile;

import java.util.ArrayList;

public abstract class CardGame implements Game {

    protected Deck deck;
    protected ArrayList<Player> players;
    //private Player winner;

    public CardGame() {
         deck = new Deck();
         players = new ArrayList<>();
    }
    private ArrayList<CardPlayer> cardPlayers;

    public Deck getDeck() {

        return deck;
    }

    public int calculateScore() {
        return 0;
    }

    public Player decideWinner(Player player1, Player player2) {

        return null;
    }

    public void addPlayer(Player player){
        if(players.contains(player)){
            Console.print("Error: Player already added to game - cannot add duplicate players");
        }
        else{
            players.add(player);
        }

    }
    public void removePlayer (Player player){
        if(!players.contains(player)){
            Console.print("Error: Player not in game - cannot remove nonexistent player");
        }
        else{
            players.remove(player);
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
