package io.zipcoder.casino.Games;


import io.zipcoder.casino.GameTools.Deck.BlackjackCard;
import io.zipcoder.casino.GameTools.Deck.BlackjackDeck;
import io.zipcoder.casino.GameTools.Deck.Card;
import io.zipcoder.casino.GameTools.Deck.Deck;
import io.zipcoder.casino.Games.Dealer.Dealer;
import io.zipcoder.casino.Interfaces.Game;
import io.zipcoder.casino.Players.BlackjackPlayer;
import io.zipcoder.casino.Players.Player;

import java.util.ArrayList;

public class Blackjack implements Game{

    protected ArrayList<BlackjackPlayer> playerList;
    protected Deck deck;
    protected Dealer bkjkDealer;

    public void startGame(){


    }

    public void endGame(){

    }

    public Blackjack(Player... players){
        deck = new Deck();
        bkjkDealer = new Dealer();
        playerList = new ArrayList<BlackjackPlayer>();
        for (Player rootPlayer:players) {
            playerList.add(new BlackjackPlayer(rootPlayer));
        }
    }

    public void runTurn(){
        //run turn method should initially draw from preset deck, hit once, and bust
        //this will see if we can get a game to move through functions procedurally
        //then we can see if we can put this function in a constructor
        //to kick the game off as soon as the game object is instantiated
    }

    public void deal(BlackjackPlayer currentPlayer){
        Card temp = this.deck.deck.get(0);
        currentPlayer.addToHand(temp);
        this.deck.deck.remove(0);
    }

    public void dealToDealer(){
        Card temp = this.deck.deck.get(0);
        this.bkjkDealer.addToHand(temp);
        this.deck.deck.remove(0);
    }

    public void initialHand(BlackjackPlayer... blackjackPlayers){
        for (BlackjackPlayer thisPlayer:blackjackPlayers) {
            this.deal(thisPlayer);
            this.deal(thisPlayer);
        }
        this.dealToDealer();
    }

    public boolean bustCheck(BlackjackPlayer currentPlayer){
        Integer handValue = currentPlayer.getHandValue();
        if (handValue > 21) return true;
        return false;
    }

    public boolean dealerHitCheck(){
        if (this.bkjkDealer.getHandValue() < 17) return true;
        return false;
    }

    public void dealerTurn(){
        
    }

}
